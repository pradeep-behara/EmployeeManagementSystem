package task;
import java.io.*;
import java.util.*;

public class EmployeeManagementSystem {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Employee Management System Menu");
            System.out.println("1. Add an employee");
            System.out.println("2. Display all");
            System.out.println("3. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                	 sc = new Scanner(System.in);
                     System.out.print("Enter Empolyee ID: ");
                     String id = sc.nextLine();
                     
                     System.out.print("Enter Employee Name: ");
                     String name = sc.nextLine();

                     System.out.print("Enter Employee Age: ");
                     String age = sc.nextLine();

                     System.out.print("Enter Employee Salary: ");
                     double salary = sc.nextDouble();

                     try (FileWriter writer = new FileWriter("employees.txt", true)) {
                         String data = id + "," + name + "," + age + "," + salary + "\n";
                         writer.write(data);
                     } catch (IOException e) {
                         System.out.println("An error occurred while writing to the file: " + e.getMessage());
                     }
                    break;
                case 2:
                	try (Scanner fileScanner = new Scanner(new File("employees.txt"))) {
                        System.out.println("------------Report------------");
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            String[] parts = line.split(",");
                            System.out.println(parts[0] + " " + parts[1] + " " + parts[2] + " " + parts[3]);
                        }
                        System.out.println("------------End of Report------------");
                    } 
                	catch (IOException e) {
                        System.out.println("An error occurred while reading from the file: " + e.getMessage());
                    } 
                    break;
                case 3:
                    System.out.println("Exiting the System");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        sc.close();
    }
}
