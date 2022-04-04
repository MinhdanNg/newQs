import axios from "axios";
import store from '@/store'

export function doLogin(loginRequest) {
  return axios
    .post("http://localhost:8085/api/user/login", loginRequest)
    .then((response) => {
      return response.data;
    });
}

// USER
export function getUser(){
    return axios
        .get("http://localhost:8085/api/user", store.state.userID, {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) => {
            return response.data;
        });
}

export function getAllUsers(){
    return axios
        .get("http://localhost:8085/api/user/get-all", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) => {
            return response.data;
        });
}
export function addUser(userInfo){
    return axios
        .post("http://localhost:8085/api/user/register", userInfo ,{
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        });
}

// SUBJECT
export function getSubjectsWhereStudent(){
    return axios
        .get("http://localhost:8085/api/subject/get-where-student", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) =>{
            return response.data;
        });
}
export function getSubjectsWhereAssistant(){
    return axios
        .get("http://localhost:8085/api/subject/get-where-assistant", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) => {
            return response.data
        });
}

export function getSubjectsOverview (){
    return axios
        .get("http://localhost:8085/api/subject/get-my-subject-overview", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) => {
            return response.data
        });
}
export function getSubjectsByUserID(userID){
    return axios
        .get("http://localhost:8085/api/subject/get-where-student/"+userID, {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) =>{
            return response.data;
        });
}
export function getAllSubjects(){
    return axios
        .get("http://localhost:8085/api/subject/get-all", {
        headers: {
            Authorization: 'Bearer ' + store.getters.token
        }
    })
        .then((response) =>{
            return response.data;
        });
}
export function getSubject(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/get", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then ((response) =>{
            return response.data
        })
}

export function addSubject(subjectInfo){
    return axios
        .post("http://localhost:8085/api/subject/register", subjectInfo, {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}

export function deleteSubject(subjectID){
    return axios
        .delete("http://localhost:8085/api/subject/" + subjectID + "/delete", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}
export function archiveSubject(subjectID){
    return axios
        .post("http://localhost:8085/api/subject/" + subjectID + "/archive", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}
export function getMyTasks(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/get-my-task-overview", {
        headers: {
            Authorization: 'Bearer ' + store.getters.token
        }
    })
        .then((response) => {
            return response.data
        });
}

// QUEUE
export function getQueue(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/queue/get", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) =>{
            return response.data
        });
}
export function getQueueItems(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/queue/get", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
        .then((response) =>{
            return response.data.items
        });
}

export function startQueue(subjectID){
    return axios
        .put("http://localhost:8085/api/subject/" + subjectID + "/queue/start", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        });
}

export function stopQueue(subjectID){
    return axios
        .put("http://localhost:8085/api/subject/" + subjectID + "/queue/stop", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        });
}

export function addToQueue(subjectID, queueInfo){
    return axios
        .post("http://localhost:8085/api/subject/" + subjectID + "/queue/join", queueInfo, {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}


export function helpStudent(subjectID, studentID){
    return axios
        .put("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/assist", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}
export function approveStudent(subjectID, studentID){
    return axios
        .delete("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/approve", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}
export function postponeStudent(subjectID, studentID){
    return axios
        .put("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/postpone", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}
export function rejectStudent(subjectID, studentID){
    return axios
        .delete("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/reject", {
            headers: {
                Authorization: 'Bearer ' + store.getters.token
            }
        })
}
