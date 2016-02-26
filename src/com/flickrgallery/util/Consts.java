package com.flickrgallery.util;


/**
 Collected constants of general utility.
*/
public final class Consts  {

  /** Opposite of {@link #FAILS}.  */
  public static final boolean PASSES = true;
  /** Opposite of {@link #PASSES}.  */
  public static final boolean FAILS = false;

  /** Opposite of {@link #FAILURE}.  */
  public static final boolean SUCCESS = true;
  /** Opposite of {@link #SUCCESS}.  */
  public static final boolean FAILURE = false;

  /**
   Useful for {@link String} operations, which return an index of <tt>-1</tt> when an item is not found.
  */
  public static final int NOT_FOUND = -1;

  /** System property - <tt>line.separator</tt>*/
  public static final String NEW_LINE = System.getProperty("line.separator");
  /** System property - <tt>file.separator</tt>*/
  public static final String FILE_SEPARATOR = System.getProperty("file.separator");
  /** System property - <tt>path.separator</tt>*/
  public static final String PATH_SEPARATOR = System.getProperty("path.separator");

  public static final String EMPTY_STRING = "";
  public static final String COMMA_SPACE= ", ";
  public static final String SPACE = " ";
  public static final String TAB = "\t";
  public static final String SINGLE_QUOTE = "'";
  public static final String PERIOD = ".";
  public static final String DOUBLE_QUOTE = "\"";
  public static final String REGEX_WHITESPACE= "\\s";

  public static final String LOOKUP_SPACED_HYPHEN= " - ";

  private Consts(){
    //this prevents even the native class from
    //calling this constructor as well :
    throw new AssertionError();
  }
}