import java.util.*;
import java.io.*;

public class TargetedHiring {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("hiring_info.txt"));
        PrintStream output = new PrintStream(new File("hiring_output.txt"));

        int[] counts = determineMajor(input);
        reportStatistics(counts, output);        
    }

    public static int[] determineMajor(Scanner input) {
        int[] a = new int[4];
        while(input.hasNext()){
            String grade = input.next();
            String major = input.next();
            if(major.equals("CS")) {
                if(grade.equals("Freshman")) {
                    a[0]+=1;
                }else if(grade.equals("Sophomore")) {
                    a[1]+=1;
                }else if(grade.equals("Junior")) {
                    a[2]+=1;
                }else{
                    a[3]+=1;
                }
            }
        }
        return a;
    }

    public static void reportStatistics(int[] counts, PrintStream output) {
        output.println("Freshman class has " + counts[0] + " CS Majors");
        output.println("Sophomore class has " + counts[1] + " CS Majors");
        output.println("Junior class has " + counts[2] + " CS Majors");
        output.println("Senior class has " + counts[3] + " CS Majors");
        output.print("Suggested Hire: ");
        int max1 = Math.max(counts[0], counts[1]);
        int max2 = Math.max(counts[2], counts[3]);
        int max = Math.max(max1, max2);
        if(counts[0] == max) {
                output.print("Freshman");
            }else if(counts[1] == max) {
                output.print("Sophomore");
            }else if(counts[2] == max) {
                output.print("Junior");
            }else{
                output.print("Senior");
        }
        output.println(" class");
    }
}
