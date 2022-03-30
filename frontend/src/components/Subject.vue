<template>
  <div id="subjectContainer">
    <div id="subjectNames">
      <p>IDATT2105</p>
      <h2>Fullstack</h2>
      <button>Øvinger</button>
      <button>Info</button>
      <button>Til kø</button>
    </div>
    <div id="subjectDetail">
      <div id="taskInfo" class="tabContent">
        <div class="title"><h3>Øvinger</h3> <p>Status: Godkjent</p></div>
      </div>
      <div id="TAInfo" class="tabContent"></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Subject"
}
</script>

<style scoped>
h2, p, h3 {
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
  width: 60%;
}
#subjectNames {
  text-align: left;
  background-color: #25458a;
  color:white;
  padding: 5px 80px 5px 20px;
}

#subjectDetail {
  flex-grow: 1;
}
.title {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  justify-content: space-between;
}

</style>