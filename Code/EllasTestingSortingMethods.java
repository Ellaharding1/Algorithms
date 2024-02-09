
import java.util.Arrays;
import java.util.Vector;

public interface EllasTestingSortingMethods {
    //Selection Sort
    public static <T extends Comparable <? super T>>long selectionSort (T [] list){

        long start_Time = System.nanoTime();
        for(int i=0; i<list.length-1;i++){
            //Find the smallest element in the unsorted part of the array
            int smallest =i;
            for(int j=i+1;j<list.length;j++){
                if(list[j].compareTo(list[smallest])<0){
                    smallest=j;
                }
            }
            //switching the smallest element with the first element of the unsorted array
            T temp=list[i];
            list[i]=list[smallest];
            list[smallest]=temp;
        }
        long end_Time = System.nanoTime();
        return (end_Time-start_Time);
    }
    public static < T extends Comparable <? super T >> long bubbleSort(T[] list){
        long start_Time = System.nanoTime();

        for(int i=1;i<list.length;i++){
            for(int j=0;j<list.length-i;j++){
                if(list[j].compareTo(list[j+1])>0){
                    //switching list[j] and list [j+1]
                    T temp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
        long end_Time = System.nanoTime();
        return (end_Time-start_Time);
    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] list){
        long start_Time = System.nanoTime();
        for(int i=1;i<list.length;i++){
            T key=list[i];
            int j = i-1;
            while(j>=0 && list[j].compareTo(key)>0){
                //Shifts values greater than key to the right
                list[j+1]=list[j];
                j--;
            }
            //Place key in its correct position
            list[j+1]=key;
        }
        long end_Time = System.nanoTime();
        return (end_Time-start_Time);
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] S){
        long start_Time = System.nanoTime();
        int n=S.length;
        //if the array only has 2 values it will already be sorted
        if(n<2){return 0;}
        //divide
        int mid=n/2;
        T[] S1 = Arrays.copyOfRange(S,0,mid);
        T[] S2 = Arrays.copyOfRange(S,mid,n);
        //recursive call on the left and right halves
        mergeSort(S1);
        mergeSort(S2); //coding with jon
        //merge with original array
        int i=0,j=0;
        while(i+j<S.length){
            //Merge two sorted haves back into the original array
            if(j==S2.length || (i <S1.length && S1[i].compareTo(S2[j])<0)){
                S[i+j]=S1[i++];
            }
            else {
                S[i+j]=S2[j++];
            }
        }
        long end_Time = System.nanoTime();
        return (end_Time-start_Time);
    }

    public static <T extends Comparable<? super T>> long quickSort(T[] s, int a, int b) {
        long startTime = System.nanoTime();
        if (a >= b) {
            //if the array only has 2 values it will already be sorted
            return 0;
        }

        T pivot = s[b]; // making the pivot the last element in the array
        int left = a;
        int right = b - 1;
        while (left < right) {
            while (left < right && s[left].compareTo(pivot) < 0) {
                left++;
            }
            while (left < right && s[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left < right) {
                // swap the s[right] and s[left]
                T temp = s[left];
                s[left] = s[right];
                s[right] = temp;
                left++;
                right--;
            }
        }
        // swap the s[right] and s[left], putting pivot into its final space
        T temp = s[left];
        s[left] = s[b];
        s[b] = temp;
        //Recursive calls on the left and right
        quickSort(s, a, left - 1);
        quickSort(s, left + 1, b);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long bucketSort(Integer[] a, int first, int last, int maxDigits){
        long start_Time = System.nanoTime();
        Vector<Integer>[] bucket = new Vector[10];
        //instantiate each bucket;
        for (int i = 0; i < 10; i++)
            bucket[i] = new Vector<>();
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing a[index] at end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(a[index], i);
                bucket[digit].add(a[index]);
            }
            //placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    a[index++] = bucket[m].get(n);
                }
            }
        }
        long end_Time = System.nanoTime();
        return (end_Time-start_Time);
    }
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }
}