import axios from "axios";

const header = {
    'Content-Type': 'application/x-www-form-urlencoded',
    'Authorization': 'Basic bmV3UVNfY2xpZW50OjZjYmY3ZTFmLWRiZWMtNDA2Yy1iYjhjLTk5MTVmYTFkODM1MA=='
}

export function doLogin(loginRequest) {
  return axios
    .post("http://localhost:8080/login", loginRequest, {
        headers: header,
        data: {
            grant_type: 'password',
            scope: 'openid',
            client_id: 'newQS_client',
            username: 'admin',
            password: 'admin',
        }
    })
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