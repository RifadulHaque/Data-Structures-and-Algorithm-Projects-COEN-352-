/*
Fast 3-way partitioning. (J. Bentley and D. Mcllroy) Implement an entropy-optimal sort based on
keeping item's with equal keys at both the left and right ends of the subarray. Maintain indices p
and q such that a[lo..p-1] and a[q+1..hi] are all equal to a[lo], an index i such that a[p..i-1] are
all less than a[lo], and an index j such that a[j+1..q] are all greater than a[lo]. Add to the inner
partitioning loop code to swap a[i] with a[p] (and increment p) if it is equal to v and to swap a[j]
with a[q] (and decrement q) if it is equal to v before the usual comparisons of a[i] and a[j]
with v. After the partitioning loop has terminated, add code to swap the items with equal keys
into position.
Note : This code complements the code given in thetext, in the sense that it does extra swaps for
keys equal to the partitioning item’s key, while the code in the text does extra swaps for keys that
are not equal to the partitioning item’s key

 */



import java.util.Scanner;

public class A2Q5 {
    public static void sort(int[] a) {

        int n= a.length - 1;
        quickSort(a, 0, n);
}
public static void quickSort(int x[], int lower, int higher)
{
    int temp;
    int minimum = lower, maximum = higher;
    int middle = x[(lower + higher) / 2];

    while (minimum <= maximum)
    {
        while (x[minimum] < middle)
            minimum++;
        while (x[maximum] > middle)
            maximum--;
        if (minimum <= maximum)
        {
            temp = x[minimum];
            x[minimum] = x[maximum];
            x[maximum] = temp;

            minimum++;
            maximum--;
        }
    }

    if (lower < maximum)
        quickSort(x, lower, maximum);
    if (minimum < higher)
        quickSort(x, minimum, higher);
}
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner( System.in );

        int j, i;

        System.out.print("Number of elements : ");
        j = keyboard.nextInt();

        int a[] = new int[ j ];

        System.out.println("\nEnter "+ j +" elements");
        for (i = 0; i < j; i++) {
            a[i] = keyboard.nextInt();
        }

        sort(a);
        System.out.println(" ");
        System.out.println("Elements after sorting ");
        for (i = 0; i < j; i++){
            System.out.print(a[i]+" ");
        }

        System.out.println();

        keyboard.close();
    }
}