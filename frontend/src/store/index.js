import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex);
const store = new Vuex.Store({
  plugins: [createPersistedState({
    storage: window.sessionStorage,
  })],
  state: {
    username: "",
    email: "",
    loginStatus: false,
    role: "",
    userID: "",
    accessToken: "",
  },
  getters: {
    token: function (state) {
      return state.accessToken
    }
  },
  mutations: {
    SET_USERNAME(state, username) {
      state.username = username;
    },
    SET_EMAIL(state, email) {
      state.email = email;
    },
    SET_STATUS(state, status) {
      state.loginStatus = status;
    },
    SET_ROLE(state, role) {
      state.role = role;
    },
    SET_TOKEN(state, token){
      state.accessToken = token
    },
    SET_USERID(state, id){
      state.userID = id
    }
  },
  actions: {
    login(context, {username, email, token, userID, teacher}) {
      context.commit("SET_USERNAME", username);
      context.commit("SET_EMAIL", email);
      context.commit("SET_STATUS", true);
      context.commit("SET_TOKEN", token);
      context.commit("SET_USERID", userID);
      if(teacher){
        context.commit("SET_ROLE", "admin");
      } else {
        context.commit("SET_ROLE", "student");
      }
    },
    logout(context) {
      context.commit("SET_USERNAME", "");
      context.commit("SET_EMAIL", "");
      context.commit("SET_STATUS", false);
      context.commit("SET_ROLE", "");
      sessionStorage.clear();
    },
  },
});

export default store;
