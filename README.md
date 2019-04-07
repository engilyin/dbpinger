# dbpinger
Sends SQL query at brief intervals for purposes like keeping the connection alive. Spring Boot, @Scheduled and Thymeleaf sample.

# How to use
Edit src/main/resources/application.yml to set your settings like the DB connection 
properties, interval and the SQL query.

It is intended to be used against PostgerSQL databases right from the box.
Feel free to edit dependencies in the build.gradle to use another JDBC driver.
