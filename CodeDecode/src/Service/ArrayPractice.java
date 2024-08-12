package Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ArrayPractice {
    static List<Integer> getCommonElements(int [] arr1, int [] arr2){
        List<Integer> collect = Arrays.stream(arr1).filter(n -> Arrays.stream(arr2).anyMatch(n2 -> n2 == n)).boxed().collect(Collectors.toList());
        return collect;

    }
    static int getSecondSmallestElement(int[] arr){
        int i = Arrays.stream(arr).sorted().skip(1).findFirst().orElseThrow(() -> new RuntimeException());
        return i;
    }
    static int getMaxString(String [] str){
       int max = Arrays.stream(str).mapToInt(n->n.length()).max().orElse(0);
        return max;
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,10};
        int [] arr1 = {4,5,6,10,13};
        System.out.println(getCommonElements(arr, arr1));
        //System.out.println(getSecondSmallestElement(arr));

        String [] str = {"apple","Banana","Avacado","jaishreemahakaal"};
        System.out.println(getMaxString(str));
    }
}
