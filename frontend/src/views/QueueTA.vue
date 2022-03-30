<template>
  <div id="queueContainer">
    <h1>Fag</h1>
    <div id="message"><p id="msg">Her er det en viktig melding til alle</p><button id="editMsg">Rediger</button></div>
    <p>Antall studenter: </p>
    <div id="queueAndFilter">
    <div id="queue">
    <QStudent name="Per Olav Jensen"/>
    <QStudent name="Jostein Brostein"/>
    <QStudent name="Alisa Felicia"/>
    <QStudent name="Kay Peele"/>
    </div>
    <div id="filter">
      <h2>Filter</h2>
      <select name="task" id="taskSelector" class="filterItem">
        <option value="" disabled selected hidden>Øving...</option>
        <option value="1">1</option>
        <option value="1">2</option>
        <option value="1">3</option>
        <!-- {{<option v-for="task in tasks" :key="task.number">
    {{ task.number }}
  </li> }}-->
      </select>
      <div class="filterItem">
        <input type="checkbox" id="approval" name="approval"
               checked>
        <label for="approval">Godkjenning</label>
        <input type="checkbox" id="help" name="help"
               checked>
        <label for="help">Hjelp</label>
      </div>
      <input type="submit" value="Søk" class="filterItem" id="submitFilter">
    </div>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src
import QStudent from "@/components/QStudentTA.vue";

export default {
  name: "TAQueue",
  components: {
    QStudent,
  },
};
</script>
<style scoped>
#message {
  background-color: #cdffc2;
  padding:10px;
  display: flex;
  flex-direction: row;
}
#msg{
  flex-grow: 1;
}
#editMsg {
  display: inline-block;
}
#queueAndFilter{
  display: flex;
  flex-direction: row;
}
#queue {
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
#taskSelector{
  font-size: 16px;
  padding: 5px;
  border-radius: 20px;
  text-align: center;
}
.filterItem{
  margin: 10px;
}
#submitFilter {
  font-size: 16px;
  padding: 10px 5px;
  border-radius: 10px;
  text-align: center;
  border: none;
  background-color: darkblue;
  color:white;
}

#submitFilter:hover{
  cursor: pointer;
  background-color: blue;
}
</style>