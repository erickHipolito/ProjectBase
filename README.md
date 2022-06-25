# ProjectBase
Project Base in Spring Boot for any Sector

 -A RESTful WebServer developed using Spring & SpringBoot.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3](https://maven.apache.org)

# Getting Started
Clone the project and use Maven to build the server

	$ mvn clean install

For environment local. I added

     -Dspring.profiles.active=local
to VM Options and then re-ran that configuration. It worked perfectly.

This can be set by
* Choosing Run | Edit Configurations...
* Go to the Configuration tab
* Expand the Environment section to reveal VM options

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.
