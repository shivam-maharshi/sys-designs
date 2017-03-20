# [Lift] (https://github.com/shivam-maharshi/sys-designs/edit/master/lift)

## [1. Introduction](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)
Lift project is an implementation of a lift operating system that fullfils end users request by assigning a lift from a lift pool. For an efficient lift scheduling, we use in minimum in-path distance lift allocation algorithm that tries to minimze the distance of a lift car from the request origination floor. In the current support it is capable of taking lift floor call requests input from a file and writing the lift allocation details to an output file. However the design is flexible to take inputs and dispatch outputs to any source with code extension.

## [2. Usage](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)
Goto the directory containing Lift project and run the commands below:

```
cd lift/
```

### [2.1 Run Lift Console Service](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)
Run these commands to generate an allocation output file for lift allocation requests passed via the input file.

```
gradle clean build

java -cp build/libs/oops-1.0.jar com.lift.service.LiftConsoleService --input=[INPUT_FILEPATH] --output=[OUTPUT_FILEPATH] --lifts=[#_OF_TOTAL_LIFTS] --floors=[#_OF_TOTAL_FLOORS]

```

#### [2.1.1 Parameters](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)
1. --input: File path for the input file holding the request identifier and floor requested data in format [REQ_ID]<space>[#interval]<space>[#start_floor]<space>[#end_floor].
2. --output: File path where the lift allocation output is saved in format [REQ_ID]<space>[Lift Identifier].
3. --lifts: Number of the lifts present in the given system. Must be a positive integer.
4. --floors: Number of the floors present in the given hall. Must be a positive integer.

#### [2.1.2 Sample Command](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)

```
java -cp build/libs/oops-1.0.jar com.lift.service.LiftConsoleService --input=C:/Shivam/Work/WorkSpace/oops-design/lift/sample_data/sample-input.txt --output=C:/Shivam/Work/WorkSpace/oops-design/lift/sample_data/sample-output.txt --lifts=4 --floors=50
```

### [2.2 Run Build](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)

```
gradle clean build
```

### [2.3 Run Build Without Tests](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)

```
gradle clean build -x test
```

## [3. Design](https://github.com/shivam-maharshi/sys-designs/edit/master/lift)

Given below are the UML diagrams for this design.

#### [3.1 Allocator](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Allocator](/movie-theater/uml_diagrams/Allocator.png?raw=true "Allocator")

#### [3.2 Entities](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Entities](/movie-theater/uml_diagrams/Entities.png?raw=true "Entities")

#### [3.3 Request & Response](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Request & Response](/movie-theater/uml_diagrams/Request%26Response.png?raw=true "Request & Response")

#### [3.4 Request & Response Handler](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Request & Response Handler](/movie-theater/uml_diagrams/Request%26ResponseHandler.png?raw=true "Request & Response Handler")

#### [3.5 Lift Console Service](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Seat Reservation Service](/movie-theater/uml_diagrams/SeatResService.png?raw=true "Seat Reservation Service")
