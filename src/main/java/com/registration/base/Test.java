package com.registration.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String args[]) throws IOException {
        BufferedReader  br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/resources/car_input.txt"));
       System.out.println(br.readLine());
    }
}

