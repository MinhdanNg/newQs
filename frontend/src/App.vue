<template>
  <div id="container">
    <div id="nav">
      <img src="./assets/logo.png" alt="logo" id="logo" />
      <p id="usernameNav">{{ $store.state.username }}</p>
      <div>
        <button class="navButtons">
          <img src="./assets/logout.png" alt="Logg ut" id="logoutIcon" />
        </button>
        <router-link class="navButtons" :to="{ name: 'Settings' }"
          >Innstillinger</router-link
        >
        <router-link class="navButtons" :to="{ name: 'Subjects' }"
          >Fag</router-link
        >
      </div>
    </div>
    <div id="content">
      <router-view />
    </div>
  </div>
</template>

<script></script>
<style>
body {
  margin: 0;
}
#container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: column;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#content {
  width: 80%;
  margin: auto;
}

#nav a.router-link-exact-active {
  border-bottom: solid white 2px;
}
#nav {
  background-color: #333;
  display: flex;
  flex-direction: row;
  color: white;
}

#nav a:hover {
  border-bottom: solid white 2px;
  cursor: pointer;
}
.navButtons {
  font-size: 20px;
  background-color: transparent;
  border: none;
  border-bottom: solid transparent 2px;
  padding: 5px;
  margin: 8px;
  text-decoration: none;
  float: right;
  color: white;
  font-weight: normal;
}

#logoutIcon {
  height: 30px;
}
#logoutIcon:hover {
  cursor: pointer;
}
#logo {
  height: 30px;
  padding: 15px;
}

#usernameNav {
  flex-grow: 1;
  font-size: 20px;
}
</style>
