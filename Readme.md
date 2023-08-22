<h1 align = "center"> DOCTOR-APP </h1>

<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java-17-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.2-brightgreen.svg" />
</a>
  
<a >
    <img alt="MySQL" src="https://img.shields.io/badge/MySQL-blue.svg">
</a>
</p>


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
 ## Database Configuration
To connect to a MySQL database, update the application.properties file with the appropriate database URL, username, and password. The following properties need to be updated:
```
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url = jdbc:mysql://localhost:3306/<DatabaseName>
spring.datasource.username = <userName>
spring.datasource.password = <password>
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true

```
<br>
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
## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.
4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

## DataBase Used
* SQL database
```

We have used Persistent database to implement CRUD Operations.
```
## Project Summary

The Doctor Appointment Scheduling API is a solution that streamlines the process of scheduling appointments between patients and doctors. By providing a user-friendly interface, real-time updates, and efficient appointment management, the API enhances the overall healthcare experience for both patients and medical professionals. This project aims to improve appointment scheduling convenience, ultimately contributing to better patient care and satisfaction.



## Author

👤 **Priya Mukherjee**

* GitHub: [priyamukherjee468](https://github.com/priyamukherjee468)

* LinkedIn: [Priya Mukherjee](www.linkedin.com/in/priya-mukherjee14)
    
---

    
## Show your support

Give a ⭐️ if this project helped you!
    
---



