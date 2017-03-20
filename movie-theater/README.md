# [MovieTheaterSeating](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

## [1. Introduction](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)
Movie Theater Seating project allocates seats in a movie theater to incoming requests in an efficient way which maximizes theater profit as well as gives closely located seats made in a single request. To efficiently allocate seats for maximizing profit for the movie theater, as well as to give customers closely located seats, we use a clustered seat allocation algorithm. In the current support it is capable of taking seat reservation request input from a file and writes the seat reservation details to an output file. However the design is flexible to take inputs and dispatch outputs to any source with code extension.

For the problem specifications please refer to /sample_data/MovieTheaterSeatingHomework.pdf.

## [2. Usage](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)
Goto the directory containing MovieTheaterSeating project and run the commands below:

```
cd MovieTheaterSeating/
```

### [2.1 Run Seat Reservation Console Service](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)
Run these commands to generate a reservation output file for seat reservation requests passed via the input file.

```
gradle clean build

java -cp build/libs/MovieTheaterSeating-1.0.jar com.walmart.mts.service.SeatReservationConsoleService --input=[INPUT_FILEPATH] --output=[OUTPUT_FILEPATH] --rows=[#_OF_ROWS_IN_SCREEN] --cols=[#_OF_COLUMNS_IN_SCREEN] --layout=[LAYOUT_FILEPATH | Optional]

```

#### [2.1.1 Parameters](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)
1. --input: File path for the input file holding the request identifier and seats requested data in format [RXXXX]<space>[#number].
2. --output: File path where the reservation output is saved in format [REQ_ID]<space>[Seat Identifiers].
3. --rows: Number of the rows present in the theater screen. Must be a positive integer.
4. --cols: Number of the columns present in the theater screen. Must be a positive integer.
5. --layout: File path where the reservation screen layout representing the screen in 2D space is saved. This is an optional parameter.

#### [2.1.2 Sample Command](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

```
java -cp build/libs/MovieTheaterSeating-1.0.jar com.walmart.mts.service.SeatReservationConsoleService --input=C:/Shivam/Work/WorkSpace/MovieTheaterSeating/sample_data/sample-input.txt --output=C:/Shivam/Work/WorkSpace/MovieTheaterSeating/sample_data/sample-output.txt	--rows=10 --cols=10 --layout=C:/Shivam/Work/WorkSpace/MovieTheaterSeating/sample_data/sample-layout.txt
```

### [2.2 Run Build](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

```
gradle clean build
```

### [2.3 Run Build Without Tests](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

```
gradle clean build -x test
```

## [3. Design](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

Given below are the UML diagrams for this design.

#### [3.1 Allocator](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Allocator](/movie-theater/uml_diagrams/Allocator.png?raw=true "Allocator")

#### [3.2 Entities](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Entities](/movie-theater/uml_diagrams/Entities.png?raw=true "Entities")

#### [3.3 Request & Response](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Request & Response](/movie-theater/uml_diagrams/Request%26Response.png?raw=true "Request & Response")

#### [3.4 Request & Response Handler](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Request & Response Handler](/movie-theater/uml_diagrams/Request%26ResponseHandler.png?raw=true "Request & Response Handler")

#### [3.5 Seat Reservation Service](https://github.com/shivam-maharshi/sys-designs/edit/master/movie-theater)

![Seat Reservation Service](/movie-theater/uml_diagrams/SeatResService.png?raw=true "Seat Reservation Service")
