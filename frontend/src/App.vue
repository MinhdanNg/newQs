<template>
  <div id="container">
    <div id="nav" v-if="$store.state.loginStatus">
      <img src="./assets/logo.png" alt="logo" id="logo" />
      <p id="usernameNav">{{ $store.state.username }}<button id="swapRole" @click="swapRole" v-if="!($store.state.role==='admin')"> {{$store.state.role}}</button></p>
      <div>
        <button class="navButtons" id="logOutButton" @click="logOut">
          <img src="./assets/logout.png" alt="Logg ut" id="logoutIcon" />
        </button>
      </div>
    </div>
    <div id="content">
      <AdminView v-if="$store.state.role === 'admin'"/>
      <router-view v-else/>
    </div>
  </div>
</template>

<script>
import AdminView from "@/views/AdminViews/AdminView";
export default {
  components: {
    AdminView,
  },
  methods: {
    swapRole() {
      if(this.$store.state.role === "student"){
        this.$store.commit("SET_ROLE", "læringsassistent")
      } else {
        this.$store.commit("SET_ROLE", "student")
      }
      if(this.$route.name !== 'Subjects'){
        this.$router.push({
          name: "Subjects",
        });
      }
    },
    logOut(){
      this.$store.dispatch("logout")
      this.$router.push({
        name: "Login",
      });
    }
  }
}
</script>
<style>
body {
  margin: 0;
}
#container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#content {
  width: 80%;
  margin: auto;
}

#nav a.router-link-exact-active {
  border-bottom: solid white 2px;
}
#nav {
  background-color: #333;
  display: flex;
  flex-direction: row;
  color: white;
}

#nav a:hover {
  border-bottom: solid white 2px;
  cursor: pointer;
}
.navButtons {
  font-size: 20px;
  background-color: transparent;
  border: none;
  border-bottom: solid transparent 2px;
  padding: 5px;
  margin: 8px;
  text-decoration: none;
  float: right;
  color: white;
  font-weight: normal;
}

#logoutIcon {
  height: 30px;
}
#logoutIcon:hover {
  cursor: pointer;
}
#logo {
  height: 30px;
  padding: 15px;
}
#usernameNav {
  flex-grow: 1;
  font-size: 20px;
}
#swapRole {
  background-color: darkblue;
  padding: 10px;
  font-size: 16px;
  border: none;
  color: white;
  border-radius: 10px;
}
#swapRole:hover {
  cursor: pointer;
}
@media only screen and (max-width: 600px) {
  #content {
    width: 100%;
  }
}
</style>
