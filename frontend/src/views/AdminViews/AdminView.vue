<template>
  <div id="adminNav" v-if="$store.state.role==='admin'">
    <router-link class="" :to="{ name: 'AdminSubjects' }">Fag</router-link> |
    <router-link class="" :to="{ name: 'AdminUsers' }">Brukere</router-link>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
  name: "AdminView"
}
</script>

<style scoped>
#adminNav a.router-link-exact-active {
  border-bottom: solid white 2px;
}

#adminNav a:hover {
  border-bottom: solid white 2px;
  cursor: pointer;
}
</style>