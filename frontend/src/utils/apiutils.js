import axios from "axios";

export function doLogin(loginRequest) {
  return axios
    .post("http://localhost:8085/api/user/login", loginRequest)
    .then((response) => {
      return response;
    });
}

// USER
export function getUser(){
    return axios
        .get("http://localhost:8085/api/user", this.$store.state.userInfo)
        .then((response) => {
            return response;
        });
}

export function getAllUsers(){
    return axios
        .get("")
        .then((response) => {
            return response;
        });
}

// SUBJECT
export function getSubjectsWhereStudent(){
    return axios
        .get("http://localhost:8085/api/subject/get-where-student")
        .then((response) =>{
            return response;
        });
}
export function getSubjectsWhereAssistant(){
    return axios
        .get("http://localhost:8085/api/subject/get-where-assistant")
        .then((response) =>{
            return response;
        });
}
export function getSubjectsByUserID(userID){
    return axios
        .get("http://localhost:8085/api/subject/"+userID+"/")
        .then((response) =>{
            return response;
        });
}
export function getAllSubjects(){
    return axios
        .get("http://localhost:8085/api/subject/get-all"
        .then((response) =>{
            return response;
        }));
}
export function getSubject(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "get")
        .then ((response) =>{
            return response
        })
}

export function addSubject(subjectInfo){
    return axios
        .post("http://localhost:8085/api/subject/register", subjectInfo)
}

export function deleteSubject(subjectID){
    return axios
        .post("http://localhost:8085/api/subject/" + subjectID + "/delete")
}
export function archiveSubject(subjectID){
    return axios
        .post("http://localhost:8085/api/subject/" + subjectID + "/archive")
}
export function getMyTasks(subjectID){
    return axios
        .post("http://localhost:8085/api/subject/" + subjectID + "/get-my-task-overview")
        .then((response) => {
            return response
        });
}

// QUEUE
export function getQueue(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/queue/get")
        .then((response) =>{
            return response
        });
}

export function startQueue(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/queue/start")
        .then((response) =>{
            return response
        });
}

export function stopQueue(subjectID){
    return axios
        .get("http://localhost:8085/api/subject/" + subjectID + "/queue/stop")
        .then((response) =>{
            return response
        });
}

export function addToQueue(queueInfo){
    return axios
        .post("", queueInfo)
}


export function helpStudent(subjectID, studentID){
    return axios
        .put("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/assist")
}
export function approveStudent(subjectID, studentID){
    return axios
        .delete("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/approve")
}
export function postponeStudent(subjectID, studentID){
    return axios
        .put("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/postpone")
}
export function rejectStudent(subjectID, studentID){
    return axios
        .delete("http://localhost:8085/api/subject/" + subjectID + "/queue-item/" + studentID + "/reject")
}
