<template>
  <div>
    <div id="helpContainer">
      <h1 class="containerItem">{{ this.username }}</h1>
      <button @click="helpStudent" id="helpStudentButton"
              :style="isHelping ? {backgroundColor: 'green'} : null " class="helpButton">
        {{ helpButton }}
      </button>
      <label class="containerItem"> Merknad: </label>
      <input type="text" class="containerItem" id="note" />
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
import {approveStudent, helpStudent, postponeStudent, rejectStudent} from "@/utils/apiutils";

export default {
  name: "HelpStudent",
  props: {
    username: String,
    studentID: Number,
    subjectID: Number,
  },
  data() {
    return {
      isHelping: false,
      helpButton: "Hjelp student"
    };
  },
  methods: {
    helpStudent() {
      if(this.isHelping){
        this.isHelping = false;
        this.helpButton = "Hjelp student";
        rejectStudent(this.subjectID, this.studentID)

      } else {
        this.$emit("borderStatus", "help");
        this.isHelping = true;
        this.helpButton = "Hjelper";
        helpStudent(this.subjectID, this.studentID)
      }
    },
    approveTask() {
      approveStudent(this.subjectID, this.studentID)
    },
    pendStudent() {
      postponeStudent(this.subjectID, this.studentID)
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