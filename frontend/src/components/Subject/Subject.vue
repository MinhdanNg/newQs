<template>
  <div id="subjectContainer">
    <div id="subjectNames">
      <p>{{ subjectCode }}</p>
      <h2>{{ subjectName }}</h2>
      <button
        @click="toQueue"
        class="infoButton"
        v-if="!($store.state.role === 'admin') && isActive"
      >
        Til kø
      </button>
      <div v-if="$store.state.role === 'læringsassistent'">
        <button v-if="!isActive" class="infoButton" @click="startQ">
          Start kø
        </button>
        <button v-else class="infoButton" @click="stopQ">Stopp kø</button>
      </div>
      <div v-if="$store.state.role === 'admin'">
        <button @click="archiveSubject" class="infoButton">Arkiver</button>
        <button @click="deleteSubject" class="infoButton">Slett</button>
      </div>
    </div>
    <div
      v-if="$store.state.role === 'student' || showUserTasks"
      id="subjectDetail"
    >
      <div id="taskInfo" class="tabContent">
        <div class="title">
          <h2>Øvinger</h2>
          <p>Status:</p>
        </div>
        <div>
          <table class="taskTable">
            <tr>
              <th id="taskColumn">Øving</th>
              <th id="resultColumn">Resultat</th>
              <th id="commentColumn">Kommentar</th>
            </tr>
            <tr v-for="(task, index) in taskList" :key="index">
              <td>Øving {{ task.taskNum }}</td>
              <td>{{ task.status }}</td>
            </tr>
          </table>
        </div>
      </div>
      <div id="TAInfo" class="tabContent"></div>
    </div>
  </div>
</template>

<script>
import {
  deleteSubject,
  archiveSubject,
  startQueue,
  stopQueue,
  getQueue,
  getSubjectsOverview,
} from "@/utils/apiutils";

export default {
  name: "Subject",
  props: {
    subjectCode: String,
    subjectName: String,
    subjectID: Number,
    showUserTasks: Boolean,
  },
  data() {
    return {
      isActive: "",
      taskList: [],
    };
  },
  methods: {
    async queueStatus() {
      const status = await getQueue(this.subjectID);
      this.isActive = status.active;
    },
    async taskStatus() {
      const taskstatus = await getSubjectsOverview().subjects;
      let counter = 1;
      for (const task in taskstatus) {
        this.taskList.push({
          taskNum: counter,
          status: task.tasks[counter - 1],
        });
        counter++;
      }
    },
    toQueue() {
      this.$router.push({
        name: "Queue",
        params: { subjectID: this.subjectID, subjectName: this.subjectName },
      });
      this.$store.commit("SET_SUBJECTID", this.subjectID);
    },
    async startQ() {
      await startQueue(this.subjectID);
      window.location.reload();
    },
    async stopQ() {
      await stopQueue(this.subjectID);
      window.location.reload();
    },
    async archiveSubject() {
      await archiveSubject(this.subjectID);
      window.location.reload();
    },
    deleteSubject() {
      deleteSubject(this.subjectID);
      window.location.reload();
    },
  },
  beforeMount() {
    this.queueStatus();
    this.taskStatus();
  },
};
</script>

<style scoped>
h2,
p,
h3 {
  margin: 0;
}
#subjectContainer {
  border-radius: 6px;
  border: 2px solid #25458a;
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  margin: 5px auto;
  padding: 0;
  width: 80%;
  height: 150px;
  overflow: scroll;
}
#subjectNames {
  text-align: left;
  background-color: #25458a;
  color: white;
  padding: 5px 20px;
  width: 280px;
}

#subjectDetail {
  flex-grow: 1;
}
.title {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-evenly;
  margin: 10px;
}
.infoButton {
  padding: 8px;
  font-size: 14px;
  border-radius: 10px;
}
.infoButton:hover {
  cursor: pointer;
}
.taskTable {
  text-align: center;
  padding: 5px;
  margin: auto;
  border-collapse: collapse;
}
#commentColumn {
  width: 70%;
}
#taskColumn {
  width: 15%;
}
#resultColumn {
  width: 15%;
}
th,
td {
  border-bottom: 1px solid dimgrey;
  padding: 10px;
}
@media only screen and (max-width: 600px) {
  #subjectContainer {
    border-radius: 6px;
    border: 2px solid #25458a;
    display: flex;
    flex-wrap: wrap;
    margin: 5px auto;
    padding: 0;
    height: 150px;
  }
  #subjectNames {
    text-align: left;
    background-color: #25458a;
    color: white;
    padding: 5px 20px;
    width: 100%;
  }
}
</style>
