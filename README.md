# Connector Template

Camunda Outbound Connector Template - No Fat Jar Configuration

## Environment

- Minimum Java 17

## Build

You can package the Connector by running the following command:

```bash
mvn clean package
```

This will create the following artifacts:

- A thin JAR without dependencies for the project with the Connector Template
- A JAR for the Runtime Environment, where the Connector Template JAR can run 

If you want to create a fat JAR containing all dependencies for the connector template, you will need another pom.xml build phase definition.
You can see an example on how to do that here: https://github.com/camunda/connector-template-outbound

However, this setting is not a production ready configuration, it is more of a simple and ease to set up environment for learning and playing with Connectors.

