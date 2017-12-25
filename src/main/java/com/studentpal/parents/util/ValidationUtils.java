package com.studentpal.parents.util;

import java.util.regex.Pattern;

public class ValidationUtils {

  private static Pattern mobilePattern = Pattern.compile("^\\d{11}$");

  public static boolean checkMobile(String mobile) {
    return mobilePattern.matcher(mobile).matches();
  }

}
