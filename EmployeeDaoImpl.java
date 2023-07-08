package empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDaoImpl implements EmployeeDaoInt{
    Connection con;

    @Override
    public void createEmployee(Employee emp) {
       con =DBConnection.createDBConnetion();
       String query="insert into emp.employee values(?,?,?,?)";
       try{
           PreparedStatement pstm=con.prepareStatement(query);
           pstm.setInt(1,emp.getId());
           pstm.setString(2,emp.getName());
           pstm.setDouble(3,emp.getSalary());
           pstm.setInt(4,emp.getAge());
          int cnt= pstm.executeUpdate();
          if(cnt!=0)
              System.out.println("Employee Inserted Successfully !!!");


       }catch (Exception ex){
           ex.printStackTrace();
       }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnetion();
        String query="select * from employee";
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnId(int id1) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where empid="+id1;
        try{
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while (result.next()){
            	System.out.println("Employee Details :");
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void showEmployeeBasedOnName(String name1) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where empname="+ name1;
        try{
        	
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void showEmployeeBasedOnSalary(int sal) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where sal="+ sal;
        try{
        	
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
    public void showEmployeeBasedOnAge(int age1) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where age="+ age1;
        try{
        	
            Statement stmt=con.createStatement();
           ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));

            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void updateEmployee(int id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update employee set empname=? where empid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnetion();
        String query="delete from employee where empid=?";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Employee Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}
