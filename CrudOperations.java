package example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
//Main class
public class CrudOperations {
	public static void main(String[] args) throws Exception {
		Scanner s=new Scanner(System.in);
		boolean loop=true;
		System.out.print(loop);
		//Display options
		while(loop) {
		System.out.println("Enter your choice");
		System.out.println("1.Insert");
		System.out.println("2.View");
		System.out.println("3.Update");
		System.out.println("4.Delete");
		System.out.println("5.Exit");
		int choice=s.nextInt();
//Get choosing operation from user
      switch(choice) {
      case 1:
    	  insert(s);
    	  break;
      case 2:
    	  display();
    	  break;
      case 3:
    	  update(s);
    	  break;
      case 4:
    	  delete(s);
    	  break;
      case 5:
    	  loop=false;
    	  break;
      default:
    	  System.out.println("Invalid choice");
      }
      System.out.println("<----------------process Complete----------------->");
      }
		System.out.println("<----------------Exit----------------->");
		s.close();
	}
 //<-------------------------insert values into database----------------->
		public static void insert (Scanner s) throws Exception{
//		Scanner s=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/studentdetails";
		String username="root";
		String password= "Kathir";
		 Connection con=DriverManager.getConnection(url,username,password);
		int id;
		System.out.println("Enter Id:");
		id=s.nextInt();
		String name;
		System.out.println("Enter Name:");
		name=s.next();
		String dept;
		System.out.println("Enter department:");
		dept=s.next();
		String addrs;
		System.out.println("Enter Address:");
		addrs=s.next();
		//insert values into database
		String query="insert into student values("+id +",'" +name+  "','"+dept+"','" +addrs+"');";
		 Statement st=con.createStatement();
		 int rows=st.executeUpdate(query);
         System.out.println(rows+"row is inserted.");
	}  
		
		//<--------------------Display--------------------->
		
		public static void display() throws Exception{
		String url="jdbc:mysql://localhost:3306/studentdetails";
		String username="root";
		String password= "Kathir";
		Connection con=DriverManager.getConnection(url,username,password);
		
		String query="select *from student";
		 Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		//display values fetch from database
		   while  (rs.next()) {
		       System.out.println("Id :"+ rs.getInt(1));
             System.out.println("name :"+ rs.getString(2));
			 System.out.println("department :"+ rs.getString(3));
			 System.out.println("address :"+ rs.getString(4));
		}
		 
	con.close();
	}
		
		//<-----------------------update---------------------> 
		public static void update(Scanner s) throws Exception{
		String url="jdbc:mysql://localhost:3306/studentdetails";
		String username="root";
		String password= "Kathir";
		Connection con=DriverManager.getConnection(url,username,password);
		
		System.out.println("Enter id to update:");
		int id=s.nextInt();
		System.out.println("Enter sudent name:");
		String name=s.next();
		System.out.println("Enter Department:");
		String depmt=s.next();
		System.out.println("Enter Adress:");
		String addrs=s.next();
		//update values into database
		String query = "update student set st_name='" + name + "', dept='" + depmt + "', address='" + addrs + "' where stu_id=" + id;
				 
		Statement st=con.createStatement();
		int rows=st.executeUpdate(query);
		System.out.println(rows+"Row updated successfully");
	    con.close();
	} 
		//<------------------Delete--------------->
		
		public static void delete(Scanner s) throws Exception{
		String url="jdbc:mysql://localhost:3306/studentdetails";
		String username="root";
		String password= "Kathir";
		Connection con=DriverManager.getConnection(url,username,password);
	
		System.out.println("Enter Id to delete:");
		int id=s.nextInt();
		
		String query="delete from student where stu_id="+id;		 
		Statement st=con.createStatement();
		int rows=st.executeUpdate(query);
		System.out.println(rows+"Row deleted successfully");
	con.close();
	} 
		
	}

