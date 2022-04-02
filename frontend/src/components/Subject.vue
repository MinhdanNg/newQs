<template>
  <div id="subjectContainer">
    <div id="subjectNames">
      <p>{{subjectCode}}</p>
      <h2>{{subjectName}}</h2>
<!--      <button class="infoButton" v-if="$store.state.role==='student'">Øvinger</button>-->
      <button @click="toQueue" class="infoButton" v-if="!($store.state.role==='admin')">Til kø</button>
      <div v-if="$store.state.role==='admin'">
        <button>Arkiver</button>
        <button>Slett</button>
        <button>Rediger</button>
        <button>Se mer</button>
      </div>
    </div>
    <div v-if="$store.state.role==='student'" id="subjectDetail" >
      <div id="taskInfo" class="tabContent">
        <div class="title">
          <h2>Øvinger</h2>
          <p>Status: Godkjent</p>
        </div>
        <div>
         <table class="taskTable">
           <tr>
             <th id="taskColumn">Øving</th>
             <th id="resultColumn">Resultat</th>
             <th id="commentColumn">Kommentar</th>
           </tr>
           <tr>
             <td>Øving 1</td>
             <td>Godkjent</td>
             <td>Levert for sent</td>
           </tr>
           <tr>
             <td>Øving 1</td>
             <td>Godkjent</td>
             <td>Levert for sent</td>
           </tr>
           <tr>
             <td>Øving 1</td>
             <td>Godkjent</td>
             <td>Levert for sent</td>
           </tr>
         </table>
        </div>
      </div>
      <div id="TAInfo" class="tabContent"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Subject",
  props: {
    subjectCode: String,
    subjectName: String,
  },
  data() {
    return {

    }
  },
  methods: {
    toQueue() {
      this.$router.push({
        name: "Queue",
      });
    },
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
  padding: 10px;
  font-size: 16px;
  margin: 5px;
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
  width: 15%
}
#resultColumn {
  width: 15%;
}
th, td {
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
