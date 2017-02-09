package com.lift.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to be used for common utility functions like interacting with
 * {@link File}, parsing inputs, etc.
 * 
 * @author shivam.maharshi
 */
public class Util {

  /**
   * Parses the output file with the reservation data and saves the layout of
   * the movie theater according to the requests.
   * 
   * @param list
   *          - List holding the reservation data.
   * @param rows
   *          - Maximum number of rows present in the screen.
   * @param cols
   *          - Maximum number of columns present in the screen.
   * @return list - List representing the theater layout with reservation
   *         identifiers.
   */
  public static List<String> getSeatAllocation(List<String> list, int rows, int cols) {
    List<String> res = new ArrayList<String>();
    Map<String, String> m = new HashMap<String, String>();
    for (String s : list) {
      // Avoid the not enough seat messages.
      if (s.startsWith("R")) {
        String[] ss = s.split(", ");
        String reqId = ss[0].split(" ")[0];
        m.put(ss[0].split(" ")[1], reqId);
        for (int i = 1; i < ss.length; i++) {
          m.put(ss[i], reqId);
        }
      }
    }

    // Store seat allocation.
    for (int i = 0; i < rows; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < cols; j++) {
        sb.append(m.get(Util.getAlphabeticalValue(i) + j));
        if (j < cols - 1)
          sb.append("-");
      }
      res.add(sb.toString());
    }
    return res;
  }

  /**
   * Returns the alphabetical representation for a given number. For example, 0
   * maps to A, 1 maps to B, 26 maps to AA, 27 maps to AB etc.
   * 
   * @param num
   *          - The number to be converted into its alphabetical representation.
   * @return alphaVal - The alphabetical value for the given input number.
   */
  public static String getAlphabeticalValue(int num) {
    String alphaVal = "" + (char) (num % 26 + 65);
    num /= 26;
    while (num > 0) {
      num--;
      alphaVal = (char) (num % 26 + 65) + alphaVal;
      num /= 26;
      num--;
    }
    return alphaVal;
  }

  /**
   * Reads the input file and returns its content as a {@link List<String>} with
   * each line as a separate entry.
   * 
   * @param filepath
   *          - Path of the input file to read.
   * @return list - List of string holding the file data in-memory.
   */
  public static List<String> read(String filepath) {
    List<String> list = new ArrayList<String>();
    FileReader fr = null;
    try {
      fr = new FileReader(filepath);
      BufferedReader file = new BufferedReader(fr);
      String line = null;
      while ((line = file.readLine()) != null) {
        list.add(line.trim());
      }
      file.close();
    } catch (IOException e) {
      System.out.println("Error occurred while writing to: " + filepath);
      System.out.println("Error Message: " + e.getMessage());
    } finally {
      if (fr != null) {
        try {
          fr.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return list;
  }

  /**
   * Writes the given {@link List<String>} into a file at the given path. If the
   * file is not present, than it is created. If the file is present than it is
   * overwritten
   * 
   * @param list
   *          - List of string to write into file.
   * @param filepath
   *          - Path of the file at which the List is to be written.
   */
  public static void write(List<String> list, String filepath) {
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(filepath);
      Writer writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
      for (String line : list)
        writer.write(line + "\n");
      writer.flush();
      writer.close();
      System.out.println("File successfully written to: " + filepath);
    } catch (IOException e) {
      System.out.println("Error occurred while writing to: " + filepath);
      System.out.println("Error Message: " + e.getMessage());
    } finally {
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * Deletes the file at the given file path.
   * 
   * @param filepath
   *          - Path of the file to be delete.
   */
  public static void delete(String filepath) {
    try {
      new File(filepath).delete();
    } catch (Exception e) {
      // Do nothing as file doesn't exists.
    }
  }

  /**
   * Checks if a file is present at the given file path.
   * 
   * @param filepath
   *          - Path of the file to be checked for existence.
   */
  public static boolean exists(String filepath) {
    try {
      return new File(filepath).isFile();
    } catch (Exception e) {
      // Do nothing.
    }
    return false;
  }

  /**
   * Checks if a given file path is valid. It can either be a invalid file path
   * a valid directory path but not a file. Both cases should return false.
   * Hence file might not exists but the path should be valid for creating a
   * file.
   * 
   * @param filepath
   *          - File path to be validated.
   */
  public static boolean isValidFilePath(String filepath) {
    try {
      // Would signify that file path is a directory.
      if (filepath.endsWith("/"))
        return false;

      StringBuilder sb = new StringBuilder();
      String[] fsegments = filepath.split("/");
      for (int i = 0; i < fsegments.length - 1; i++)
        sb.append(fsegments[i]).append("/");
      return new File(sb.toString()).isDirectory();
    } catch (Exception e) {
      return false;
    }
  }

}
