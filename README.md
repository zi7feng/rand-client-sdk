# rand-client-sdk

The **rand-client-sdk** provides an SDK for users to call the RandAPI interface. The SDK has been published to Maven Central, making it easy for developers to integrate random number generation features into their applications. This project follows the Spring Starter development standard, which simplifies the configuration process for users.

## How to Use

### 1. Add SDK Dependency

First, add the SDK dependency to your project by visiting the following URL and including the Maven coordinates:

[https://central.sonatype.com/artifact/io.github.zi7feng/rand-client-sdk/overview](https://central.sonatype.com/artifact/io.github.zi7feng/rand-client-sdk/overview)

### 2. Register and Login

Visit the following Swagger UI link to interact with the RandAPI and create your account:

[http://34.219.214.45/swagger-ui.html](http://34.219.214.45/swagger-ui.html)

- **Register**: Use the `/user/register` endpoint to register a new account.
- **Login**: Use the `/user/login` endpoint to log in.
- **Generate Access and Secret Keys**: After logging in, use the `/user/key` endpoint, input an access key (ak), and you will receive the corresponding secret key (sk).

### 3. Configure Your Application

In your project's `application.yml`, configure the SDK by adding your access key and secret key:

```yaml
rand-api:
  client:
    access-key: ak
    secret-key: sk
```

### Inject and Use the RandClient

Now, in the parts of your application where you need to use the SDK, inject the `RandClient` via Spring's `@Autowired` annotation.

For example:

```java
@Autowired
private RandClient randClient;

@Test
void numGet() {
    int result = randClient.genRandNumberZeroToTen();
    System.out.println(result);
}
```
This will call the genRandNumberZeroToTen() method from the SDK, which returns a random integer between 0 and 10.

