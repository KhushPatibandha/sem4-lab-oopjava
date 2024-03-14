import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

        people.add(new Person("Khush", "1234"));
        employees.add(new Employee("Aditya", "8989", "E1"));
        people.add(new Person("Harsh", "1356"));
        employees.add(new Employee("Arya", "9042", "E2"));
        
        System.out.println("What do you want to find the person by? name, adhar number or employee id ?");
        System.out.println("Enter 1 for name, 2 for adhar number and 3 for employee id");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                System.out.println("Enter the name: ");
                String name = sc.next();
                for(Person person : people) {
                    if(person.getObjectByName(name) != null) {
                        person.getPerson();
                    }
                }
                for(Employee employee : employees) {
                    if(employee.getObjectByName(name) != null) {
                        employee.getEmployee();
                    }
                }
                break;

            case 2:
                System.out.println("Enter the adhar number: ");
                String adhar = sc.next();
                for(Person person : people) {
                    if(person.getObjectByAdharOrEmpId(adhar) != null) {
                        person.getPerson();
                    }
                }
                break;

            case 3:
                System.out.println("Enter the employee id: ");
                String employeeId = sc.next();
                for(Employee employee : employees) {
                    if(employee.getObjectByAdharOrEmpId(employeeId) != null) {
                        employee.getEmployee();
                    }
                }
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

        sc.close();
    }
}

interface PersonInterface<T> {
    public T getObjectByName(String name);
    public T getObjectByAdharOrEmpId(String id);
}

class Person implements PersonInterface<Person> {
    private String name;
    private String adhar;

    public Person(String name, String adhar) {
        this.name = name;
        this.adhar = adhar;
    }

    public String getName() {
        return name;
    }
    public String getAdhar() {
        return adhar;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }

    public void getPerson() {
        System.out.println("Name: " + this.name + " Adhar: " + this.adhar);
    }

    @Override
    public Person getObjectByName(String name) {
        if(this.name.equals(name)) {
            return this;
        }
        return null;
    }

    @Override
    public Person getObjectByAdharOrEmpId(String id) {
        if(this.adhar.equals(id)) {
            return this;
        }
        return null;
    }
}

class Employee extends Person {
    
    private String employeeId;
    
    public Employee(String name, String adhar, String employeeId) {
        super(name, adhar);
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public void getEmployee() {
        System.out.println("Name: " + this.getName() + " Adhar: " + this.getAdhar() + " Employee ID: " + this.employeeId );
    }

    @Override
    public Employee getObjectByAdharOrEmpId(String id) {
        if(this.employeeId.equals(id)) {
            return this;
        }
        return null;
    }
}
