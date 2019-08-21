# Spring-Pre-Assessment
Spring Hibernate Webapp for Pre-Assessment

Java: JDK8 + Maven 4.x <br/>
Backend: Spring MVC + Hibernate (Configured by annotation)<br/>
Frontend: JQuery + Ajax (Client-server communication using JSON)<br/>

Authentication is implemented using Spring Security & BCrypt 

* Import the SQL dump file `preassessDump.sql` to your SQL server before running the Spring application to ensure availability of required data and jdbc authentication. <br/>
* Open the project in your IDE, build & run `PreAssessApplication.java`
* Go to http://localhost:8080/ 
* Use the credentials `shubham`|`password` to login OR<br/> switch to the in-memory authentication in `config/SecurityConfig.java`

