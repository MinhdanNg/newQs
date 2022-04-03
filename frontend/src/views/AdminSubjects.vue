<template>
  <div>
    <button @click="showModal">Legg til fag</button>
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
    <div id="modalBackdrop" @click="closeModal" v-show="backdrop"></div>
    <AddSubject v-if="addingSubject" class="modalContent"/>
  </div>
</template>

<script>
import Subject from "@/components/Subject";
import AddSubject from "@/components/AddSubject";
export default {
  name: "SubjectsView",
  components: {
    AddSubject,
    Subject,
  },
  data (){
    return {
      subjectsList: [
          //TODO: GET ALL SUBJECTS
        {
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
      backdrop: false,
      addingSubject: false
    }
  },
  methods: {
    closeModal() {
      this.backdrop = false;
      this.addingSubject = false;
    },

    showModal() {
      this.backdrop = true;
      this.addingSubject = true;
    },
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
</style>
