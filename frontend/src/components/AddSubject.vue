<template>
<div>
  <form action="">
    <label for="subjectCode">Fagkode</label>
    <input type="text" id="subjectCode" name="subjectCode">
    <label for="subjectName">Fagnavn</label>
    <input type="text" id="subjectName" name="subjectName">
    <label for="teachers">Lærere</label>
    <input type="text" id="teachers" name="teachers">
    <label for="teachAss">Øvingslærere</label>
    <input type="text" id="teachAss" name="teachAss">
    <label for="students">Studenter</label>
    <input type="text" id="students" name="students">
    <label for="tasks">Antall øvinger</label>
    <input type="number" id="tasks" name="tasks">
  </form>
</div>
</template>

<script>
export default {
  name: "AddSubject",
  methods: {
    addSubject(){
      
    }
  }
}
</script>

<style scoped>

</style>