/*
Write a recursive Java method that rearranges an array of integer values so that all the even
values appear before all the odd values. Test your program.

 */


public class A2Q1 {

    static int[] Arr  = { 1, 2, 3, 4, 5, 6,7,9,10};
    static int l;

    public static void main(String[] args) {


        System.out.print("Unsorted Array: ");
        for (int i = 0; i < Arr.length; i++)
            System.out.print(Arr[i] +" ");
        l = Arr.length;
        arrange(Arr, l);

        System.out.println("");

        System.out.print("Sorted Array: ");
        for (int i = 0; i < Arr.length; i++)
            System.out.print(Arr[i] +" ");
    }

    public static void arrange(int []Array,int l){
        if (l==0)
            return ;
        if(Array[l-1]%2==0) {
            for(int i=0;i<l-1;i++) {
                if(Array[i]%2!=0) {
                    //swap the elements
                    int temp = Array[i];
                    Array[i]= Array[l-1];
                    Array[l-1] = temp;



                    //recursive method
                    arrange(Array,l-1);

                }
            }
        }
        else
            //recursive method
           arrange(Array,l-1);


    }
}