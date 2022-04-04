<template>
  <div class="home">
    <h1>Velkommen</h1>
    <Login />
  </div>
</template>

<script>
// @ is an alias to /src
import Login from "@/components/Login.vue";

export default {
  name: "Home",
  components: {
    Login,
  },
};
</script>
<style>
.home {
  border: 2px solid lightblue;
  padding: 20px 50px;
  border-radius: 10px;
  position: absolute;
  left: 50%;
  top: 40%;
  transform: translate(-50%, -50%);
}
</style>
