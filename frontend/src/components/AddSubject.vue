<template>
<div id="addSubjectContainer">
  <form id="subjectForm">
    <label for="subjectCode">Fagkode: </label>
    <input type="text" id="subjectCode" name="subjectCode">

    <label for="subjectName">Fagnavn: </label>
    <input type="text" id="subjectName" name="subjectName">

    <label for="teachers">Lærere: </label>
    <textarea id="teachers" name="teachers" placeholder="Format: Etternavn, fornavn, epost (linjeskift)" v-model="teachers"></textarea>

    <label for="teachAss">Øvingslærere: </label>
    <textarea id="teachAss" name="teachAss" placeholder="Format: Etternavn, fornavn, epost (linjeskift)"></textarea>

    <label for="students">Studenter: </label>
    <textarea id="students" name="students" placeholder="Format: Etternavn, fornavn, epost (linjeskift)"></textarea>

    <label for="taskCount">Antall øvinger: </label>
    <input type="number" id="taskCount" name="taskCount" v-model="taskCount" @input="createTasklist">

    <div>
      <label>Undergruppe for godkjente øvinger: </label>
      <button @click.prevent="addSubgroup">Legg til undergruppe</button>
      <div id="allSubgroups">
        <div v-for="(subgroup, index) in subgroups" :key="index" class="subgroup">
          <p>Undergruppe {{index + 1}}</p>
          <p>Inneholder øvingene: {{subgroup.subgroupTasks}}</p>
          <p>Antall obligatoriske øvinger: {{subgroup.subgroupObligatory}}</p>
        </div>
        <div v-if="tasklist.length > 0">
          <p>Undergruppe {{this.currentSubgroupNumber}}</p>
          <div v-for='task in tasklist' :key="task">
            <input type="checkbox" v-model="currentSubgroupChecked" :value="task"><label>{{task}}</label>
          </div>
          <label>Antall godkjente øvinger: </label>
          <select v-model="currentSubgroupObligatory">
            <option :value="n" v-for="n in currentSubgroupChecked.length" :key="n">{{n}}</option>
          </select>
        </div>
      </div>
    </div>
    <input type="submit" @click.prevent="addSubject">
  </form>
</div>
</template>

<script>
export default {
  name: "AddSubject",
  data () {
    return {
      subjectCode: '',
      subjectName: '',
      teachers: '',
      teachAss: '',
      students: '',
      taskCount: '',
      tasklist: [],
      // Task subgroups
      subgroups: [],

      currentSubgroupNumber: 1,
      currentSubgroupChecked: [],
      currentSubgroupObligatory: '',
    }
  },
  methods: {
    createTasklist(){
      if(this.taskCount.length > 0){
        this.tasklist = Array.from({length: this.taskCount}, (_, i) => i + 1)
      }
    },
    addSubgroup(){
      this.subgroups.push(
          {subgroupNumber: this.currentSubgroupNumber,
          subgroupTasks: this.currentSubgroupChecked,
          subgroupObligatory: this.currentSubgroupObligatory}
      )
      this.tasklist.splice(this.tasklist.indexOf(this.currentSubgroupChecked[0]), this.currentSubgroupChecked.length)
      this.currentSubgroupNumber++
      this.currentSubgroupChecked = []
      this.currentSubgroupObligatory = ''

    },
    addSubject(){
    },
  },
}
</script>

<style scoped>
#addSubjectContainer {
  overflow: scroll;
  height: 80%;
}
#subjectForm {
  display: flex;
  flex-direction: column;
}
#subjectForm > * {
  margin: 10px auto;
}
textarea{
  width: 80%;
  height: 100px;
}
#allSubgroups {
  display: flex;
  flex-direction: row;
}
.subgroup {
  margin: 15px;
  padding: 10px;
  border: solid 1px red;
}
</style>