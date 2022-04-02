<template>
  <div id="clock">
    <span class="time" @stopwatchStart="start">{{ time }}</span>
  </div>
</template>

<script>
export default {
  name: "Stopwatch",
    data() {
      return {
        time: '00:00:00',
        timeBegan: null,
        timeStopped: null,
        stoppedDuration: 0,
        started: null,
        running: false
      }
    },
  methods: {

    start() {

  if(this.running) return;

  if (this.timeBegan === null) {
    this.timeBegan = new Date();
  }

  if (this.timeStopped !== null) {
    this.stoppedDuration += (new Date() - this.timeStopped);
  }

      this.started = setInterval(this.clockRunning, 10);
      this.running = true;
},
    stop() {
      this.running = false;
      this.timeStopped = new Date();
  clearInterval(this.started);
},

 clockRunning(){
  var currentTime = new Date()
      , timeElapsed = new Date(currentTime - this.timeBegan - this.stoppedDuration)
      , hour = timeElapsed.getUTCHours()
      , min = timeElapsed.getUTCMinutes()
      , sec = timeElapsed.getUTCSeconds()

      this.time =
          this.zeroPrefix(hour, 2) + ":" +
          this.zeroPrefix(min, 2) + ":" +
          this.zeroPrefix(sec, 2)
},

 zeroPrefix(num, digit) {
   let zero = '';
   for(let i = 0; i < digit; i++) {
    zero += '0';
  }
  return (zero + num).slice(-digit);
},
  },
}
</script>

<style scoped>

</style>