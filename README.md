# library-check-in-app
library check in app
Spring Boot/React Example with Modal forms and Security

Spring Boot backend, React frontend.

Spring Packages Used:
Spring Boot
Spring Web
Spring Security
Spring Thymeleaf
Spring Data JPA
Spring Devtools
MySQL Connector
frontend-maven-plugin for React development

JS Packages Used:
Babel
Webpack
Axios
React
React-Bootstrap
Frontend Build
There are 3 maven rules that are used to build the frontend:

 mvn frontend:install-node-and-npm
If this is executed from the command line (or your IDE maven interface) it will install Node.js and npm in your project directory. This only needs to be rerun after the first time if you change the version of node specified in your pom.xml file.

 mvn frontend:npm
If this is executed from the command line (or your IDE maven interface) it will the javascript packages specified in your package.json file. This only needs to be rerun if that file is changed.

 mvn frontend:webpack
If this is executed from the command line (or your IDE maven interface) it will compile and package your javascript files into a single javascript file which will run on older as well as current browsers. It should be rerun each time your frontend application is changed, before rerunning the backend server project.
