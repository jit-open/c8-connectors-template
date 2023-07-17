# Connector Template

Camunda Outbound Connector Template - No Fat Jar Configuration

## Environment

- Minimum Java 17

## Build and Run

You can build the Connector Template by running the following command:

```bash
mvn clean install
```

This will create the following artifacts:

- A thin JAR without dependencies for the project with the Connector Template

If you want to create a fat JAR containing all dependencies for the connector template, you will need another pom.xml build phase definition.
You can see an example on how to do that here: https://github.com/camunda/connector-template-outbound


Then you can build the Running Environment by running:
```bash
mvn clean install
```

So that the JAR of the Connector Template is loaded in the runtime project.

Then run the class `ConnectorRuntime` with Spring.

However, this setting is not a production ready configuration, it is more of a simple and ease to set up environment for learning and playing with Connectors.

