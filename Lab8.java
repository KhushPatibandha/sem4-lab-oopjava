import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Person> people = new ArrayList<>();
            List<Employee> employees = new ArrayList<>();

            Person p1 = new Person("khush", 1234);
            people.add(p1);

            Person p2 = new Person("rahul", 5678);
            people.add(p2);

            Employee e1 = new Employee("harsh", 1212, 1);
            employees.add(e1);

            Employee e2 = new Employee("sahil", 3434, 2);
            employees.add(e2);
            
            
            System.out.println("What do you want to find the person by? name, adhar number or employee id ?");
            System.out.println("Enter 1 for name, 2 for adhar number and 3 for employee id");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Enter the name: ");
                    String name = sc.next().toLowerCase();
                    for(Person person : people) {
                        if(person.search(name) != null) {
                            person.getPerson();
                            return;
                        }
                    }
                    for(Employee employee : employees) {
                        if(employee.search(name) != null) {
                            employee.getEmployee();
                            return;
                        }
                    }
                    System.out.println("No person found with the given name");
                    break;

                case 2:
                    System.out.println("Enter the adhar number: ");
                    int adhar = sc.nextInt();
                    for(Person person : people) {
                        if(person.search(adhar) != null) {
                            person.getPerson();
                            return;
                        }
                    }
                    System.out.println("No person found with the given adhar number");
                    break;

                case 3:
                    System.out.println("Enter the employee id: ");
                    int employeeId = sc.nextInt();
                    for(Employee employee : employees) {
                        if(employee.search(employeeId) != null) {
                            employee.getEmployee();
                            return;
                        }
                    }
                    System.out.println("No employee found with the given employee id");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            sc.close();
        }
    }
}

interface PersonInterface {
    public Person search(String name);
}

class Person implements PersonInterface {
    private String name;
    private int adhar;

    public Person(String name, int adhar) {
        this.name = name;
        this.adhar = adhar;
    }

    public String getName() {
        return name;
    }
    public int getAdhar() {
        return adhar;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAdhar(int adhar) {
        this.adhar = adhar;
    }

    public void getPerson() {
        System.out.println("Name: " + this.name + " Adhar: " + this.adhar);
    }

    @Override
    public Person search(String name) {
        if(this.name.equals(name)) {
            return this;
        }
        return null;
    }
    
    public Person search(int adhar) {
        if(this.adhar == adhar) {
            return this;
        }
        return null;
    }
}

class Employee extends Person {
    
    private int employeeId;
    
    public Employee(String name, int adhar, int employeeId) {
        super(name, adhar);
        this.employeeId = employeeId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public void getEmployee() {
        System.out.println("Name: " + this.getName() + " Adhar: " + this.getAdhar() + " Employee ID: " + this.employeeId );
    }

    @Override
    public Person search(String name) {
        if(this.getName().equals(name)) {
            return this;
        }
        return null;
    }

    public Person search(int employeeId) {
        if(this.employeeId == employeeId) {
            return this;
        }
        return null;
    }
}
