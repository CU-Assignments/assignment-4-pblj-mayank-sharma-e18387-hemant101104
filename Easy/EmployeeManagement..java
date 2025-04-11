import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display Employee Info
    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Salary: " + salary);
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            switch (choice) {
                case 1 -> addEmployee();
                case 2 -> updateEmployee();
                case 3 -> removeEmployee();
                case 4 -> searchEmployee();
                case 5 -> displayAllEmployees();
                case 6 -> System.out.println("Exiting... 👋");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();

        employeeList.add(new Employee(id, name, salary));
        System.out.println("✅ Employee added successfully.");
    }

    private static void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                emp.setName(scanner.nextLine());

                System.out.print("Enter new salary: ");
                emp.setSalary(scanner.nextDouble());

                System.out.println("✅ Employee updated successfully.");
                return;
            }
        }
        System.out.println("❌ Employee not found.");
    }

    private static void removeEmployee() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(i);
                System.out.println("✅ Employee removed successfully.");
                return;
            }
        }
        System.out.println("❌ Employee not found.");
    }

    private static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int id = scanner.nextInt();

        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.println("✅ Employee found:");
                emp.display();
                return;
            }
        }
        System.out.println("❌ Employee not found.");
    }

    private static void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("⚠️ No employees to display.");
        } else {
            System.out.println("📋 Employee List:");
            for (Employee emp : employeeList) {
                emp.display();
            }
        }
    }
}
