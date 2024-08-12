package Entity;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class practice {

    public static void main(String[] args) {
        Finterface total = (a,b)->{
            return a*b;
        };
       // System.out.println(total.multiply(5,6));

        String str = "welcome to code decode and code decode welcome you";

        List<String> list = Arrays.asList(str.split(" "));
        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(collect);

        System.out.println(isPrime(100001));



    }
    public static boolean isPrime(Integer num){
        return num>1&& IntStream.range(2,num).noneMatch(n->num%n==0);
    }

}
