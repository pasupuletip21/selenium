package com.registration.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ReadInputFile {
    public  static List<String> getRegNum() throws IOException {
        BufferedReader br = null;
        String number=" ";
        String[] word = null;
        String regNum=" ";
        List<String> regNumbers= new ArrayList<String>();
        try{

            br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/car_input.txt"));
            String strLine;

            while ((strLine = br.readLine()) != null)   {
                String reg = "(^[A-Z]{2}[0-9]{2}([A-Z]{3}|\\s[A-Z]{3})$)";
                word= strLine.split(" ");
                for (String str : word) {
                    if (Pattern.matches(reg, str)) {
                        regNumbers.add(str);
                    }
                }

            }

        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }finally {
            br.close();
        }
        return regNumbers;
    }
    public static List<String> resOutput() throws IOException, IOException {
        BufferedReader br = null;
        String number=" ";
        String output=" ";
        String outLine=" ";
        String[] outtext;
        List<String> l1=new ArrayList<String>();
        try{
            br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/car_output.txt"));
            while ((outLine = br.readLine()) != null) {
                l1.add(outLine);

            }

            // br.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }finally {
            br.close();
        }

        return  l1;
    }
}

