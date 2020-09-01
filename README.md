# GraphQL-Spring-boot Application: 


## 1. Running as a Packaged Application (Following ways)
    Way-1 : mvn clean install (using maven)
            java -jar target/spring-boot-graphql-0.0.1-SNAPSHOT.war

    Way-2 : mvn spring-boot:run (using maven)

## 2. Once the application is started you can access http://localhost:8080/graphiql

## 3. This is a Git Hub Single Sign on project, you will be redirected to Git Hub login page if you are not logged in to Git hub from your browswer.

## Testing the Application:

## GraphQL

### To Update Post:
    ```
    GraphiQL Syntax:
        mutation {
          updatePost(input: {id:1, userId:1,title:"example post", body:"example"}){
            name
          }
        }
    
    JSON/postman syntax:
        {
        "query": "mutation updatePost($input: Post!) {updatePost(input: $input){name}}","variables":{"input": {id:1, userId:1,title:"example post", body:"example"} },"operationName":"updatePost"
        }
    ```
### To retrieve a single Post:
    ```
    GraphiQL Syntax:
        query {
          post(id:1){
            userId
            title
            body
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{post(id:1){userId title body}}"
        }
    ```
    
### To retrieve a single Comment:
    ```
    GraphiQL Syntax:
        query {
          comment(id:1){
            name
            email
            body
            post
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{comment(id:1){name email post}}"
        }
    ```
### To retrieve a single User:
    ```
    GraphiQL Syntax:
        query {
          user(id:1){
            name
            username
            email
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{user(id:1){name username email}}"
        }
    ```        
## To delete a Post:
    ```
    GraphiQL Syntax:
        mutation {
          deletePost(id:10)
        }
    
    JSON/postman syntax:
        {
            "query": "mutation deletePost {deletePost(id:4)}","variables":null,"operationName":"deletePost"
        }
    ```   
## To retrieve comments from post:
    ```
    GraphiQL Syntax:
        query{
          commentsByPost(id:1){
            name
          }
        }
    
    JSON/postman syntax:
        {
            "query":"{commentsByPost{name email}}"
        }
    ```
## REST:

    Swagger UI is configured in this application to provide rest endpoints. So if you want to test the services using REST URL's,
    you can visit http://localhost:8080/swagger-ui.html
