<template>
  <div>
    <router-link :to="{ name:'Login'}">Aktive fag</router-link>
    <router-link :to="{name: 'Subjects'}">Arkiverte fag</router-link>
    <h2>Aktiv kø</h2>
    <div>
      <Subject />
      <Subject />
    </div>
    <hr>
    <h3>Inaktiv kø</h3>
    <div>

    </div>
  </div>
</template>

<script>
import Subject from "@/components/Subject"
export default {
  name: "SubjectsView",
  components: {
    Subject
  }
}
</script>

<style scoped>

</style>