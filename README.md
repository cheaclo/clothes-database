# Clothes Database Microservice

Project is a microservice, which is part of Cheaclo project. The application is a layer supporting communication between clothes database and other microservices.

## Tech stack

`java 16`

`spring-boot 2.5.2`

`postgresql`

## Details

### Saving data

Database is implement on PostgreSQL relational database system. Currently data is stored on local machine, but after deployment it will be moved to cloud.
Clothes database is linked with [Web scrapper](https://github.com/cheaclo/web-scrapper), which provides data for database. For this purpose `/save` entry point is implemented. First data supplier, which send post request is checked through the improvised authentication proccess. The next step is data validation. After that new products are inserted to the database. If some product already exists it's `Last update` column is update and no more actions are taken. In the end Clothes Database service delete all expired products, checking by `Last update` column. [Web scrapper](https://github.com/cheaclo/web-scrapper) is provided by message about success of inserting data.

### Distributing data

In progress...