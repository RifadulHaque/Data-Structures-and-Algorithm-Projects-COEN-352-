/*
Sublinear extra space. Develop a merge implementation that reduces the extra space
        requirement to max(M, N/M), based on the following idea: Divide the array into N/M blocks of
        size M (for simplicity in this description, assume that N is a multiple of M). Then, (i) considering
        the blocks as items with their first key as the sort key, sort them using selection sort; and (ii) run
        through the array merging the first block with the second, then the second block with the third,
        and so forth.

*/

import java.util.Random;
import java.util.Scanner;
public class A2Q2 {
    public static void main(String[] args){

        Scanner keyboard= new Scanner(System.in);

        System.out.print("Enter the Size of the Array :");
        int S= keyboard.nextInt();

        System.out.print("Enter the number of elements in each Section :");
        int B= keyboard.nextInt();


        if (S % B !=0){
            System.out.println("invalid Input: N should" + "be a multiple of M");
            return;
        }

        int sections = S/B;
        Integer[] array = new Integer[S];
        Random rand = new Random();
        for (int i=0; i<S; i++){
            array[i] = rand.nextInt(99);
        }

        System.out.println("\nSize of the Array = " + S );
        System.out.println("Each section Size = " + B );
        System.out.println("Number of sections = " + sections );

        System.out.println();
        System.out.print("Original Array :  ");
        printArray(array, B);

        int b = 0;
        int section = 1;

        while(b < S)
        {
            System.out.println("\nSelection sort array " + "at section - " + section);
            selectionSort(array, b, b + B);
            printArray(array,B);
            b = b + B;
            section = section +1;
        }

        b=0;
        section = 1;
        while(!isSorted(array) && b < sections - 1){
            System.out.print("\nMerge the sections :");
            for(int i =0; i<section+1; i++){
                if(i==0)
                    System.out.print("{");
                if(i<section)
                    System.out.print((i+1)+", ");
                else if(i==section)
                    if(b==0)
                        System.out.print((i+1)+" } ");
                    else if( i == section)
                        System.out.print("}, "+(i+1));
                if(i == section)
                    System.out.print("\n");
            }
            merge(array, 0, (b+1) * B,((b+2)* B));
            printArray(array,B);
            b=b+1;
            section=section+1;
        }
        System.out.println("\nElements after sorted are :");
        printArray(array, B);
    }
    private static void selectionSort(Comparable[] a, int lo, int hi){
        for ( int i =lo; i< hi; i++){
            int min = i;
            for(int j = i + 1; j<hi; j++){
                if(less(a[j], a[min]))
                    min = j;
            }
            swap(a, i, min);
        }
    }
    private static void merge(Comparable[] a, int least, int middle, int highest){
        int i = least;
        int j = middle;
        Comparable[] tempArray = new Comparable[a.length];
        for(int k = least; k <highest; k++){
            tempArray[k] = a[k];
        }
        for(int k = least; k < highest; k++){
            if(i>= middle)
                a[k] = tempArray[j++];
            else if(j>= highest)
                a[k] = tempArray[i++];
            else if (less (tempArray[i] , tempArray[j]))
                a[k] = tempArray[i++];
            else
                a[k] = tempArray[j++];
        }
    }
    public static void printArray(Comparable[] a, int M){
        int section =1;
        for( int i =0; i<a.length; i++){
            if(i % M ==0){
                System.out.print("\nSection " + section + ": \t");
                section++;
            }
            System.out.print(a[i]+ "\t");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;
        return true;
    }
    private static void swap(Comparable[] a, int i, int j) {
        Comparable x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    private static boolean less(Comparable c, Comparable d) {

        return c.compareTo(d) < 0;

    }

}
