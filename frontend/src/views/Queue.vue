<template>
  <div id="queueContainer">
    <h1>{{ subjectName }}</h1>
    <button v-if="$store.state.role==='student'" id="queueUpButton" @click="showModal('register')">Still deg i kø</button>
    <div id="queueAndFilter">
      <div id="queue">
        <button
            v-for="(student, index) in queueList"
            :key="index"
            @click="showModal('help', index)"
            class="btnStudent"
        >
          <QStudent
            :username="student.username"
            :helpType="student.helpType"
            :taskNumber="student.task"
            :place="student.place"
            :TA="student.TA"
            :message="student.message"
          />
        </button>
        <div id="modalBackdrop" @click="closeModal" v-show="backdrop"></div>
        <HelpStudent
          class="modalContent"
          @borderStatus="updateBorderStatus()"
          v-bind:class="{ helpingStudentModal: isHelping }"
          v-show="helpStudentModal"
          :username="currentStudentModal.username"
          :studentID="currentStudentModal.studentId"
        />
        <RegisterToQ class="modalContent" id="registerModal" v-if="registerQModal"/>
      </div>
    </div>
  </div>
</template>

<script>
import QStudent from "@/components/Queue/QStudent.vue";
import HelpStudent from "@/components/Queue/HelpStudent";
import RegisterToQ from "@/components/Queue/RegisterToQ";
import {getQueueItems} from "@/utils/apiutils";

export default {
  name: "Queue",
  components: {
    RegisterToQ,
    HelpStudent,
    QStudent,
  },
  props: {
    subjectID: Number,
    subjectName: String,
  },
  data() {
    return {

      queueList: [],

      isHelping: false,
      helpStudentModal: false,
      registerQModal: false,
      backdrop: false,
      currentStudentModal: '',

    };
  },
  methods: {
    async getQueueItem(){
      const queueItems = await getQueueItems(this.subjectID)
      for (const item of queueItems) {
        item.assistedBy != null ? this.queueList.push({
              username: item.student.firstName + " " + item.student.lastName,
              helpType: item.type,
              task: item.tasks[0],
              place: item.table,
              TA: item.assistedBy.firstName + " " + item.assistedBy.lastName,
              studentId: item.student.id}) :
            this.queueList.push({username: item.student.firstName + " " + item.student.lastName,
              helpType: item.type,
              task: item.tasks[0],
              place: item.table,
              TA: "",
              studentId: item.student.id})
      }
    },
    closeModal() {
      this.backdrop = false;
      if(this.helpStudentModal){
        this.helpStudentModal = !this.helpStudentModal
      } else {
        this.registerQModal = !this.registerQModal;
      }
    },

    showModal(modal, index) {
      if(modal === "help" && this.$store.state.role === 'læringsassistent') {
        this.backdrop = true;
        this.helpStudentModal = true;
        this.currentStudentModal = this.queueList[index];
      } else if(modal === "register" && this.$store.state.role === 'student'){
        this.backdrop = true;
        this.registerQModal = true;
      }
    },
    updateBorderStatus() {
      this.isHelping = true;
    },
  },
  beforeMount() {
    this.getQueueItem()
  }
};
</script>
<style scoped>
#queueAndFilter {
  display: flex;
  flex-direction: row;
}
#queue {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}

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
  top: 20%;
  left: 50%;
  transform: translateX(-50%);
  background-color: #fefefe;
  padding: 20px;
  width: 500px;
  border-radius: 20px;
  border: 4px solid lightblue;
}
.helpingStudentModal {
  border: 4px solid lightgreen;
}

.btnStudent {
  border: none;
  background-color: transparent;
  margin: 5px;
  padding: 0;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 16px;
}
.btnStudent:hover {
  cursor: pointer;
}
#queueUpButton {
  background-color: darkblue;
  padding: 10px;
  font-size: 16px;
  border: none;
  color: white;
  border-radius: 10px;
}
#queueUpButton:hover {
  cursor: pointer;
}
@media only screen and (max-width: 600px) {
  .modalContent {
    width: 60%;
  }
}
</style>
