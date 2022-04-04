<template>
  <div>
    <router-link :to="{ name: 'Subjects' }">Aktive fag</router-link> |
    <router-link :to="{ name: 'ArchivedSubjects' }">Arkiverte fag</router-link>
    <div>
      <Subject v-for="(subject, index) in subjectsList"
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
      /* TODO: getSubjectsWhereStudent() and is archived*/
          [
          ],
    }
  },
};
</script>

<style scoped>
</style>
