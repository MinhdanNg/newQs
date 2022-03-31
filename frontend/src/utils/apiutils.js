import axios from "axios";

export function doLogin(loginRequest) {
  return axios
    .post("http://localhost:8080/login", loginRequest)
    .then((response) => {
      return response.data;
    });
}

export function getUser(){

}

export function getQueue(){

}

export function addToQueue(queueInfo){
    return axios
        .post("", queueInfo)
        .then((response) => {
            return response.data
        })
}

export function getSubjects(){

}