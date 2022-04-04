<template>
  <div>
    <h2>{{studentName}}</h2>
    <div>
      <p>Studentens fag:</p>
      <Subject v-for="(subject, index) in allSubjects"
               :key="index"
               :subject-code="subject.subjectCode"
               :subject-name="subject.subjectName"/>
    </div>
  </div>
</template>

<script>
import Subject from "@/components/Subject/Subject";
export default {
  name: "UserSubjects",
  components: {Subject},
  props: {
    studentName: String,
  },
  data (){
    return {
      allSubjects: [],
    }
  }
}
</script>

<style scoped>
</style>