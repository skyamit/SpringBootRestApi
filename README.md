
# RestAPI Implementation using SpringBoot

This Project is a basic implementation of CRUD methods in Spring Boot Rest API.


## Acknowledgements

 - [Telusko Youtube](https://www.youtube.com/watch?v=35EQXmHKZYs&t=7968s)


## API Reference

#### API links after deploying the project in STS

1. Get all the Aliens from database
```http
  GET localhost:8080/getAlien/
```
2. Get alien which has id equal to link {id}
```http
  GET localhost:8080/getAlien/id
```
3. Search alien which has id equal to link {id}
```http
  GET localhost:8080/searchAlien/id
```
4. Delete alien with id equal to link {id}
```http
  GET localhost:8080/delete/id
```
5. Update alien name for id equal to link {alien.id} 
```http
  GET localhost:8080/updateAlien/?id=101&name=Amit Kumar
```
## Appendix

This project has been developed on Spring Tool Suite 4.

You can download the STS from this link : https://spring.io/tools




## Authors

- [@skyamit - GitHub](https://www.github.com/skyamit)
- [@skyamit - LinkedIn](https://www.linkedin.com/in/skyamit)


## Contributing

Contributions are always welcome!


## Deployment

1. To implement the project in your local, directly export the files to your local directory.
2. Open project with STS.
3. Let it download all the dependencies and things.
4. Select the Project -> Right Click -> Run As -> Spring Boot App
