<template>
  <div id="loginContainer">
    <div id="username">
      <BaseInput v-model="email" type="email" id="emailInput" placeholder="Epost"
             :error="emailError"/>
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
import { useField, useForm } from 'vee-validate'
import BaseInput from "@/components/BaseInput";

export default {
  name: "LoginComponent",
  components: {
    BaseInput,
  },
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
      //const loginResponse = await doLogin(loginRequest);

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
    },
  },
  setup () {
    const validations = {
      email: value => {
        if (!value) return 'This field is required'

        const regex = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        if (!regex.test(String(value).toLowerCase())) {
          return 'Please enter a valid email address'
        }
        return true
      },
    }
    useForm({
      validationSchema: validations
    })
    const { value: email, errorMessage: emailError } = useField('email')

    return {
      email,
      emailError,
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