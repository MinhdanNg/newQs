<template>
  <div
    class="studentContainer"
    v-bind:class="{ pending: isPending, helping: isHelping }"
  >
    <p id="username" class="gridItem">{{ username }}</p>
    <p id="helpType" class="gridItem">{{ helpType }}</p>
    <p id="task" class="gridItem">Øving {{ taskNumber }}</p>
    <p id="time" class="gridItem"></p>
    <p id="place" class="gridItem">{{ place }}</p>
    <p id="TA" class="gridItem">{{ TA }}</p>
  </div>
</template>

<script>
export default {
  name: "QStudent",
  data() {
    return {
      isHelping: false,
      isPending: false,
    };
  },
  props: {
    username: String,
    helpType: String,
    taskNumber: String,
    place: String,
    TA: String,
  },
  methods: {},
};
</script>

<style scoped>
.studentContainer {
  display: grid;
  grid-template-areas: "name helpType task time place TA";
  text-align: left;
  border: 1px solid lightblue;
  border-left: 20px solid lightblue;
  border-radius: 10px;
  padding: 2px;
}
.gridItem {
  width: 200px;
}
#username {
  grid-area: name;
}
#helpType {
  width: 150px;
  grid-area: helpType;
}
#task {
  grid-area: task;
  width: 100px;
}
#time {
  width: 150px;
  grid-area: time;
}
#place {
  grid-area: place;
  width: 100px;
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
