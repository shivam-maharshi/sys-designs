# [MovieTheaterSeating] (https://github.com/shivam-maharshi/oop-designs/edit/master/movie-theater)

Movie Theater Seating project solves allocates seats in a movie theater to incoming requests in an efficient way which maximizes theater profit as well as gives closely located seats made in a single request. In the current support it is capable of taking seat reservation request input from a file and writes the seat reservation details to an output file. However the design is flexible to take inputs and dispatch outputs to any source with code extension.

For the problem specifications please refer to /sample_data/MovieTheaterSeatingHomework.pdf.

## Usage

Goto the directory containing MovieTheaterSeating project and run the commands below:

```
cd MovieTheaterSeating/
```

### Run Seat Reservation Console Service

Run these commands to generate a reservation output file for seat reservation requests passed via the input file.

```
gradle clean build

java -cp build/libs/MovieTheaterSeating-1.0.jar com.walmart.mts.service.SeatReservationConsoleService --input=[INPUT_FILEPATH] --output=[OUTPUT_FILEPATH] --rows=[#_OF_ROWS_IN_SCREEN] --cols=[#_OF_COLUMNS_IN_SCREEN] --layout=[LAYOUT_FILEPATH | Optional]

```

#### Parameters

1. --input: File path for the input file holding the request identifier and seats requested data in format [RXXXX]<space>[#number].
2. --output: File path where the reservation output is saved in format [REQ_ID]<space>[Seat Identifiers].
3. --rows: Number of the rows present in the theater screen. Must be a positive integer.
4. --cols: Number of the columns present in the theater screen. Must be a positive integer.
5. --layout: File path where the reservation screen layout representing the screen in 2D space is saved. This is an optional parameter.

#### Sample Command

```
java -cp build/libs/MovieTheaterSeating-1.0.jar com.walmart.mts.service.SeatReservationConsoleService --input=C:/Shivam/Work/WorkSpace/MovieTheaterSeating/sample_data/sample-input.txt --output=C:/Shivam/Work/WorkSpace/MovieTheaterSeating/sample_data/sample-output.txt	--rows=10 --cols=10 --layout=C:/Shivam/Work/WorkSpace/MovieTheaterSeating/sample_data/sample-layout.txt
```

### Run Build

```
gradle clean build
```

### Run Build Without Tests

```
gradle clean build -x test
```
