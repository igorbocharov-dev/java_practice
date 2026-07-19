package StreamAPI;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Создать класс сотрудника с именем, возрастом, зп и фирмой(строка).
 */
public class Employee {

    private String name;

    private int age;

    private BigDecimal salary;

    private String company;

    private final EmployeeValidatorImpl employeeValidator = new EmployeeValidatorImpl();

    public Employee(String name, int age, BigDecimal salary, String company) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.company = company;
        employeeValidator.validate(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    /**
     * Реализовать метод который принимает список сотрудников
     * и отдает среднюю зп по каждой фирме (вернуть Map<String, BigDecimal>)
     */

    public Map<String, BigDecimal> averageSalaryByCompany(List<Employee> employees){
        return employees.stream().collect
                (Collectors.groupingBy(Employee::getCompany,
                        Collectors.mapping(Employee::getSalary,
                                Collectors.teeing(
                                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add),
                                        Collectors.counting(),
                                        (sum, count) -> sum.divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP)
                                ))));
    }

    /**
     * Используем класс сотрудника, метод принимает список сотрудников, вернуть первого сотрудника из фирмы X.
     */

    public Employee getFirstByCompany(List<Employee> employees, String company){
        return employees.stream().filter(employee -> employee.getCompany().equals(company)).findFirst().orElseThrow();
    }

}
