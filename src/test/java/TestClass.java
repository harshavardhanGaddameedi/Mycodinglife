import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TestClass {
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
            char [] target = str[i].toCharArray();
            count=0;
            //System.out.print(length);
            for(int j=0;j<target.length;j++) {
                if (target[j]== 't'){
                    count++;
                }}

                if ((count == 1) || (count == 3)) {
                    for (int t = str[i].length() - 1; t >= 0; t--){
                        System.out.print(target[t]);
                    }
            }


        }


    }
}