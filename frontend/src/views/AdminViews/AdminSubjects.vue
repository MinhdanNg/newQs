<template>
  <div>
    <button @click="showModal" class="infoButton">Legg til fag</button>
    <div>
      <input
        type="text"
        placeholder="Søk etter emnekode"
        class="searchBox"
        v-model="search"
      />
    </div>
    <h2>Aktive fag</h2>
    <div>
      <Subject
        v-for="(subject, index) in activeSubjects"
        :key="index"
        :subject-code="subject.subjectCode"
        :subject-name="subject.subjectName"
        :subjectID="subject.subjectID"
      />
    </div>
    <hr />
    <h3>Arkiverte fag</h3>
    <div>
      <Subject
        v-for="(subject, index) in inactiveSubjects"
        :key="index"
        :subject-code="subject.subjectCode"
        :subject-name="subject.subjectName"
        :subjectID="subject.subjectID"
      />
    </div>
    <div id="modalBackdrop" @click="closeModal" v-show="backdrop"></div>
    <AddSubject v-if="addingSubject" class="modalContent" />
  </div>
</template>

<script>
import Subject from "@/components/Subject/Subject";
import AddSubject from "@/components/Subject/AddSubject";
import { getAllSubjects } from "@/utils/apiutils";

export default {
  name: "SubjectsView",
  components: {
    AddSubject,
    Subject,
  },
  data() {
    return {
      subjectsList: [],
      backdrop: false,
      addingSubject: false,
      search: "",
    };
  },
  methods: {
    async getSubjects() {
      const allSubjects = await getAllSubjects();
      allSubjects.forEach((subject) =>
        this.subjectsList.push({
          archive: subject.archive,
          subjectCode: subject.code,
          subjectName: subject.name,
          subjectID: subject.subjectId,
        })
      );
    },
    closeModal() {
      this.backdrop = false;
      this.addingSubject = false;
    },

    showModal() {
      this.backdrop = true;
      this.addingSubject = true;
    },
  },
  beforeMount() {
    this.getSubjects();
  },
  computed: {
    activeSubjects() {
      let activeSubjects = [];
      this.subjectsList.forEach((s) => {
        !s.archive ? activeSubjects.push(s) : null;
      });
      return activeSubjects;
    },
    inactiveSubjects() {
      let activeSubjects = [];
      this.subjectsList.forEach((s) => {
        s.archive ? activeSubjects.push(s) : null;
      });
      return activeSubjects;
    },
    filteredList() {
      return this.subjectsList.filter((subject) => {
        return subject.subjectCode
          .toLowerCase()
          .includes(this.search.toLowerCase());
      });
    },
  },
};
</script>

<style scoped>
#modalBackdrop {
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0, 0, 0); /* Fallback color */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}
.modalContent {
  z-index: 100; /* Sit on top */
  position: fixed; /* Stay in place */
  top: 10%;
  left: 50%;
  transform: translateX(-50%);
  background-color: #fefefe;
  padding: 20px;
  width: 50%;
  border-radius: 20px;
  border: 4px solid lightblue;
}
.infoButton {
  padding: 8px;
  font-size: 14px;
  border-radius: 10px;
}
.infoButton:hover {
  cursor: pointer;
}
</style>
