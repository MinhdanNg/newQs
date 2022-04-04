<template>
  <div>
    <div id="registerQContainer">
      <h2>Registrering</h2>
      <select name="task" class="selector" v-model="taskNumber">
        <option value="" disabled selected hidden>Øving...</option>
        <option v-for="task in tasks" :key="task">
          {{ task }}
        </option>
      </select>
      <div>
        <div>
          <input
            type="radio"
            name="place"
            checked
            v-model="place"
            value="home"
            class="radio"
          />
          <label>Hjemme</label>
        </div>
        <div>
          <input
            type="radio"
            name="place"
            v-model="place"
            value="school"
            class="radio"
          />
          <label>Gløshaugen </label>
        </div>
        <div v-show="place === 'school'">
          <label>Bordnummer: </label>
          <select name="tableNumber" id="tableNumber" class="selector">
            <option v-for="(n, i) in 18" :key="n" :value="i">
              {{ i + 1 }}
            </option>
          </select>
        </div>
      </div>
      <img
        src="@/assets/roomPic.png"
        alt="Picture of the room"
        v-show="place === 'school'"
      />
      <div>
        <input
          type="radio"
          value="approval"
          name="helpType"
          checked
          v-model="helpType"
        />
        <label>Godkjenning</label>
        <input type="radio" value="help" name="helpType" v-model="helpType" />
        <label>Hjelp</label>
      </div>
      <button @click="registerToQueue" id="registerButton">Registrer</button>
    </div>
  </div>
</template>

<script>
import { addToQueue, getSubject } from "@/utils/apiutils";
export default {
  name: "RegisterToQ",
  data() {
    return {
      taskNumber: "",
      place: "home",
      helpType: "",
      tasks: "",
    };
  },
  methods: {
    async getTasks() {
      const numTasks = await getSubject(this.$store.state.currentSubjectId);
      this.tasks = numTasks.numTasks;
    },
    async registerToQueue() {
      const queueInfo = {
        task: parseInt(this.taskNumber),
        tableNr: this.place,
        type: this.helpType,
      };
      await addToQueue(this.$store.state.currentSubjectId, queueInfo);
      window.location.reload();
    },
  },
  beforeMount() {
    this.getTasks();
  },
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
