This is the very small project showing peculiarities of using aspectj with springboot.
 
The case is simple: suppose you have springboot application with 3rd party library (jar-module) that needs to be intercepted.

Application contains of 3 parts:
- main module, which is just a pom module
- jar-module - emulation of 3rd party library
- war-module - springboot web application

How to run:
- clone this repo `git clone https://github.com/karuniko/springboot-aspectj-example.git`
- `mvn clean install`
- `cd war-module`
- `mvn spring-boot:run -Drun.jvmArguments="-javaagent:${pom.basedir}\aspectjweaver-1.8.10.jar -javaagent:${pom.basedir}\spring-instrument-4.3.7.RELEASE.jar -Dserver.port=8080 -Dserver.contextPath=/app"`

Expected result:
Application is run successfully

Actual result:
Caused by: java.lang.NullPointerException: null
	at com.example.SomeTestAspect.aroundinterceptionTestMethod(SomeTestAspect.java:26) ~[classes/:na]
	at com.example.SomeTest.someMethod(SomeTest.java:10) ~[jar-module-1.0-SNAPSHOT.jar:na]
	at com.example.AspApplication.run(AspApplication.java:35) [classes/:na]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:776) [spring-boot-1.5.2.RELEASE.jar:1.5.2.RELEASE]
	... 11 common frames omitted