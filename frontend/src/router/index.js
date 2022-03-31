import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/LoginView.vue";
import Queue from "../views/Queue.vue";
import SubjectsView from "@/views/SubjectsView";
import Settings from "@/views/Settings";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/queue",
    name: "Queue",
    component: Queue,
  },
  {
    path: "/subjects",
    name: "Subjects",
    component: SubjectsView,
  },
  {
    path: "/settings",
    name: "Settings",
    component: Settings,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
