package sort;

import sort.mergesort.MergeSort;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args){
        Integer[] arr = new Integer[]{2,4,6,1,3,5,9,7,8,4,6};

        System.out.println("Before");
        Arrays.stream(arr).forEach((e) -> System.out.print(e+","));

        arr = MergeSort.sort(arr);

        System.out.println("\nAfter");
        Arrays.stream(arr).forEach((e) -> System.out.print(e+","));


    }
}
