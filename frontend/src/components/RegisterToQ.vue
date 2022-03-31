<template>
  <div>
    <select name="task" id="taskSelector" class="filterItem">
      <option value="" disabled selected hidden>Øving...</option>
      <option value="1">1</option>
      <option value="1">2</option>
      <option value="1">3</option>
      <!-- {{<option v-for="task in tasks" :key="task.number">
  {{ task.number }}
</option> }}-->
    </select>
    <div class="filterItem">
      <input type="radio" name="place" checked />
      <label for="approval">Hjemme</label>
      <input type="radio" name="place" />
      <label for="help">Gløshaugen</label>
    </div>

    <div class="filterItem">
      <input type="radio" id="approval" name="helpType" checked />
      <label for="approval">Godkjenning</label>
      <input type="radio" id="help" name="helpType" />
      <label for="help">Hjelp</label>
    </div>
    <label> Beskjed: </label>
    <input type="text" id="message" />
    <input type="submit" value="Still i kø" class="filterItem" @click="registerToQueue"/>
  </div>
</template>

<script>
import {addToQueue} from "@/utils/apiutils";
export default {
  name: "RegisterToQ",
  data () {
    return {
      taskNumber: '',
      place: '',
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
    }
  }
};
</script>

<style scoped>
#taskSelector {
  font-size: 16px;
  padding: 5px;
  border-radius: 20px;
  text-align: center;
}
</style>
