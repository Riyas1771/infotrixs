package empapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        int id;
        EmployeeDaoInt dao=new EmployeeDaoImpl();
        System.out.println("Hello!");

        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("1. Add Employee\n" +
                    "2. Show All Employee\n" +
                    "3. Show Employee based on id,name,Salary,age\n" +
                    "4. Update the employee\n" +
                    "5. Delete the employee\n");

            System.out.println("Enter Choice: ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    Employee emp=new Employee();
                    System.out.println("Enter ID : ");
                     id=sc.nextInt();
                    System.out.println("Enter name ");
                     name=sc.next();
                    System.out.println("Enter Salary ");
                    double salary=sc.nextDouble();
                    System.out.println("Enter age");
                    int age=sc.nextInt();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setAge(age);
                    dao.createEmployee(emp);
                    break;
                case 2:
                    dao.showAllEmployee();
                    break;
                case 3:
                    System.out.println("Show details based on?\n "
                    		+"1.id 2.name 3.Salary 4.age");
                    int empOption=sc.nextInt();
                    if(empOption==1) {
                    	System.out.println("Enter id:");
                    	int id1=sc.nextInt();
                    dao.showEmployeeBasedOnId(id1);
                    } 
                    else if(empOption==2){
                    	System.out.println("Enter the name:");
                    	System.out.println();
                    	String name1=sc.next();
                    	dao.showEmployeeBasedOnName(name1);}
                    else if(empOption==3) {
                    	System.out.println("Enter the Salary");
                    	System.out.println();
                    	int sal=sc.nextInt();
                    	dao.showEmployeeBasedOnSalary(sal);
                    }
                    else if(empOption==4) {
                    	System.out.println("Enter the age");
                    	System.out.println();
                    	int age1=sc.nextInt();
                    	dao.showEmployeeBasedOnAge(age1);
                    }
                    break;
                case 4:
                    System.out.println("Enter id to update the details");
                    int empid1=sc.nextInt();
                    System.out.println("Enter the new name");
                     name=sc.next();
                    dao.updateEmployee(empid1,name);
                    break;
                case 5:
                    System.out.println("Enter the id to delete");
                    id=sc.nextInt();
                    dao.deleteEmployee(id);
                    break;

                case 6:
                    System.out.println("Thank you for using our Application !!!");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !");
                    break;


            }

        }while (true);

    }
}
