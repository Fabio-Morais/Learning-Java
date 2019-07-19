package com.timbuchalka;

import java.util.Arrays;
import java.util.Scanner;

class QuickSort {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] >= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public void sort(int arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
public class Array_chall {
    public  Scanner scanner = new Scanner(System.in);

    public  int[] getIntegers (int number){
        int[] array = new int[number];
        System.out.println("Insert the values: ");
        for(int i=0; i< array.length; i++){
            array[i]=scanner.nextInt();
        }
        return array;
    }

    public  void printArray(int[] array){
        System.out.println("array: " + Arrays.toString(array));
    }
    public  void sortIntegers (int []array){
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array, 0, array.length-1);
    }
    /*******************************/
    public int[] readIntegers(int number){
        int[] array= new int[number];
        System.out.println("Enter "+number + " numbers");
        for(int i=0; i < array.length; i++ ){
            if(scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
                scanner.nextLine();
            }
            else {
                System.out.println("repeat");
                scanner.nextLine();
                i--;
            }
        }
        return array;
    }

    public int findMin(int[] array){
        int min=array[0];
        /*ou
         * int min = Integer.MAX_VALUE;
         * */
        for(int i=0; i<array.length; i++){
            if(array[i]<min)
                min=array[i];
        }
        return min;
    }



    /*******************************/

    public void reverse(int[] array) {
        int halfIndex = array.length/2;
        int maxIndex = array.length-1;
        for(int i=0; i<halfIndex; i++){
            int aux= array[i];
            array[i]=array[maxIndex];
            array[maxIndex--]= aux;
        }
    }
}
