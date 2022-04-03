<template>
  <div id="userContainer">
    <table>
      <tr>
        <td>
          <p>Jonathan Tran</p>
        </td>
        <td>
          <p>Jont@stud.ntnu.no</p>
        </td>
        <td>
          <p>Student</p>
        </td>
        <td>
          <p v-for="(subject,index) in userSubjects" :key="index">{{subject.subjectName}}: <span v-bind:class="{approved: subject.status==='Godkjent', unapproved: !(subject.status==='Godkjent')}">{{subject.status}}</span></p>
        </td>
        <td><button>Mer</button></td>
      </tr>
    </table>

  </div>
</template>

<script>
export default {
  name: "User",
  data (){
    return {
      userName: '',
      userEmail: '',
      userRole: '',
      userSubjects: [{subjectName: "Full-stack applikasjonsutvikling",
      status: "Godkjent"},
        {subjectName: "Nettverksprogrammering",
          status: "Ikke godkjent"},
        {subjectName: "Full-stack applikasjonsutvikling",
          status: "Godkjent"}],
    }
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
</style>