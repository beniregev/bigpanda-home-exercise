# BigPanda Home Exercise for Backend Position

## Purpose: 
Implement a Non Blocking Producer/Consumer stream processing service that exposes an HTTP api.

### Use a blackbox executable
 The executable spits out an infinite stream of lines of event data encoded in JSON:
* Linux    - https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-linux-amd64
* Mac OS X - https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-macosx-amd64
* Windows  - https://s3-us-west-1.amazonaws.com/bp-interview-artifacts/generator-windows-amd64.exe

## Service Requirements
* Expose these stats in an HTTP interface.
* Stream may encounter corrupt JSON lines and should handle such events well and without interruption.
#### It should consume the output of the generator and gather the following stats:
* Count of events by event type.
* Count of words encountered in the data field of the events. (e.g. “the” → 32, “me” → 5).

## Build
Edit "stream.generator.exe.path" property in src/main/resources/application.properties file, update it with path to generator.

Run `mvn clean install`

## Run
In project target directory run following command:
`java -jar application-0.0.1-SNAPSHOT.jar`

* Use http://localhost:8080/countEventsTypes URL for retrieve Event types counters
* Use http://localhost:8080/countWords URL for retrieve Words counters

## Improvements:
* Make application scalable using microservices/Docker
* HTML based client
* Implement logger
* Support sorted output for counters
 