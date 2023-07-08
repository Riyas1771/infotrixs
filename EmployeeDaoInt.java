package empapp;

public interface EmployeeDaoInt {

    //create employee
    public void createEmployee(Employee emp);
    //show all employee
    public void showAllEmployee();
    //show employee based on id
    public void showEmployeeBasedOnId(int id1);
    public void showEmployeeBasedOnName(String name1);
    public void showEmployeeBasedOnSalary(int sal);
    public void showEmployeeBasedOnAge(int age1);
    
    //update employee
    public void updateEmployee(int id,String name);
    //delete employee
    public void deleteEmployee(int id);
}
