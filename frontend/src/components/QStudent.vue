<template>
  <div class="studentContainer">
    <p>{{ name }}</p>
    <p>Godkjenning</p>
    <p>Øving 7</p>
  </div>
</template>

<script>
export default {
  name: "QStudent"
}
</script>

<style scoped>
.studentContainer {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-around;
  text-align: left;
  border-left: 5px solid lightblue;
  padding: 2px 10px;
  margin: 2px;
}
.helping {
  border-left: 5px solid lightgreen;
}
</style>