/*
Bitonic search: An array is bitonic if it is comprised of an increasing sequence of integers
followed immediately by a decreasing sequence of integers. Write a program in java that, given a
bitonic array of N distinct int values, determines whether a given integer is in the array. Your
program should use ~3lg N compares in the worst case. 

 */


import java.util.Scanner;
class BitonicArraySearch {

    private static boolean searchIfBitonic(int[] array, int start, int end, int desirednumber, boolean aim) {
        int middlepoint = (start + end) / 2;
        if (array[middlepoint] == desirednumber) {
            return true;
        }
        if (start > end) {
            return false;
        }
        if ((aim && array[middlepoint] < desirednumber) || (!aim && array[middlepoint] > desirednumber)) {
            return searchIfBitonic(array, start, middlepoint-1, desirednumber, aim);
        } else {
            return searchIfBitonic(array, middlepoint+1, end, desirednumber, aim);
        }
    }


// Finding Peak element in the worst case

    private static int SearchForLargest(int[] array, int start, int end) {
        int middlepoint = (start + end) / 2;
        if (start == end) {
            return middlepoint;
        } else if (array[middlepoint] < array[middlepoint+1]) {
            return SearchForLargest(array, middlepoint+1, end);
        } else {
            return SearchForLargest(array, start,middlepoint);
        }
    }

    private static boolean LookFor(int[] array, int largest, int desirednumber) {

           //Element does not exist in the array
        return searchIfBitonic(array, 0, largest, desirednumber, false) ||
                searchIfBitonic(array, largest, array.length-1, desirednumber, true);//Element exist in the array
    }

    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5, 20,10,9, 8, 7,6 };

        int desirednumber = 0;
        int largest = SearchForLargest(list, 0, list.length-1);
        System.out.print("Highest Number index is: ");
        System.out.println(largest);

        Scanner keyboard= new Scanner(System.in);

        System.out.print("Enter the number 1 you want to check :");
        desirednumber=keyboard.nextInt();
        System.out.println(desirednumber + " is " + LookFor(list, largest, desirednumber));

        System.out.print("Enter the number 2 you want to check :");
        desirednumber=keyboard.nextInt();
        System.out.println(desirednumber + " is " + LookFor(list, largest, desirednumber));

        System.out.print("Enter the number 2 you want to check :");
        desirednumber=keyboard.nextInt();
        System.out.println(desirednumber + " is " + LookFor(list, largest, desirednumber));



    }
}