<template>
  <div id="loginContainer">
    <div id="username">
      <input v-model="email" type="text" id="emailInput" placeholder="Epost"/>
    </div>
    <div id="password">
      <input
        v-model="password"
        type="password"
        id="passwordInput"
        placeholder="Passord"
      />
    </div>
    <button v-on:click="handleClickSignin" id="loginButton">Logg inn</button>
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
      const loginRequest = {username: this.email, password: this.password, };
      const loginResponse = await doLogin(loginRequest);

      const loginInfo = {username: "abc", email: this.email, token: loginResponse.accessToken, userID: "afds2"}
      //this.$store.dispatch("login", loginResponse.firstName + " "+ loginResponse.lastName, this.email, loginResponse.accessToken, loginResponse.userId)
      this.$store.dispatch("login", loginInfo)
      await this.$router.push({
        name: "Subjects",
      })
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
#loginButton {
  background-color: darkblue;
  color: white;
  padding: 10px;
  font-size: 16px;
  border: none;
  border-radius: 10px;
  margin: 10px;
}
</style>