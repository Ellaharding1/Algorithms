import java.util.List;
import java.util.Arrays;
import java.util.Collections;



public class mainMethod{
    public static void main(String[] args) {
        myHeader(6,1);
        int sz=50000;
        //Creating and array for integer values
        Integer[] array = new Integer[sz];
        //Creating a backup array for integer values
        Integer[] array_backup = new Integer[sz];
        //filling array with values
        for(int i=0;i<sz;i++){
            array[i]=(int)(Math.random()*81)+13;
        }

        //copying values from array backup array
        System.arraycopy(array,0,array_backup,0,sz);
        List<Integer> list =Arrays.asList(array);

        //Sorting array using Collections method
        long start_Time = System.nanoTime();
        Collections.sort(list);
        long end_Time = System.nanoTime();
        //System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("Collections' Sorting Time: %.2f\n",(double)(end_Time-start_Time)/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+list+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);

        //Sorting array using selectionSort method
        long time = EllasTestingSortingMethods.selectionSort(array);
        //System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("selectionSort' Sorting Time: %.2f\n",(double)time/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+Arrays.toString(array)+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);


        //Sorting array using bubblesort method
        time = EllasTestingSortingMethods.bubbleSort(array);
        //System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("bubbleSort Sorting Time: %.2f\n",(double)time/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+Arrays.toString(array)+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);


        //Sorting array using insertionSort method
        time = EllasTestingSortingMethods.insertionSort(array);
       // System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("insertionSort Sorting Time: %.2f\n",(double)time/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+Arrays.toString(array)+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);


        //Sorting array using mergesort method
        time = EllasTestingSortingMethods.mergeSort(array);
        //System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("mergeSort' Sorting Time: %.2f\n",(double)time/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+Arrays.toString(array)+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);


        //Sorting array using quicksort method
        time = EllasTestingSortingMethods.quickSort(array,0,array.length-1);
        //System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("quickSort Sorting Time: %.2f\n",(double)time/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+Arrays.toString(array)+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);


        //Sorting array using bucketsort method
        time = EllasTestingSortingMethods.bucketSort(array,0,array.length-1,2);
        //System.out.println("The unsorted list"+Arrays.toString(array_backup));
        System.out.printf("bucketSort' Sorting Time: %.2f\n",(double)time/1000000);
        //System.out.println("The sorted list using Collections' sort method: "+Arrays.toString(array)+"\n\n");
        System.arraycopy(array_backup,0,array,0,sz);


        myFooter(6,2);
    }
    //Header
    public static void myHeader ( int n, int a){
        System.out.println("============================================");
        System.out.println("Exercise");
        System.out.println("Prepared By: Ella Harding");
        System.out.println("============================================");
    }
    //Footer

    public static void myFooter ( int a ,int n){
        System.out.println("============================================");
        System.out.println("Completion of Exercise");
        System.out.println("Signing off = Ella Harding");
        System.out.println("============================================");
    }
}
