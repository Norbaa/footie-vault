![img.jpg](img.jpg)


# ***<span style="color: #97ff65 ">FOOTIE - VAULT***  
<br>
<br>

## Webler Java Backend course final project 

---

### <span style="color: #6698FF">We use server port: 8080</span>

---

## Backend Dependencies

- Java Development Kit - JDK 21 (Oracle openjdk-21)
- Spring Boot 3
- Maven
- MySQL Connector
- Spring Data JPA
- Spring Web
- Spring DevTools
- Lombok

## Frontend Dependencies

- Spring Thymeleaf
- Bootstrap 5

## Database Dependencies

- MySQL 8.0.34
- MySQL Workbench 8.0.34

## Test Dependencies

- JUnit 5
- Mockito
- Spring Boot Test
- Spring Boot Starter Test
- H2 Database (in-memory database)

---

### <span style="color: #6698FF">The program is creating the empty database with tables (also in the MySQL server) without running any extra script (due to the setup of application.properties & liquibase)</span>
<span style="color: #6698FF">For running the project pls. setup the following environment variables:</span>
<br>

| Name               | Value                       | Remark            | Extra remark                                                                                                                                                 |
|--------------------|-----------------------------|-------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| DB_PORT_MYSQL           | 3306                        | default           | please user your own port that has been set to MySQL server                                                                                                  |
| DB_URL_MYSQL             | webler_apartment_reservation                  | recommended       | you can use your own, our name is just a recommendation!                                                                                                     |
| DB_USER_MYSQL            | root                        | default           | please use your own!                                                                                                                                         |
| DB_PASSWORD_MYSQL        | no such info                | pls use your own! | [MYSQL Installation Guide](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)                                                                     | 