package com.toba.password.PasswordUtil;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PasswordEncoder {

  private static Random random = new Random((new Date()).getTime());
  
  /**
   * Encrypt password by using SHA-256 algorithm, encryptedPassword length is 32 bits
   * @param clearTextPassword
   * @return
   * @throws NoSuchAlgorithmException
   * reference http://java.sun.com/j2se/1.4.2/docs/api/java/security/MessageDigest.html
   */
  public static String getEncryptedPassword(String clearTextPassword)   {  
  
    
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(clearTextPassword.getBytes());
      return new sun.misc.BASE64Encoder().encode(md.digest());
    } catch (NoSuchAlgorithmException e) {
      //_log.error("Failed to encrypt password.", e);
    }
    return "";
  }
    
}