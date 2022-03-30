import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/LoginView.vue";
import TAQueue from "../views/QueueTA.vue";
import SubjectsView from "@/views/SubjectsView";
import QueueStudent from "@/views/QueueStudent";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/queueTA",
    name: "TAQ",
    component: TAQueue,
  },
  {
    path: "/subjects",
    name: "Subjects",
    component: SubjectsView,
  },
  {
    path: "/queue",
    name: "Queue",
    component: QueueStudent,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
