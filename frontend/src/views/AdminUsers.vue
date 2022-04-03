<template>
  <div>
    <button @click="showModal">Legg til bruker</button>
    <User class="userObject"/>
    <div id="modalBackdrop" @click="closeModal" v-show="backdrop"></div>
    <AddUser v-if="addingUser" class="modalContent"/>
  </div>
</template>

<script>
import User from "@/components/User";
import AddUser from "@/components/AddUser";
export default {
  name: "UsersView",
  components: {
    User,
    AddUser
  },
  data (){
    return {
      users: [
        //TODO: GET ALL USERS
      ],
      backdrop: false,
      addingUser: false
    }
  },
  methods: {
    closeModal() {
      this.backdrop = false;
      this.addingUser = false;
    },

    showModal() {
      this.backdrop = true;
      this.addingUser = true;
    },
  }

}
</script>

<style scoped>
.userObject {
  margin: auto;
}
#modalBackdrop {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
.modalContent {
  z-index: 100; /* Sit on top */
  position: fixed; /* Stay in place */
  top: 10%;
  left: 50%;
  transform: translateX(-50%);
  background-color: #fefefe;
  padding: 20px;
  width: 500px;
  height: 80%;
  border-radius: 20px;
  border: 4px solid lightblue;
  overflow: scroll;
}
</style>