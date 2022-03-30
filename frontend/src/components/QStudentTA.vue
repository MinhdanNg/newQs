<template>
  <div class="studentContainer">
    <p id="name">{{ name }}</p>
    <p id="helpType">Godkjenning</p>
    <p id="task">Øving 7</p>
    <p id="time"></p>
    <p id="TA">Tonelise</p>
  </div>
</template>

<script>
export default {
  name: "QStudent",
  props: {
    name: String
  }
}
</script>

<style scoped>
.studentContainer {
  display: grid;
  grid-template-columns: 200px;
  grid-template-areas: 'name helpType task time TA';
  text-align: left;
  border: 1px solid lightblue;
  border-left: 20px solid lightblue;
  border-radius: 10px;
  padding: 2px 10px;
  margin: 5px;
}
#name {
  grid-area: name;
}
#helpType {
  grid-area: helpType;
}
#task {
  grid-area: task;
}
#time {
  grid-area: time;
}
#TA {
  grid-area: TA;
}
.pending {
  border-left: 8px solid yellow;
}
.helping {
  border-left: 8px solid lightgreen;
}
</style>