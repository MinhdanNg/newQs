## Setup Keycloak as authorization server
You are self-encouraged to find proper document for your operating system on setting up and configuration of Keycloak server.
In this section, we will describe a docker based approach.
Note that the following steps are tested only on MacOS 12.0.1

- Clone Keycloak container repository: ```git clone git@github.com:keycloak/keycloak-containers.git```
- Open server directory (```cd keycloak-containers/server```)
- Checkout at desired version, eg. ```git checkout 13.0.1```
- (might have to give a name with ```git switch -c <name>```)
- Build docker image ```docker build -t jboss/keycloak:13.0.1 . ```
- Run Keycloak ```docker run --rm -p 8080:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak:13.0.1```

After completing the above steps, Keycloak server will be running on ```localhost:8080```.
You can open that on browser and start configuration.
Note the credentials for logging in (provided in the command above) is ```admin``` as username and ```admin``` as password.

Note also that Keycloak also needs a database, and if nothing is specified it will use in-memory database.
That means all the data will be lost when the Keycloak server is restarted!

## Configure Keycloak server
1. Open Keycloak server in the browser http://localhost:8080/auth. Then go to the ```Administration Console```. Use credentials provided with the command above.
   ![img_1.png](img/img_1.png)
2. On the left menu, go to ```Clients``` and ```Create```.
   ![img_2.png](img/img_2.png)
3. On the next screen, give ```Client ID``` and then save.
   ![img_3.png](img/img_3.png)
4. Then, Access Type -> ```credentials```; Service Accounts Enabled -> ```ON```; Valid Redirect URIs -> ```some URL```; Web Origins -> ```*```. And ```Save```
   ![img_4.png](img/img_4.png)
5. Then, go to the ```Credentials``` tab and copy the client secret.
   ![img_5.png](img/img_5.png)

That´s it, you are done with the basic configuration and it´s time to test the client and get the access token.
Test can be done using ```postman``` or a ```curl``` command as below.

Note that the string following the word ```Basic``` is base64 encoded string of your client_id:client_secret.
Base64 encoded string can be generated from the command line below

```
# command to generate base64 encoded string. In this command auth_demo_client is client_id and 7cafaf69-34b4-4f76-a327-d5778f8423bc is client_secret
echo -n 'auth_demo_client:7cafaf69-34b4-4f76-a327-d5778f8423bc' | base64

#output is base64 encoded string
YXV0aF9kZW1vX2NsaWVudDo3Y2FmYWY2OS0zNGI0LTRmNzYtYTMyNy1kNTc3OGY4NDIzYmM=
```

Getting ```access_token```,

```
# curl command to get access token
# note - remember to your own credential
curl --location --request POST 'http://localhost:8080/auth/realms/master/protocol/openid-connect/token' \
--header 'Authorization: Basic YXV0aF9kZW1vX2NsaWVudDo3Y2FmYWY2OS0zNGI0LTRmNzYtYTMyNy1kNTc3OGY4NDIzYmM=' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=client_credentials' \
--data-urlencode 'scope=openid'

```

## Inspect the response from the above command.
Note ```access_token```, ```expires_in``` and ```scope``` properties.
```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI0b2JOVC1zZEV2NV84QlMzTXYya3kwYm5YaVl6Yi1JMDI1WHNQbFl3MERNIn0.eyJleHAiOjE2NDY5OTg1MTksImlhdCI6MTY0Njk5ODQ1OSwianRpIjoiOWJkZjg1NzMtNzc2OS00ZmQ3LWFmMTgtMmQwMzM0MzQ3ZjlkIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL21hc3RlciIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIwZWE4MzZlOS1iNjM3LTRlY2QtODI0OS01ZDFiMWQ4MGQxNTIiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJhdXRoX2RlbW9fY2xpZW50IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIqIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW1hc3RlciIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIGVtYWlsIiwiY2xpZW50SG9zdCI6IjE3Mi4xNy4wLjEiLCJjbGllbnRJZCI6ImF1dGhfZGVtb19jbGllbnQiLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsInByZWZlcnJlZF91c2VybmFtZSI6InNlcnZpY2UtYWNjb3VudC1hdXRoX2RlbW9fY2xpZW50IiwiY2xpZW50QWRkcmVzcyI6IjE3Mi4xNy4wLjEifQ.LuyVV7junHuvZLynOlo2ZtxcacONgq1OLpFS2dzzl83muiz52kTdvgIik5-odnbMhLg0s_dlW6P1ElexRxNZTqg0ShyYBsIcQRSY0XFCscmlymrv4LxA2hbBljaaVyAYQaTybm8bk_PgIPZRfKONCD3LoNSXhxN_TzkPqRb8Ie_85aQXNurfxdUbzydpD8uKsNywOVI4p5DbdVbfXIGGziMOHB0vNe3A9AaWA5QBwD8E__HQsSreECeEA271d8U1b4esucknrnyxS1xMWMgYE0qyh3X4O0NQxHMSr73hnffa30sbp9y1YH-FKDmpSAJWsuAocpa0y3z52U77IR--CA",
    "expires_in": 60,
    "refresh_expires_in": 0,
    "token_type": "Bearer",
    "id_token": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI0b2JOVC1zZEV2NV84QlMzTXYya3kwYm5YaVl6Yi1JMDI1WHNQbFl3MERNIn0.eyJleHAiOjE2NDY5OTg1MTksImlhdCI6MTY0Njk5ODQ1OSwiYXV0aF90aW1lIjowLCJqdGkiOiJmNzdiYTdhMC0zNmM3LTRkMTQtYjZhZi0yZjViNmE0YzY0NjQiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvbWFzdGVyIiwiYXVkIjoiYXV0aF9kZW1vX2NsaWVudCIsInN1YiI6IjBlYTgzNmU5LWI2MzctNGVjZC04MjQ5LTVkMWIxZDgwZDE1MiIsInR5cCI6IklEIiwiYXpwIjoiYXV0aF9kZW1vX2NsaWVudCIsImF0X2hhc2giOiJmVWRVSEw4SzhaRGhCc1NHaWZwTmhBIiwiYWNyIjoiMSIsImNsaWVudEhvc3QiOiIxNzIuMTcuMC4xIiwiY2xpZW50SWQiOiJhdXRoX2RlbW9fY2xpZW50IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtYXV0aF9kZW1vX2NsaWVudCIsImNsaWVudEFkZHJlc3MiOiIxNzIuMTcuMC4xIn0.iJxKPfZBwvqfsjwfNUZajpTpAvZCBVpHAUxZXKTUMZn-0ceu86T4CwgGtALqgtoFkwnrkwoxzu5leWVmZKVvLa6pBmCP4W0K6O-jZwJ9kpuUyQxbEhWBOTrii97c6nyYVz4EI_yI1il-wURoVfGotW8ZdoX70BghbOayrdsSX2cyJXCRvAehzofXx8Kd-_qn-yH4tWvmYFF00Q-wOwRvQeVAKKz9Pjz3HI86-OgYDRH1Up8pcSLOqKqV4tA5BTNpCgwQJ4bO8KSyKDA45XQLXh3NDJUhyjOoS147PI9yxDsFW5KtZkkv8qz4a9bMAANfXDFnrYcTVy48gtCWAHMw4A",
    "not-before-policy": 0,
    "scope": "openid profile email"
}
```
