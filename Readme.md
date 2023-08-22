# Doctor API
_______


## Framework Used
* Spring Boot
----
## Dependencies
The following dependencies are required to run the project:


* Spring Web
* Spring Data JPA
* MySQL Driver
* Lombok
* Validation
* Swagger
 ----
## Language used
* Java (Version: 17)
----
## Data Model

<br>

* Admin Model
```
Id : integer
Name : string
password : string
email : string
```

* Doctor Model
```
doctorId : Long
doctorName : String
specialization :  Specialization
doctorContactNumber : String
qualification : Qualification
doctorConsultationFee : Double
@OneToMany
appointments :  List<Appointment>
```

* Patient Model
```
Id : Long
Name : string
password : string
email : string
patientAge : Integer
patientAddress : String
gender : Gender
@OneToOne
appointment : Appointment
```

* Appointment  Model
```
appointmentId : Long
appointmentDesc: String
appointmentScheduleTime : LocalDateTime
appointmentCreationTime : LocalDateTime
@OneToOne
patient : Patient
@ManyToOne
doctor : doctor
```

* Authentication Token
```
tokenId : Long
tokenValue : string
tokenCreationDateTime : LocalDate
@OneToOne 
patient : Patient
```
* Gender
```
Enum: MALE, 
      FEMALE,
      TRANS

```
* Qualification 
```
Enum:  MBBS,
        MD

```
* Specialization
```
Enum:   ENT,
        GYNO,
        ORTHO,
        CARDIO,
        DENTAL  

```
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



