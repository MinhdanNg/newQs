import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/LoginView.vue";
import Queue from "../views/Queue.vue";
import SubjectsView from "@/views/SubjectsView";
import ArchivedSubjects from "@/views/ArchivedSubjects";
import AdminView from "@/views/AdminViews/AdminView";
import AdminSubjects from "@/views/AdminViews/AdminSubjects";
import AdminUsers from "@/views/AdminViews/AdminUsers";

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
    props: true,
  },
  {
    path: "/subjects",
    name: "Subjects",
    component: SubjectsView,
  },
  {
    path: "/subjects/archive",
    name: "ArchivedSubjects",
    component: ArchivedSubjects,
  },
  {
    path: "/admin",
    name: "Admin",
    component: AdminView,
  },
  {
    path: "/admin/subjects",
    name: "AdminSubjects",
    component: AdminSubjects,
  },
  {
    path: "/admin/users",
    name: "AdminUsers",
    component: AdminUsers,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
