package com.walmart.mts.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test cases for {@link Util} class.
 * 
 * @author shivam.maharshi
 */
public class UtilTest extends TestCase {

  private static final String FILE_R = System.getProperty("user.dir") + "/src/test/resources/util_test_input.txt";
  private static final String FILE_W = System.getProperty("user.dir") + "/src/test/resources/util_test_output.txt";

  @Test
  public void testGetAlphabeticalValueMethodReturnsCorrectValue() {
    assertEquals("A", Util.getAlphabeticalValue(0));
    assertEquals("Z", Util.getAlphabeticalValue(25));
    assertEquals("AA", Util.getAlphabeticalValue(26));
    assertEquals("AB", Util.getAlphabeticalValue(27));
    assertEquals("AZ", Util.getAlphabeticalValue(51));
  }

  @Test
  public void testReadReturnsCorrectDataFromFile() {
    List<String> l = Util.read(FILE_R);
    assertEquals("line1", l.get(0));
    assertEquals("line2", l.get(1));
  }

  @Test
  public void testWriteMethodWritesCorrectDataToFile() {
    List<String> l = new ArrayList<>();
    l.add("line0");
    l.add("line1");
    Util.write(l, FILE_W);
    l = Util.read(FILE_W);
    assertEquals("line0", l.get(0));
    assertEquals("line1", l.get(1));
    Util.delete(FILE_W);
  }

  @Test
  public void testExistsReturnsTrueForExistingFilePath() {
    List<String> l = new ArrayList<>();
    l.add("line0");
    Util.write(l, FILE_W);
    assertEquals(true, Util.exists(FILE_W));
    Util.delete(FILE_W);
  }

  @Test
  public void testExistsReturnsFalseForNonExistingFilePath() {
    assertEquals(false, Util.exists(FILE_W));
  }

  @Test
  public void testIsValidFilePathReturnsTrueForValidFilePath() {
    // File doesn't exists but the path is valid for creating a file.
    assertEquals(false, Util.exists(FILE_W));
  }

  @Test
  public void testIsValidFilePathReturnsFalseForValidDirectories() {
    assertEquals(false, Util.exists(System.getProperty("user.dir")));
  }

  @Test
  public void testIsValidFilePathReturnsFalseForInvalidDirectories() {
    assertEquals(false, Util.exists("/a/b/c/d/e/f/g"));
  }

  @Test
  public void testIsValidFilePathReturnsFalseForInvalidFilePaths() {
    assertEquals(false, Util.exists(FILE_W));
  }

}
