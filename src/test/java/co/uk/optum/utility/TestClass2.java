package co.uk.optum.utility;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TestClass2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String [] str=s.split(" ");
        int length;
        int count;
        for(int i=0;i<str.length;i++)
        {
            length= str[i].length();
            count=0;
            for(int j=0;j<length;j++) {
                if ((str[i].charAt(j)) == 't') {
                    count++;
                }}

                if ((count == 1) || (count == 3)) {
                    for (int t = str[i].length() - 1; t >= 0; t--){
                        System.out.print(str[i].charAt(t));
                    }
            }


        }



    }
}

