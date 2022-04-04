<template>
  <div>
    <div id="registerQContainer">
      <h2>Registrering</h2>
    <select name="task" class="selector">
      <option value="" disabled selected hidden>Øving...</option>
      <option v-for="task in tasks" :key="task">
        {{ task }}
      </option>

    </select>
    <div>
      <div>
      <input type="radio" name="place" checked v-model="place" value="home" class="radio"/>
      <label>Hjemme</label>
    </div>
      <div>
      <input type="radio" name="place" v-model="place" value="school" class="radio"/>
      <label>Gløshaugen </label>
      </div>
      <div v-show="place === 'school'">
      <label>Bordnummer: </label>
      <select name="tableNumber" id="tableNumber" class="selector">
        <option v-for='(n, i) in 18' :key="n" :value="i">{{i + 1}}</option>
      </select>
      </div>
    </div>
    <img src="@/assets/roomPic.png" alt="Picture of the room" v-show="place === 'school'">
    <div>
      <input type="radio" id="approval" name="helpType" checked />
      <label for="approval">Godkjenning</label>
      <input type="radio" id="help" name="helpType" />
      <label for="help">Hjelp</label>
    </div>
      <button @click="registerToQueue">Registrer</button>
    </div>
  </div>
</template>

<script>
import {addToQueue, getSubject} from "@/utils/apiutils";
export default {
  name: "RegisterToQ",
  prop: {
    subjectID: Number
  },
  data () {
    return {
      taskNumber: '',
      place: 'home',
      helpType: '',
      message: '',
      tasks: '',
    }
  },
  methods: {
    async getTasks(){
      this.tasks = getSubject(this.subjectID).numTasks
    },
    registerToQueue(){
      const queueInfo = {task: this.taskNumber, tableNr: this.place, type: this.helpType, message: this.message}
      addToQueue(queueInfo)
    }
  },
  beforeMount() {
    this.getTasks()
  }
};
</script>

<style scoped>
input {
  margin: 10px;
}
#registerQContainer {
  font-size: 20px;
  height: 400px;
  overflow: scroll;
}
.selector {
  font-size: 16px;
  padding: 5px;
  border-radius: 20px;
  text-align: center;
}
#registerButton {
  background-color: darkblue;
  padding: 10px;
  font-size: 16px;
  border: none;
  color: white;
  border-radius: 10px;
}
#registerButton:hover {
  cursor: pointer;
}
@media only screen and (max-width: 600px) {
  #registerQContainer {
    display: flex;
    flex-direction: column;
  }
}
</style>
