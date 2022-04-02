<template>
  <div id="loginContainer">
    <div id="username">
      <input v-model="email" type="text" id="emailInput" placeholder="Epost" />
    </div>
    <div id="password">
      <input
        v-model="password"
        type="password"
        id="passwordInput"
        placeholder="Passord"
      />
    </div>
    <button v-on:click="handleClickSignin">Logg inn</button>
    <label id="loginStatusMsg">{{ loginStatusMsg }}</label>
  </div>
</template>

<script>
/* eslint-disable */
import {doLogin} from "@/utils/apiutils.js";

export default {
  name: "LoginComponent",
  data() {
    return {
      email: '',
      password: '',
      loginStatus: '',
      loginStatusMsg: '',
    }
  },
  methods: {
    async handleClickSignin() {
      const loginRequest = {email: this.email, password: this.password};
      const loginResponse = await doLogin(loginRequest);

      this.loginStatus = "Failure";
      /*this.loginStatus = loginResponse.loginStatus;
      if (this.loginStatus === "Success") {
        this.$store.dispatch("login", loginResponse.username, this.email, true);

        await this.$router.push({
          name: "subjects",
        });
      } else*/ if(this.loginStatus === "Failure"){
        this.loginStatusMsg = "E-post eller passordet er feil. Prøv igjen."

        //Testing purposes
        await this.$router.push({
          name: "Subjects",
        });
      }
      console.log(loginResponse)
    },
  },
}
</script>

<style scoped>
input{
  background-color: transparent;
  border: 1px solid lightblue;
  border-radius: 5px;
  padding: 10px;
  margin: 5px;
}
</style>