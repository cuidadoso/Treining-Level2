package ex2;

import java.sql.*;
import java.util.*;

public class Customers {
  public List getCustomers(int tid){
  
  Connection con=null;
  List customers=new LinkedList();
  
    try{    
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       con=DriverManager.getConnection
           ("jdbc:sqlserver://10.5.1.50:1433", "sa", "1234");
       con.setCatalog("AdventureWorks");
       
       PreparedStatement st=con.prepareStatement
               ("Select * From Sales.Customer where territoryid=?");
       st.setInt(1, tid);
       ResultSet rs=st.executeQuery();
       
       while(rs.next())
          customers.add(""+rs.getString(1)+" "+rs.getString(2)+
                  " "+rs.getString(3)+" "+rs.getString(4)); 
       rs.close();
    }
    catch(SQLException ex) { ex.printStackTrace(); }
    catch(Exception ex)    { ex.printStackTrace(); }
    finally {
            try {
                if (con!=null && !con.isClosed()) con.close();
            } catch (SQLException ex) { ex.printStackTrace(); }
    }

    return customers;
  }
}
