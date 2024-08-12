package Service;

import Entity.Emp;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayPractice2 {
    public static void main(String[] args) {

        List<Emp> empList = new ArrayList<>();
        empList.add( new Emp("Harsh", "Rewa", "16000"));
        empList.add( new Emp("Harsh", "Indore", "16000"));
        empList.add( new Emp("Utkarsh", "Rewa", "17000"));
        empList.add( new Emp("Krishna", "Rewa", "15000"));
        empList.add( new Emp("Raj", "Mumbai", "13000"));
        empList.add( new Emp("Aryan", "Rewa", "16000"));
        empList.add( new Emp("Kaushal", "Delhi", "18000"));
        empList.add( new Emp("Puneet", "Delhi", "16000"));
        empList.add( new Emp("Sumit", "Indore", "10000"));

        //Find duplicate Names first approach

        Map<String, Long> collect = empList.stream().map(n -> n.getName()).collect(Collectors.groupingBy(Function.identity(),TreeMap::new, Collectors.counting()));
        List<String> collect3 = collect.entrySet().stream().filter(e -> e.getValue() > 1).map(n -> n.getKey()).collect(Collectors.toList());
       // collect3.stream().forEach(System.out::println);
        Map<String, Set<String>> collect5 = empList.stream().map(n -> n.getSalary()).collect(Collectors.groupingBy(Function.identity(), Collectors.toSet()));






        //Second approach using hash set

        List<String> collect1 = empList.stream().map(n -> n.getName()).collect(Collectors.toList());
        HashSet<String> dupli = new HashSet<>();
        List<String> collect2 = collect1.stream().filter(n -> !dupli.add(n)).collect(Collectors.toList());
        //System.out.println(collect2);

        //To get sorted element of particular field

        //In accending:

        List<String> collect4 = empList.stream().map(s -> s.getSalary()).collect(Collectors.toList());
        //collect4.stream().sorted().forEach(System.out::println);

        // in decending order

        collect4.stream().sorted((s1,s2)->s2.compareTo(s1)).collect(Collectors.toList()).forEach(System.out::println);

        //finding second max element in an array





    }
}
