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
        .get("", this.$store.state.userInfo)
        .then((response) =>{
            return response;
        });
}

// QUEUE
export function getQueue(){

}

export function addToQueue(queueInfo){
    return axios
        .post("", queueInfo)
        .then((response) => {
            return response
        })
}