<template>
  <div id="loginContainer">
    <div id="username">
      <input v-model="username" type="text" id="usernameInput" placeholder="Epost"/>
    </div>
    <div id="password">
      <input v-model="password" type="password" id="passwordInput" placeholder="Passord"/>
    </div>
    <button v-on:click="handleClickSignin">Logg inn</button>
  </div>
</template>

<script>
/* eslint-disable */
export default {
  name: "LoginComponent",
  props: {
    title: String
  },
  methods: {
    async handleClickSignin() {
      const loginRequest = {username: this.username, password: this.password};
      const loginResponse = await doLogin(loginRequest);
      this.loginStatus = loginResponse.loginStatus;
      if (this.loginStatus === "Success") {
        this.$store.dispatch("login", this.username, true);
        this.$emit("success");

        await this.$router.push({
          name: "Home",
        });
      } else {
        this.$emit("failure");
      }
    },
  },
  data() {
    return {
      username: '',
      password: '',
    }
  }
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