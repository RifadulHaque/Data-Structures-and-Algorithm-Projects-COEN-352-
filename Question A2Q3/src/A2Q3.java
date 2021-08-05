/*
Indirect sort. Develop and implement a version of mergesort that does not re-arrange the
array, but returns an int[] array perm such that perm [i] is the index of the i
th smallest entry in the
array.

 */


public class A2Q3 {
    void merge(int arr[], int l, int m, int r)
    {

        int left = m - l + 1;
        int right = r - m;


        int L[] = new int[left];
        int R[] = new int[right];

        //crating arrays for left side and right side
        for (int i = 0; i < left; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < right; ++j)
            R[j] = arr[m + 1 + j];




        int i = 0, j = 0;


        int k = l;
        while (i < left && j < right) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        //copy the elements left in left side
        while (i < left) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy elements lef in right side
        while (j < right) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int middle = (l + r) / 2;

            sort(arr, l, middle);
            sort(arr, middle + 1, r);


            merge(arr, l, middle, r);
        }
    }

    public static int findIndex(int arr[], int e)
    {

        // if array is Null
        if (arr == null) {
            return -1;
        }


        int n = arr.length;
        int i = 0;


        while (i < n) {

            if (arr[i] == e) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }


    public static void main(String args[])
    {
        int arr[] = { 5, 2, 1, 3, 6, 4 };

        int temp[]={ 5, 2, 1, 3, 6, 4 };





        int n = arr.length;

        int answer[]=new int[n];
        int l= 0;
        int r= n-1;


        System.out.print("Unsorted array: ");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();

       A2Q3 obj =new A2Q3();
       obj.sort(arr,0,n-1);

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();


        for(int i=0; i<n; ++i) {

            answer[i] = findIndex(temp, arr[i]);
        }

        System.out.print("Index of Sorted Array :");

        for (int i = 0; i < n; ++i) {
            System.out.print(answer[i] + " ");

        }
        

    }


}
