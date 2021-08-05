/*
Write a java program with the following requirements:
- It defines a class (the class implements Comparable) that represents a Time with 3
attributes; hour, minute and second.
- The program asks the user to enter the size of an array and then creates an array of time
objects. The array is filled with a set of time objects. The values (hour, minute, second) of
each object can be created randomly or it is entered by the user.
- The program sorts the array of time objects in an ascending order and then shows the
results. It should also check if all the time objects are distinct and print a proper message
accordingly.
 */


import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

public class A2Q6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the Array size :");

        int size = Integer.parseInt(in.nextLine());
        TimeComparable [] array = new TimeComparable[size];
        Random rand = new Random();

        for(int i=0; i<size; i++) {
            int hour = rand.nextInt(10);
            int minute = rand.nextInt(20);
            int second = rand.nextInt(30);
            TimeComparable time = new TimeComparable(hour, minute, second);
            array[i] = time;
        }
        Arrays.sort(array);

        System.out.println("Time objects are: ");
        for(int i=0; i<size; i++) {
            System.out.println(array[i].hour+":"+array[i].minute+":"+array[i].second);
        }

        if(TimeComparable.isEqual) {
            System.out.println(" One or More than One time objects are equal");
        }
        else {
            System.out.println("No time objects are equal");
        }
    }
}

class TimeComparable implements Comparable<TimeComparable>{

    int hour, minute, second;
    static boolean isEqual = false;

    public TimeComparable(int h, int m, int s) {

        hour = h;
        minute = m;
        second = s;
    }

    public int compareTo(TimeComparable obj) {
        if(hour==obj.hour) {
            if(minute==obj.minute) {
                if(second==obj.second) {
                    isEqual=true;
                    return 0;
                }
                else {
                    return second-obj.second;
                }
            }
            else {
                return minute-obj.minute;
            }
        }
        return hour-obj.hour;
    }

}