package com.walmart.mts.service;

import java.util.ArrayList;
import java.util.List;

import com.walmart.mts.database.MovieTheaters;
import com.walmart.mts.entities.MovieTheater;
import com.walmart.mts.entities.Screen;
import com.walmart.mts.request.SeatAllocationRequest;
import com.walmart.mts.request.handler.SeatAllocationRequestHandler;
import com.walmart.mts.response.SeatAllocationResponse;
import com.walmart.mts.response.handler.SeatAllocationResponseHandler;
import com.walmart.mts.util.Util;

/**
 * A movie theater seat reservation service that takes inputs from command line
 * to read theater seat reservation data from a file and saves the output to an
 * output file.
 * 
 * @author shivam.maharshi
 */
public class SeatReservationConsoleService {

  private static final int SCREEN_ID = 1;
  private static final int THEATER_ID = 1;
  private SeatAllocationRequestHandler requestHandler = new SeatAllocationRequestHandler();
  private SeatAllocationResponseHandler responseHandler = new SeatAllocationResponseHandler();

  /**
   * Allocates seats for requests in the inFile for a {@link Screen} in the
   * given {@link MovieTheater}.
   * 
   * @param inFile
   *          - File path for the input file holding the request identifier and
   *          seats requested data in format [RXXXX][space][#number]
   * @param outFile
   *          - File path where the reservation output is saved in format
   *          [REQ_ID][space][Seat Identifiers]
   * @param rows
   *          - Number of the rows present in the theater.
   * @param cols
   *          - Number of the columns present in the theater.
   * 
   * @param layoutFile
   *          - File path where the reservation screen layout representing the
   *          screen in 2D space is saved. This is an optional parameter.
   */
  public void reserve(String inFile, String outFile, int rows, int cols, String layoutFile) {
    MovieTheaters.setup(rows, cols);
    List<String> input = Util.read(inFile);
    List<String> output = new ArrayList<String>();
    for (String s : input) {
      String[] ss = s.split(" ");
      if (ss.length == 2) {
        try {
          int seats = Integer.parseInt(ss[1]);
          String id = ss[0];
          if (!id.isEmpty()) {
            SeatAllocationResponse response = requestHandler
                .process(new SeatAllocationRequest(id, seats, SCREEN_ID, THEATER_ID));
            output.add(responseHandler.dispatch(response));
          } else {
            System.out.println("Incorrect input entry: " + s + ". ReqId cannot be empty.");
          }
        } catch (NumberFormatException e) {
          System.out.println("Incorrect input entry: " + s + "[NumberFormatException] " + ss[1] + " is not a number.");
        }
      } else {
        System.out.println("Incorrect input entry: " + s + ". Entry must be in the form - RXXXX <space> #number");
      }
    }
    Util.write(output, outFile);
    if (layoutFile != null)
      Util.write(Util.getSeatAllocation(output, rows, cols), layoutFile);
  }

  /**
   * Takes parameters from the command line and executes the reserver method of
   * {@link SeatReservationConsoleService}.
   * 
   * Sample command - java -cp "MovieTheaterServices.jar"
   * com.walmart.mts.service.SeatReservationConsoleService
   * --input=C:/Users/Sam/Downloads/sample-input.txt
   * --output=C:/Users/Sam/Downloads/sample-output.txt --rows=10 --cols=10
   * 
   * @param args
   *          - Input arguments from the console - {--input, --output, --rows &
   *          --cols}
   */
  public static void main(String[] args) {
    SeatReservationConsoleService srs = new SeatReservationConsoleService();
    String INPUT = null, OUTPUT = null, LAYOUT = null;
    Integer ROWS = null, COLS = null;
    try {
      if (args != null) {
        for (String s : args) {
          s = s.trim();
          if (!s.isEmpty() && s.startsWith("--input=")) {
            INPUT = s.split("=")[1];
          } else if (!s.isEmpty() && s.startsWith("--output=")) {
            OUTPUT = s.split("=")[1];
          } else if (!s.isEmpty() && s.startsWith("--rows=")) {
            ROWS = Integer.parseInt(s.split("=")[1]);
          } else if (!s.isEmpty() && s.startsWith("--cols=")) {
            COLS = Integer.parseInt(s.split("=")[1]);
          } else if (!s.isEmpty() && s.startsWith("--layout=")) {
            LAYOUT = s.split("=")[1];
          }
        }
      } else {
        System.out.println(
            "Please pass the inputs in this format: --input={FILEPATH} --output={FILEPATH} --rows={POSITIVE_INTEGER} --cols={POSITIVE_INTEGER} --layout={FILEPATH|OPTIONAL}");
        return;
      }
    } catch (NumberFormatException e) {
      System.out.println("Please pass a numeric value for rows & cols in this format: --rows=10 --cols=10");
      return;
    }

    if (INPUT == null) {
      System.out.println("Please pass the full input file path in this format: --input=C:/work/temp/input.txt");
      return;
    } else if (!Util.exists(INPUT)) {
      System.out.println(
          "File does not exists! Please enter a valid input file path in this format: --input=C:/work/temp/input.txt");
      return;
    }

    if (OUTPUT == null) {
      System.out.println("Please pass the full output file path in this format: --output=C:/work/temp/output.txt");
      return;
    } else if (!Util.isValidFilePath(OUTPUT)) {
      System.out.println(
          "Invalid file path! Please enter a valid output file path in this format: --output=C:/work/temp/output.txt");
      return;
    }

    if (LAYOUT != null && !Util.isValidFilePath(LAYOUT)) {
      System.out.println(
          "Invalid file path! Please enter a valid layout file path in this format: --layout=C:/work/temp/layout.txt");
      return;
    }

    if (ROWS == null) {
      System.out.println("No input received. Please pass a value to --rows.");
      return;
    }

    if (COLS == null) {
      System.out.println("No input received. Please pass a value to --rows.");
      return;
    }

    if (ROWS < 1) {
      System.out.println("Please pass a positive value to --rows.");
      return;
    }

    if (COLS < 1) {
      System.out.println("Please pass a positive value to --cols.");
      return;
    }

    srs.reserve(INPUT, OUTPUT, ROWS, COLS, LAYOUT);
  }

}
