### Doctor-App
_______


### Requirements
* IntellijIDEA
* ServerPort: 8080(localhost:8080)
* JavaVersion: 17
* pom.xml file(no need to download external library)
* Dependencies used:lombok,Spring web,h2 database,Spring data jpa.

### Data Flow
Function used in
1. Controller: the final destination point that a web request can reach.
2. Repository: used for get roomList.
3. Services: created method for four operations like get,add,delete,update.
4. Model: Model had following attributes

* Admin
* Appointment
* AuthenticationToken
* Doctor
* Patient



