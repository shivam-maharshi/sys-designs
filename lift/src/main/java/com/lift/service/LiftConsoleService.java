package com.lift.service;

import java.util.ArrayList;
import java.util.List;

import com.lift.database.Lifts;
import com.lift.request.LiftAllocationRequest;
import com.lift.request.handler.LiftAllocationRequestHandler;
import com.lift.response.LiftAllocationResponse;
import com.lift.response.handler.LiftAllocationResponseHandler;
import com.lift.util.Util;

/**
 * This service is responsible for taking lift sequencing input from the console
 * via an input file and storing it back in an output file.
 * 
 * @author shivam.maharshi
 */
public class LiftConsoleService {

  private LiftAllocationRequestHandler requestHandler = new LiftAllocationRequestHandler();
  private LiftAllocationResponseHandler responseHandler = new LiftAllocationResponseHandler();
  private LiftCentralService centralService = new LiftCentralService();

  public void execute(String input, String output, int floors, int lifts) {
    Lifts.setup(floors, lifts);
    List<String> in = Util.read(input);
    List<String> out = new ArrayList<>();
    for (String s : in) {
      String[] ss = s.split(" ");
      Integer start = null, end = null;
      if (ss.length == 3) {
        try {
          start = Integer.parseInt(ss[2]);
        } catch (NumberFormatException e) {
          System.out.println("Incorrect input entry: " + s + "[NumberFormatException] " + ss[2] + " is not a number.");
        }
        try {
          end = Integer.parseInt(ss[3]);
        } catch (NumberFormatException e) {
          System.out.println("Incorrect input entry: " + s + "[NumberFormatException] " + ss[2] + " is not a number.");
        }
        String id = ss[0];
        if (!id.isEmpty() && start != null && end != null) {
          LiftAllocationResponse response = requestHandler.process(new LiftAllocationRequest(id, start, end));
          if (centralService.serveRequest(response.getLift(), start))
            out.add(responseHandler.dispatch(response));
        } else {
          System.out.println("Incorrect input entry: " + s + ". ReqId cannot be empty.");
        }
      } else {
        System.out.println(
            "Incorrect input entry: " + s + ". Entry must be in the form - #Integer <space> #Integer <space> #Integer");
      }
    }
    Util.write(out, output);
  }

  public static void main(String[] args) {
    LiftConsoleService lcs = new LiftConsoleService();
    Integer FLOORS = null, LIFTS = null;
    String INPUT = null, OUTPUT = null;
    try {
      if (args != null) {
        for (String s : args) {
          s = s.trim();
          if (!s.isEmpty() && s.startsWith("--input=")) {
            INPUT = s.split("=")[1];
          } else if (!s.isEmpty() && s.startsWith("--output=")) {
            OUTPUT = s.split("=")[1];
          } else if (!s.isEmpty() && s.startsWith("--floors=")) {
            FLOORS = Integer.parseInt(s.split("=")[1]);
          } else if (!s.isEmpty() && s.startsWith("--lifts=")) {
            LIFTS = Integer.parseInt(s.split("=")[1]);
          }
        }
      } else {
        System.out.println(
            "Please pass the inputs in this format: --input={FILEPATH} --output={FILEPATH} --floors={POSITIVE_INTEGER} --lifts={POSITIVE_INTEGER}");
        return;
      }
    } catch (NumberFormatException e) {
      System.out.println("Please pass a numeric value for floors & lifts in this format: --floors=10 --lifts=10");
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

    if (FLOORS == null) {
      System.out.println("No input received. Please pass a value to --floors.");
      return;
    }

    if (LIFTS == null) {
      System.out.println("No input received. Please pass a value to --floors.");
      return;
    }

    if (FLOORS < 1) {
      System.out.println("Please pass a positive value to --floors.");
      return;
    }

    if (LIFTS < 1) {
      System.out.println("Please pass a positive value to --lifts.");
      return;
    }

    lcs.execute(INPUT, OUTPUT, FLOORS, LIFTS);
  }

}
