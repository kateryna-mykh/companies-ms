# companies-ms
REST service for managing company data and their reporting.
 
## Technologies
* Java 17
* Spring Boot, Spring Data JPA
* Docker
* PostgeSQL
* MongoDB
* Liquibase

## Endpoints

- GET /api/companies
- POST /api/companies
- PUT /api/companies/{id}
- GET /api/companies/{id}
- DELETE /api/companies/{id}


- GET /api/reports
- POST /api/reports
- PUT /api/reports/{id}
- GET /api/reports/{id}
- DELETE /api/reports/{id}
- GET /api/reports/by-company/{id} (Get all reports by company id)
- GET /api/reports/{id}/details (Get details of the report)

## Input file examples

Request to /api/companies:

```
{
    "name": "",
    "registrationNumber": ""
}
```
Request to /api/reports:

```
{
    "companyId": "",
    "totalRevenue": 0.0,
    "netProfit": 0.0,
    "details" : {
        "financialData": "",
        "comments": ""
}
```

## How launch this project
1. Configure databases user and password in the .env file.
2. Build and run with Docker Compose.
3. Build with Maven and run.
