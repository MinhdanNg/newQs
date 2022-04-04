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
// import { getSubjectsWhereStudent } from "@/utils/apiutils.js";

export default {
  name: "SubjectsView",
  components: {
    Subject,
  },
  data (){
    return {
      subjectsList:
      /* TODO: getSubjectsWhereStudent() if student, else get where assistant*/
          [
            { subjectCode: "1234",
              subjectName: "test",
              subjectID: 1,}
      ],
    }
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
  }
};
</script>

<style scoped>
</style>
