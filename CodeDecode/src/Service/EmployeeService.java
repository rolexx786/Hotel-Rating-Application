package Service;

import Entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,15000));
        empList.add(new Employee(2,16000));
        empList.add(new Employee(3,18000));
        empList.add(new Employee(4,13000));
        empList.add(new Employee(5,19000));
        empList.add(new Employee(6,29000));
        empList.add(new Employee(7,15000));
        empList.add(new Employee(8,17000));

        List<Employee> collect = empList.stream().sorted((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())).limit(3).collect(Collectors.toList());
        //System.out.println(collect);

        List<Employee> collect1 = empList.stream().sorted((o1,o2)->(int)(o1.getSalary()-o2.getSalary())).collect(Collectors.toList());
        System.out.println(collect1);

    }

}
