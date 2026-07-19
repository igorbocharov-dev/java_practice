package StreamAPI;

import java.math.BigDecimal;

public final class EmployeeValidatorImpl implements EmployeeValidator {

    @Override
    public void validate(Employee employee) {
        String name = employee.getName();
        int age = employee.getAge();
        String company = employee.getCompany();
        BigDecimal salary = employee.getSalary();

        if(name == null || name.isBlank()) throw new IllegalArgumentException("Имя сотрудника не может быть пустым");
        if(company == null || company.isBlank()) throw new IllegalArgumentException("Название компании не может быть пустым");
        if(!(age > 0)) throw new IllegalArgumentException("Возраст сотрудника должен быть положительным");
        if(salary == null || !(salary.intValue() > 0)) throw new IllegalArgumentException("Заплата сотрудника должна быть положительной");
    }
}
