package com.walmart.mts.service;

import java.util.List;

import org.junit.Test;

import com.walmart.mts.util.Util;

import junit.framework.TestCase;

/**
 * Test cases for {@link SeatReservationConsoleService}.
 * 
 * @author shivam.maharshi
 */
public class SeatReservationConsoleServiceTest extends TestCase {

  private static final String FILE_R = System.getProperty("user.dir") + "/src/test/resources/main_test_input.txt";
  private static final String FILE_W = System.getProperty("user.dir") + "/src/test/resources/main_test_output.txt";
  private static final String FILE_L = System.getProperty("user.dir") + "/src/test/resources/main_test_output.txt";

  @Test
  public void testSuccessfulReserveSavesValidReservationOutputFile() {
    SeatReservationConsoleService
        .main(new String[] { "--rows=2", "--cols=2", "--input=" + FILE_R, " --output=" + FILE_W });

    List<String> l = Util.read(FILE_W);
    assertEquals(1, l.size());
    assertEquals("R001 A0, A1, B0", l.get(0));
    Util.delete(FILE_W);
  }

  @Test
  public void testSuccessfulReserveSavesValidReservationOptionalLayoutFile() {
    SeatReservationConsoleService.main(
        new String[] { "--rows=2", "--cols=2", "--input=" + FILE_R, " --output=" + FILE_W, "--layout=" + FILE_L });

    List<String> l = Util.read(FILE_L);
    assertEquals(2, l.size());
    assertEquals("R001-R001", l.get(0));
    assertEquals("R001-null", l.get(1));
    Util.delete(FILE_W);
    Util.delete(FILE_L);
  }

}
