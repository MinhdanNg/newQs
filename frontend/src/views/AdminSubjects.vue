<template>
  <div>
    <h2>Aktive fag</h2>
    <div>
      <Subject v-for="(subject, index) in activeSubjects"
               :key="index"
               :subject-code="subject.subjectCode"
               :subject-name="subject.subjectName"/>
    </div>
    <hr />
    <h3>Arkiverte fag</h3>
    <div>
      <Subject v-for="(subject, index) in inactiveSubjects"
               :key="index"
               :subject-code="subject.subjectCode"
               :subject-name="subject.subjectName"/>
    </div>
  </div>
</template>

<script>
import Subject from "@/components/Subject";
export default {
  name: "SubjectsView",
  components: {
    Subject,
  },
  data (){
    return {
      subjectsList: [{
        subjectCode: "IDATT2105",
        subjectName: "Fullstack",
        active: true,
      },
        {
          subjectCode: "IDATT2104",
          subjectName: "Nettverksprogrammering",
          active: false,
        },
        {
          subjectCode: "IDATT2106",
          subjectName: "Systemutvikling",
          active: true,
        }
      ],
    }
  },
  computed: {
    activeSubjects(){
      let activeSubjects = []
      this.subjectsList.forEach(s => {s.active ? activeSubjects.push(s) : null})
      return activeSubjects
    },
    inactiveSubjects(){
      let activeSubjects = []
      this.subjectsList.forEach(s => {!s.active ? activeSubjects.push(s) : null})
      return activeSubjects
    }
  }
};
</script>

<style scoped>
</style>
