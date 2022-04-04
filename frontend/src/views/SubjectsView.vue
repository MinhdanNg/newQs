<template>
  <div>
    <router-link :to="{ name: 'Subjects' }">Aktive fag</router-link> |
    <router-link :to="{ name: 'ArchivedSubjects' }">Arkiverte fag</router-link>
    <h2>Aktiv kø</h2>
    <div v-if="$store.state.role === 'student'">
      <Subject
        v-for="(subject, index) in studentActiveQueues"
        :key="index"
        :subjectCode="subject.subjectCode"
        :subjectName="subject.subjectName"
        :subjectID="subject.subjectID"
      />
    </div>
    <div v-else>
      <Subject
        v-for="(subject, index) in teachAssActiveQueues"
        :key="index"
        :subjectCode="subject.subjectCode"
        :subjectName="subject.subjectName"
        :subjectID="subject.subjectID"
      />
    </div>
    <hr />
    <h3>Inaktiv kø</h3>
    <div v-if="$store.state.role === 'student'">
      <Subject
        v-for="(subject, index) in studentInactiveQueues"
        :key="index"
        :subjectCode="subject.subjectCode"
        :subjectName="subject.subjectName"
        :subjectID="subject.subjectID"
      />
    </div>
    <div v-else>
      <Subject
        v-for="(subject, index) in teachAssInactiveQueues"
        :key="index"
        :subjectCode="subject.subjectCode"
        :subjectName="subject.subjectName"
        :subjectID="subject.subjectID"
      />
    </div>
  </div>
</template>

<script>
import Subject from "@/components/Subject/Subject";
import {
  getQueue,
  getSubjectsWhereAssistant,
  getSubjectsWhereStudent,
} from "@/utils/apiutils.js";

export default {
  name: "SubjectsView",
  components: {
    Subject,
  },
  data() {
    return {
      studentSubjectsList: [],
      teachAssSubjectsList: [],

      studentActiveQueues: [],
      studentInactiveQueues: [],

      teachAssActiveQueues: [],
      teachAssInactiveQueues: [],
    };
  },
  methods: {
    async getSubjects() {
      const studentSubjects = await getSubjectsWhereStudent();
      studentSubjects.forEach((subject) =>
        subject.active
          ? this.studentSubjectsList.push({
              active: subject.active,
              subjectCode: subject.code,
              subjectName: subject.name,
              subjectID: subject.subjectId,
            })
          : null
      );
      const teachAssSubjects = await getSubjectsWhereAssistant();
      teachAssSubjects.forEach((subject) =>
        subject.active
          ? this.teachAssSubjectsList.push({
              active: subject.active,
              subjectCode: subject.code,
              subjectName: subject.name,
              subjectID: subject.subjectId,
            })
          : null
      );

      for (const subject of this.studentSubjectsList) {
        const status = await getQueue(subject.subjectID);
        status.active
          ? this.studentActiveQueues.push(subject)
          : this.studentInactiveQueues.push(subject);
      }
      for (const subject of this.teachAssSubjectsList) {
        const status = await getQueue(subject.subjectID);
        status.active
          ? this.teachAssActiveQueues.push(subject)
          : this.teachAssInactiveQueues.push(subject);
      }
    },
  },
  computed: {},
  beforeMount() {
    this.getSubjects();
  },
};
</script>

<style scoped></style>
