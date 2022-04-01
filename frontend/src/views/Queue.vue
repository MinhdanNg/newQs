<template>
  <div id="queueContainer">
    <h1>{{ subjectName }}</h1>
    <!-- CAN BE DELETED
    <div id="message">
      <p id="msg">Her er det en viktig melding til alle</p>
      <button id="editMsg">Rediger</button>
    </div>
    <p>Antall studenter:</p>
    -->

    <button v-if="$store.state.role==='student'" id="queueUpButton" @click="showModal('register')">Still deg i kø</button>
    <div id="queueAndFilter">
      <div id="queue">
        <button
            v-for="(student, index) in studentTestList"
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
          class="modal-content"
          @borderStatus="updateBorderStatus()"
          v-bind:class="{ helpingStudentModal: isHelping }"
          v-show="helpStudentModal"
          :username="currentStudentModal.username"
          :message="currentStudentModal.message"
        />
        <RegisterToQ class="modal-content" id="registerModal" v-if="registerQModal"/>
      </div>
<!-- ADD IF YOU HAVE TIME
<div id="filter">
        <h2>Filter</h2>
        <select name="task" id="taskSelector" class="filterItem">
          <option value="" disabled selected hidden>Øving...</option>
          <option value="1">Alle</option>
          <option value="1">1</option>
          <option value="1">2</option>
          <option value="1">3</option>
          &lt;!&ndash; {{<option v-for="task in tasks" :key="task.number">
    {{ task.number }}
  </option> }}&ndash;&gt;
        </select>
        <div class="filterItem">
          <input type="checkbox" id="approval" name="approval" checked />
          <label for="approval">Godkjenning</label>
          <input type="checkbox" id="help" name="help" checked />
          <label for="help">Hjelp</label>
        </div>
        <input type="submit" value="Søk" class="filterItem" id="submitFilter" />
      </div>-->
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import QStudent from "@/components/QStudent.vue";
import HelpStudent from "@/components/HelpStudent";
import RegisterToQ from "@/components/RegisterToQ";

export default {
  name: "Queue",
  components: {
    RegisterToQ,
    HelpStudent,
    QStudent,
  },
  data() {
    return {
      subjectName: "Fag",
      subjectMaxTask: 0,
      isHelping: false,
      helpStudentModal: false,
      registerQModal: false,
      backdrop: false,
      currentStudentModal: 'test',

      studentTestList: [
        {
          username: "Josten Brosten",
          helpType: "Godkjenning",
          task: "2",
          place: "Digital",
          TA: "Tonelise Pedersen",
          message: 'får ikke til øving 2',
        },
        {
          username: "Hallgeir Brosten",
          helpType: "Godkjenning",
          task: "2",
          place: "",
          TA: "Kari Treskål",
          message: '',
        },
        {
          username: "Janne Panne",
          helpType: "Hjelp",
          task: "3",
          place: "Digital",
          TA: "",
          message: 'jeg trenger hjelp',
        },
        {
          username: "Hanne Lange",
          helpType: "Hjelp",
          task: "3",
          place: "",
          TA: "",
          message: '',
        },
      ],

    };
  },
  methods: {
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
        this.currentStudentModal = this.studentTestList[index];
      } else if(modal === "register" && this.$store.state.role === 'student'){
        this.backdrop = true;
        this.registerQModal = true;
      }
    },
    updateBorderStatus() {
      this.isHelping = true;
    },
  },
};
</script>
<style scoped>
#message {
  background-color: #cdffc2;
  padding: 10px;
  display: flex;
  flex-direction: row;
}
#msg {
  flex-grow: 1;
}
#editMsg {
  display: inline-block;
}
#queueAndFilter {
  display: flex;
  flex-direction: row;
}
#queue {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
}
#filter {
  position: sticky;
  display: flex;
  flex-direction: column;
  border-radius: 20px;
  border: solid 1px lightblue;
  width: 200px;
  height: 250px;
  padding: 10px;
}
#taskSelector {
  font-size: 16px;
  padding: 5px;
  border-radius: 20px;
  text-align: center;
}
.filterItem {
  margin: 10px;
}
#submitFilter {
  font-size: 16px;
  padding: 10px 5px;
  border-radius: 10px;
  text-align: center;
  border: none;
  background-color: darkblue;
  color: white;
}

#submitFilter:hover {
  cursor: pointer;
  background-color: blue;
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
.modal-content {
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
  .modal-content {
    width: 60%;
  }
}
</style>
