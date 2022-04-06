<template>
  <div>
    <div id="helpContainer">
      <h1 class="containerItem">{{ this.username }}</h1>
      <button
        @click="helpStudent"
        id="helpStudentButton"
        :style="isHelping ? { backgroundColor: 'green' } : null"
        class="helpButton"
      >
        {{ helpButton }}
      </button>
      <div class="containerItem">
        <button @click="approveTask" id="approveButton" class="helpButton">
          Godkjenn
        </button>
        <button @click="pendStudent" id="pendButton" class="helpButton">
          Avvent
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { approveStudent, helpStudent, postponeStudent } from "@/utils/apiutils";

export default {
  name: "HelpStudent",
  props: {
    username: String,
    studentID: String,
  },
  data() {
    return {
      isHelping: false,
      helpButton: "Hjelp student",
      subjectID: this.$store.state.currentSubjectId,
    };
  },
  methods: {
    helpStudent() {
      helpStudent();
      this.isHelping = true;
      this.helpButton = "Hjelper";
    },
    approveTask() {
      approveStudent(this.subjectID, this.studentID);
      window.location.reload();
    },
    pendStudent() {
      postponeStudent(this.subjectID, this.studentID);
      window.location.reload();
    },
  },
};
</script>

<style scoped>
#helpContainer {
  display: flex;
  flex-direction: column;
  padding: 10px;
}
.helpButton {
  padding: 10px;
  font-size: 16px;
  margin: 5px;
}
#note {
  width: 50%;
  margin: auto;
  padding: 5px;
  font-size: 16px;
}
.containerItem {
  margin: 5px;
}
#helpStudentButton {
  background-color: darkblue;
  color: white;
  border: none;
  border-radius: 10px;
  width: 50%;
  margin: 5px auto;
}
#helpStudentButton:hover {
  background-color: green;
  cursor: pointer;
}
#approveButton {
  background-color: transparent;
  border: 4px solid lightgreen;
}
#approveButton:hover {
  background-color: lightgreen;
  cursor: pointer;
}
#pendButton {
  background-color: transparent;
  border: 4px solid yellow;
}
#pendButton:hover {
  background-color: yellow;
  cursor: pointer;
}
</style>
