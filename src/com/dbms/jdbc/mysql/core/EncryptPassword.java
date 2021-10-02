/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbms.jdbc.mysql.core;

/**
 *
 * @author Jur Yel
 */
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;
public class EncryptPassword {
   public static String getHash(byte[] inputBytes, String algorithm){
       String hashValue = "";
       try{
           MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
           messageDigest.update(inputBytes);
           byte[] digestedBytes = messageDigest.digest();
           hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
       }
       catch(Exception exc){
           exc.printStackTrace();
       }
       return hashValue;
   }
   
   public static void main(String[] args){
       String pass1 = "password123";
       String pass2 = "password123";
       
       System.out.println(getHash(pass1.getBytes(),"MD5"));
       
       if(getHash(pass1.getBytes(),"MD5").equals(getHash(pass2.getBytes(),"MD5"))){
           System.out.println("Password match!");
       }
       else{
           System.out.println("Password incorrect");
       }
   }
}
