<template>
  <div>
    <router-link :to="{ name: 'Subjects' }">Aktive fag</router-link> |
    <router-link :to="{ name: 'ArchivedSubjects' }">Arkiverte fag</router-link>
    <h2>Aktiv kø</h2>
    <div>
      <Subject v-for="(subject, index) in activeSubjects"
               :key="index"
               :subject-code="subject.subjectCode"
               :subject-name="subject.subjectName"/>
    </div>
    <hr />
    <h3>Inaktiv kø</h3>
    <div>
      <Subject v-for="(subject, index) in inactiveSubjects"
               :key="index"
               :subject-code="subject.subjectCode"
               :subject-name="subject.subjectName"/>
    </div>
  </div>
</template>

<script>
import Subject from "@/components/Subject/Subject";
import {getSubjectsWhereAssistant, getSubjectsWhereStudent} from "@/utils/apiutils.js";

export default {
  name: "SubjectsView",
  components: {
    Subject,
  },
  data (){
    return {
      subjectsList: [],
    }
  },
  methods: {
    async getSubjects() {
      if(this.$store.state.role==='student'){
        const allSubjects = await getSubjectsWhereStudent()
        allSubjects.forEach((subject) =>
            this.subjectsList.push({archive: subject.archive, subjectCode: subject.code, subjectName: subject.name}))
      } else if(this.$store.state.role==='læringsassistent'){
        const allSubjects = await getSubjectsWhereAssistant()
        allSubjects.forEach((subject) =>
            this.subjectsList.push({archive: subject.archive, subjectCode: subject.code, subjectName: subject.name}))
      }
    },
  },
  computed: {
    activeSubjects(){
      let activeSubjects = []
      this.subjectsList.forEach(s => {s.isActive ? activeSubjects.push(s) : null})
      return activeSubjects
    },
    inactiveSubjects(){
      let activeSubjects = []
      this.subjectsList.forEach(s => {!s.isActive ? activeSubjects.push(s) : null})
      return activeSubjects
    }
  }, beforeMount() {
    this.getSubjects()
  }
};
</script>

<style scoped>
</style>
