<template>
  <div
    class="studentContainer"
    v-bind:class="{ pending: isPending, helping: TA.length > 0 }"
  >
    <p id="username" class="gridItem">{{ username }}</p>
    <p id="helpType" class="gridItem">{{ helpType }}</p>
    <p id="task" class="gridItem">Øving {{ taskNumber }}</p>
    <p id="place" class="gridItem hideOnMobile">{{ place }}</p>
    <p id="TA" class="gridItem hideOnMobile">{{ TA }}</p>
  </div>
</template>

<script>

export default {
  name: "QStudent",
  data() {
    return {
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
  grid-template-areas: "name helpType task place TA";
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
#place {
  grid-area: place;
  width: 100px;
}
#TA {
  grid-area: TA;
}
.pending {
  border: 1px solid yellow;
  border-left: 20px solid yellow;
}
.helping {
  border: 1px solid lightgreen;
  border-left: 20px solid lightgreen;
}
@media only screen and (max-width: 600px) {
  .gridItem {
    width: 150px;
  }
  #task {
    width: 80px;
  }
  #helpType {
    width: 100px;
  }
}
</style>
