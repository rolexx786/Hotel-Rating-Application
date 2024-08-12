package Service;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ArrayPractice3 {
    public static int secondMaxElement(int[] arr) throws Exception {
        int i = Arrays.stream(arr).sorted().skip(1).findFirst().orElseThrow(() -> new Exception());
        return i;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {23,444,35354,5656563,11,22,3344,4545,5757,87765,342,231,23,444};
        System.out.println(secondMaxElement(arr));

        //get common element in two arrays

        int[] arr1 = {1,2,3,4,5,6};
        int[] arr2 = {3,4,5,6,7,8,9};
        System.out.println(getCommonElements(arr1,arr2));

    }
    static List<Integer> getCommonElements(int[] arr1, int[] arr2){
        List<Integer> collect = Arrays.stream(arr1).filter(n -> Arrays.stream(arr2).anyMatch(n2 -> n == n2)).boxed().collect(Collectors.toList());
        return collect;

    }

}
