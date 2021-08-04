/*
Write a method max() that takes a reference to the first node in a linked list as argument
and returns the value of the maximum key in the list. Assume that all keys are positive integers,
and return 0 if the list is empty.
 */



import java.util.Iterator;
import java.util.LinkedList;
public class A1Q3
{
    public static void main(String[] args)
    {

        //Create a LinkedList class object of type integer
        LinkedList<Integer>list=new LinkedList<>();

        //inserting values in the linkedlist
        list.add(1);
        list.add(5);
        list.add(41);
        list.add(20);
        list.add(3);
        list.add(7);
        list.add(6);
        list.add(31);
        list.add(21);

        System.out.print("Elements in the list are :");


        for (Integer number : list)
        {
            System.out.print(number+" ");
        }

        int maximumValue=maximum(list);//using the maxValue function to determine the maximum number

        System.out.println();

        System.out.println("\nMaximum in the list : "+maximumValue);//output the max value

    }



    private static int maximum(LinkedList<Integer> list)
    {
        //Assume that that the first element is max
        int maximum=list.get(0);
        //Creating an iterator
        Iterator<Integer> iterator=list.iterator();


        //iterate over every position  to get  the max element
        while(iterator.hasNext())
        {

            int tempMaximum=iterator.next();
            if(tempMaximum>maximum)
                maximum=tempMaximum;
        }

        return maximum;
    }

}