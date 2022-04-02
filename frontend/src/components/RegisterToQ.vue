<template>
  <div>
    <div id="registerQContainer">
      <h2>Registrering</h2>
    <select name="task" class="selector">
      <option value="" disabled selected hidden>Øving...</option>
      <option value="1">1</option>
      <option value="1">2</option>
      <option value="1">3</option>
      <!-- {{<option v-for="task in tasks" :key="task.number">
  {{ task.number }}
</option> }}-->
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
        <option v-for='(n, i) in 18' :key="n" value="i">{{i + 1}}</option>
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
    <label> Beskjed: </label>
    <input type="text" id="message" />
    <input type="submit" value="Still i kø" class="filterItem" @click="registerToQueue" id="registerButton"/>
    </div>
  </div>
</template>

<script>
import {addToQueue} from "@/utils/apiutils";
export default {
  name: "RegisterToQ",
  data () {
    return {
      taskNumber: '',
      place: 'home',
      helpType: '',
      message: '',
    }
  },
  methods: {
    registerToQueue(){
      const queueInfo = {taskNumber: this.taskNumber, place: this.place, helpType: this.helpType, message: this.message}
      const queueStatus = addToQueue(queueInfo)

      if(queueStatus === "success"){
        console.log("success")
      }
      this.$emit("stopwatchStart")
    }
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
