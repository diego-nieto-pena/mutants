# Mercado Libre - Mutant DNA Detector

## Tech Stack
- Java 8
- SpringBoot 2.3.1
- Hibernate 5.4.17
- MySQL 8
- Apache Maven 3.3.9
- Jacoco Junit

## Web Application
The application was deployed as a **Elastic Beanstalk** web application, it uses a **EC2** instance and a **RDS** (MySQL) database instance.

## Local Deployment
Please, make sure you have installed the tech stack elements mentioned at the point 1. 
- As it uses a MySQL local instance please edit the following properties (**application.properties** file) to match your local MySQL instance:
    - spring.datasource.url=**jdbc:mysql://localhost:3306/<databasename>**
    - spring.datasource.username=**<user>**
    - spring.datasource.password=**<password>**

### Stand Alone Application
At the root folder please execute the maven wrapper package command:
> mvnw clean package
Once the build is done please execute the create .jar file:
> java -jar Mutants-0.0.1-SNAPSHOT.jar
- DNA sequence evaluation: Will be done by doing a **POST** request to http://localhost:5000/mutant.
- Statistics report: Please execute a **GET** request to  http://localhost:5000/stats

### Creating Docker Image
 If you want to execute it as a docker container, there is a Dockerfile at the root folder, to build the image please run the following command (Docker must be installed):
> docker image build -t mutants-app mutants:v1 .

Once the image build is done then execute:
> docker container run -d -p 5000:5000 --name mutants-app mutants:v1

## Executing the DNA detector web application
Please, use Postman or any similar tool:
- DNA sequence evaluation: Will be done by doing a **POST** request to http://mutantdnadetector-env.eba-7ukeavat.us-west-2.elasticbeanstalk.com/mutant.
    - Request Body.
        - Mutant DNA:
            - > {
                 "dna":["GGGGtG","AGgTaC","taaGtT","GttttT","CCcatT"]
               }
        **Response: HTTP 200 OK**

       - Human DNA:
           - > {
                 "dna":["GtGatG","AGgTaC","taaGtT","GtattT","CCcatT"]
               } 
       **Response: HTTP 403 FORBIDDEN**
- Statistics report: Please execute a **GET** request to http://mutantdnadetector-env.eba-7ukeavat.us-west-2.elasticbeanstalk.com/stats
    - The response will have the following format:
        - >  {
                "count_mutant_dna":4,
                "count_human_dna":0,
                "ratio":1.0
            }
**Response: HTTP 200 OK**

## API Documentation can be found at: http://mutantdnadetector-env.eba-7ukeavat.us-west-2.elasticbeanstalk.com/v2/api-docs

## Test Code coverage
Running the code coverage report can be done by executing the following command at the root folder:
> mvn test

The .html report can be found at **Mutants\target\jacoco-ut\index.html**

## Git repository at:
https://github.com/DhyegoNieto/mutants.git


