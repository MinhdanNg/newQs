import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    username: "Kåre jensen",
    email: "",
    loginStatus: true,
    role: "admin",
    userInfo: {accessToken: "",
      userID: "",}
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
    SET_USERINFO(state, token, ID){
      state.userInfo.accessToken = token
      state.userInfo.userID = ID
    }
  },
  actions: {
    login(context, username, email, status) {
      context.commit("SET_USERNAME", username);
      context.commit("SET_EMAIL", email);
      context.commit("SET_STATUS", status);
      context.commit("SET_ROLE", "student");
    },
    logout(context) {
      context.commit("SET_USERNAME", "");
      context.commit("SET_EMAIL", "");
      context.commit("SET_STATUS", false);
      context.commit("SET_ROLE", "");
    },
  },
  modules: {},
});
