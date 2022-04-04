<template>
  <div>
    <h2>Legg til bruker</h2>
    <form id="userForm">
      <label>Brukerinformasjon: </label>
      <input type="text" placeholder="Format: Etternavn, fornavn, epost">
      <label>Bruker-type:</label>
      <div>
        <input type="radio" value="student" v-model="role" checked> <label>Student</label>
        <input type="radio" value="teacher" v-model="role"> <label>Lærer</label>
      </div>
      <div v-if="role === 'teacher'">
        <label>Fag</label>
        <p>Lærer i fagene:</p>
        <input type="text" placeholder="Søk etter emnekode" class="searchBox" v-model="search"/>
        <div class="allSubjects">
        <div v-for="(subject, index) in filteredList" :key="index">
          <input type="checkbox"> <label>{{ subject.subjectCode + " " + subject.subjectName }}</label>
        </div>
      </div>
      </div>
      <div v-if="role === 'student'">
        <label>Fag</label>
        <p>Student i fagene:</p>
        <div>
          <input type="text" placeholder="Søk etter emnekode" class="searchBox" v-model="search"/>
        </div>
        <div class="allSubjects">
            <div v-for="(subject, index) in filteredList" :key="index">
              <input type="checkbox"> <label>{{ subject.subjectCode + " " + subject.subjectName }}</label>
            </div>
        </div>
        <hr>
        <input type="checkbox" v-model="isTeachAss"><label>Læringsassistent</label>
        <div v-if="isTeachAss">
          <p>Læringsassistent i fagene:</p>
          <div class="allSubjects">
          <div v-for="(subject, index) in filteredList" :key="index">
            <input type="checkbox"> <label>{{ subject.subjectCode + " " + subject.subjectName }}</label>
          </div>
          </div>
        </div>
      </div>
      <input type="submit" @click="addUser">
    </form>
  </div>
</template>

<script>
export default {
  name: "AddUser",
  data (){
    return {
      isTeachAss: false,
      role: 'student',

      search: '',
      allSubjects: [
          {subjectName: "Full-stack Applikasjonsutvikling", subjectCode: "IDATT2105"},
        {subjectName: "Full-stack Applikasjonsutvikling", subjectCode: "hkkjhk"},
        {subjectName: "Full-stack Applikasjonsutvikling", subjectCode: "abcde"}
      ],
    }
  },
  computed: {
    filteredList() {
      return this.allSubjects.filter(subject => {
        return subject.subjectCode.toLowerCase().includes(this.search.toLowerCase())
      })
    }
  },
  methods: {
    addUser(){
      //TODO ADD USER
    }
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