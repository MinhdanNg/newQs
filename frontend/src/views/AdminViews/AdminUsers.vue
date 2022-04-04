<template>
  <div>
    <button @click="showModal('addUser')">Legg til bruker</button>
    <div>
      <input type="text" placeholder="Søk etter bruker" class="searchBox" v-model="search"/>
    </div>
    <div class="userBox"  v-for="(user, index) in users" :key="index">
      <User class="userObject"
            :userName="user.firstName + ' ' + user.lastName"
            :userEmail="user.email"
            :userRole="user.teacher"
            :userId="user.id"
      />

      <button @click="showModal('user')">Mer</button>
      <UserSubjects v-show="userSubjectsModal"
                    :studentName="'test'"
                    class="modalContent"/>
    </div>
    <div id="modalBackdrop" @click="closeModal" v-show="backdrop"></div>
    <AddUser v-if="addingUser" class="modalContent"/>
  </div>
</template>

<script>
import User from "@/components/User/User";
import AddUser from "@/components/User/AddUser";
import UserSubjects from "@/components/User/UserSubjects";
import {getAllUsers} from "@/utils/apiutils";

export default {
  name: "UsersView",
  components: {
    User,
    AddUser,
    UserSubjects
  },
  data() {
    return {
      users: getAllUsers(),
      backdrop: false,
      addingUser: false,
      userSubjectsModal: false,
      search: '',
    }
  },
  methods: {
    closeModal() {
      this.backdrop = false;
      this.addingUser = false;
      this.userSubjectsModal = false;
    },

    showModal(modal) {
      if (modal === "user") {
        this.backdrop = true;
        this.userSubjectsModal = true;
      } else {
        this.backdrop = true;
        this.addingUser = true;
      }
    },
    computed: {
      filteredList() {
        return this.users.filter(user => {
          return user.firstName.toLowerCase().includes(this.search.toLowerCase()) || user.lastName.toLowerCase().includes(this.search.toLowerCase())
        })
      },
    }
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
.userBox{
  display: flex;
  flex-direction: row;
}
</style>