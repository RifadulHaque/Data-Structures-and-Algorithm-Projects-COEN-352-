/*
Show, in the style of the trace given with the code, how the entropy-optimal sort first
partitions the array B A B A B A B A C A D A B R A.


 */


class A2Q4{

    public static void main(String[] args)
    {
        String arr[]= {"B","A","B","A","B","A","B","A","C","A","D","A","B","R","A"};
        quickSort(arr);
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }



    private static void swap(String[] array, int first, int second) {
        String swi = array[first];
        array[first] = array[second];
        array[second] = swi;
    }

    private static void quickSortByPartition(String[] array, int low, int high) {
        if (high <= low)
            return;

        int lowerIndex = low;
        int higherIndex = high;
        int initial = low;
        String element = array[low];


        while (initial <= higherIndex) {


            int value= array[initial].compareTo(element);
            if (value<0)
                swap(array, lowerIndex++, initial++);
            else if (value>0)
                swap(array, initial, higherIndex--);
            else
                initial++;
        }

        quickSortByPartition(array, low, lowerIndex - 1);
        quickSortByPartition(array, higherIndex + 1, high);
    }

    public static void quickSort(String[] arr) {
        quickSortByPartition(arr, 0, arr.length - 1);
    }


}