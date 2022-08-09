# sos-best-practices-app Project

## Architecture

## Inbound

## Outbound

## Service

## Code Generation

## Deployment

## Adding Items

## Built in Dependencies

## SLA Logging
This template contains an implemention for SLA Logging that allows for automatic SLA observability in Grafana.

Using it requires 3 steps.

1; Tag the method you wish to monitor with @SLARule and set the slaName.
2; Create an SLAChecker by implementing the interface SLAChecker and write the specific SLA to check for in the implementation.
3; Add the created SLAChecker to the @SLARule you have created.

Once the method is called, it is caught by the SLARuleInterceptor, it examines the return value by allowing your SLAChecker to check if it passes the SLA.
If it does, nothing happens, and everything continues as normal, but the registry counter for the given SLA rule is implemented with 1 positive count.
If it does not pass, everything still continues as normal, but the registry counter for the given SLA rule is implemented with 1 failed count.

This allows us to monitor the SLA rules using the metrics endpoint and as such, we can expose these results in Grafana.

## OAuth2


## AuditLog
There is an automatic audit log implemention as a part of this template.

The way it works is as follows.

You tag the method that should be auditlogged with @AuditLog and define the action name by setting the AudittedAction parameter.
At this point, once the method gets called, an Interceptor catches it, and logs the action out to the AuditLog.




####### --------------- QUARKUS README

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory. Be aware that it’s not an _über-jar_ as
the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/sos-best-practices-app-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.
