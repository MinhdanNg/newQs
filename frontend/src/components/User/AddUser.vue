<template>
  <div>
    <h2>Legg til bruker</h2>
    <form id="userForm">
      <label>Brukerinformasjon: </label>
      <input type="text" placeholder="fornavn" v-model="firstName">
      <input type="text" placeholder="etternavn" v-model="lastName">
      <input type="text" placeholder="e-post" v-model="email">
      <label>Bruker-type:</label>
      <div>
        <input type="radio" value="student" v-model="role" checked> <label>Student</label>
        <input type="radio" value="teacher" v-model="role"> <label>Lærer</label>
      </div>
      <div v-if="role === 'student'">
        <label>Fag</label>
        <p>Student i fagene:</p>
        <div>
          <input type="text" placeholder="Søk etter emnekode" class="searchBox" v-model="search"/>
        </div>
        <div class="allSubjects">
            <div v-for="(subject, index) in filteredList" :key="index">
              <input type="checkbox" v-model="isStudentIn" :value="subject.subjectID"> <label>{{ subject.subjectCode + " " + subject.subjectName }}</label>
            </div>
        </div>
        <hr>
        <input type="checkbox" v-model="isTeachAss"><label>Læringsassistent</label>
        <div v-if="isTeachAss">
          <p>Læringsassistent i fagene:</p>
          <div class="allSubjects">
          <div v-for="(subject, index) in filteredList" :key="index">
            <input type="checkbox" v-model="isTeachAssIn" :value="subject.subjectID"> <label>{{ subject.subjectCode + " " + subject.subjectName }}</label>
          </div>
          </div>
        </div>
      </div>
      <input type="submit" @click="addUser">
    </form>
  </div>
</template>

<script>
import {addUser, getAllSubjects} from "@/utils/apiutils";

export default {
  name: "AddUser",
  data (){
    return {
      isTeachAss: false,
      role: 'student',

      search: '',
      firstName: '',
      lastName: '',
      email: '',
      subjectsList: [],
      isStudentIn: [],
      isTeachAssIn: [],
    }
  },
  computed: {
    filteredList() {
      return this.subjectsList.filter(subject => {
        return subject.subjectCode.toLowerCase().includes(this.search.toLowerCase())
      })
    }
  },
  methods: {
    async getSubjects() {
      const allSubjects = await getAllSubjects()
      allSubjects.forEach((subject) =>
          this.subjectsList.push({archive: subject.archive, subjectCode: subject.code, subjectName: subject.name, subjectID: subject.subjectId}))
    },
    async addUser(){
      let isTeacher = false
      if(this.role === "teacher") {
        isTeacher = true
      }
      await addUser({
        assistantSubjects: this.isTeachAssIn,
        email: this.email,
        firstName: this.firstName,
        lastName: this.lastName,
        studentSubjects: this.isStudentIn,
        teacher: isTeacher
      })
    }
  },
  beforeMount() {
    this.getSubjects()
  }
}
</script>

<style scoped>
#userForm {
  display: flex;
  flex-direction: column;
}
.allSubjects {
  border: solid 1px black;
  height: 200px;
  width: 450px;
  overflow: scroll;
  margin: auto;
}
.allSubjects > * {
  margin: 10px;
}
</style>