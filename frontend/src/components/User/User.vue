<template>
  <div id="userContainer">
    <table>
      <tr>
        <td>
          <p>{{userName}}</p>
        </td>
        <td>
          <p>{{userEmail}}</p>
        </td>
        <td>
          <p>{{userRole}}</p>
        </td>
        <td>
          <p v-for="(subject,index) in userSubjects" :key="index">{{subject.subjectName}}: <span v-bind:class="{approved: subject.status==='Godkjent', unapproved: !(subject.status==='Godkjent')}">{{subject.status}}</span></p>
        </td>
      </tr>
    </table>

  </div>
</template>

<script>
import {getSubjectsByUserID} from "@/utils/apiutils";

export default {
  name: "User",
  props: {
    userName: String,
    userEmail: String,
    userRole: String,
    userId: Number,
  },
  data (){
    return {
      userSubjects: [{subjectName: "Full-stack applikasjonsutvikling",
      status: "Godkjent"},
        {subjectName: "Nettverksprogrammering",
          status: "Ikke godkjent"},
        {subjectName: "Full-stack applikasjonsutvikling",
          status: "Godkjent"}],

    }
  },
  methods: {
    async getSubjects() {
        const allSubjects = await getSubjectsByUserID(this.userId)
        allSubjects.forEach((subject) =>
            this.subjectsList.push({archive: subject.archive, subjectCode: subject.code, subjectName: subject.name}))
    },
    closeModal() {
      this.backdrop = false;
      this.userSubjectsModal = false;
    },

    showModal() {
        this.backdrop = true;
        this.userSubjectsModal = true;
    },
  }
}
</script>

<style scoped>
td {
  padding: 15px;
}
.approved {
  background-color: lightgreen;
}
.unapproved {
  background-color: lightcoral;
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
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
  background-color: #fefefe;
  padding: 20px;
  width: 500px;
  border-radius: 20px;
  border: 4px solid lightblue;
}
</style>