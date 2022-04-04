<template>
  <div>
    <h2>{{ studentName }}</h2>
    <div>
      <p>Studentens fag:</p>
      <Subject
        v-for="(subject, index) in subjectsList"
        :key="index"
        :subject-code="subject.subjectCode"
        :subject-name="subject.subjectName"
      />
    </div>
  </div>
</template>

<script>
import Subject from "@/components/Subject/Subject";
import { getSubjectsByUserID } from "@/utils/apiutils";
export default {
  name: "UserSubjects",
  components: { Subject },
  props: {
    studentName: String,
    studentID: String,
  },
  data() {
    return {
      subjectsList: [],
    };
  },
  methods: {
    async getSubjects() {
      const allSubjects = await getSubjectsByUserID(this.studentID);
      allSubjects.forEach((subject) =>
        this.subjectsList.push({
          archive: subject.archive,
          subjectCode: subject.code,
          subjectName: subject.name,
          subjectID: subject.subjectId,
        })
      );
    },
  },
};
</script>

<style scoped></style>
