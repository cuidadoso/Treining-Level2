package ex1;

import java.io.*;
import java.sql.*;
import javax.swing.*;
//
//  create  TABLE  pictures (
//          id      nchar(10)       not null,
//          name    varchar(MAX)    not null,
//          photo   image           not null );
//
public class Main extends JFrame {
    
static Connection conn = null;
    
public static void processIN(String id, String binaryFileName)
                                                throws Exception {
  File file = null;
  InputStream fin = null;
  PreparedStatement ps = null;

  try {
      file = new File (binaryFileName);
      fin  = new FileInputStream(file);
      int len = fin.available();

      ps=conn.prepareStatement
              ("INSERT INTO pictures (id,photo) VALUES (?,?)");
      ps.setString(1, id);
       //ps.setString(2, binaryFileName);
      ps.setBinaryStream(2, fin, len);

      ps.executeUpdate();
    }
    finally {
      if (fin!=null)  fin.close();
      if (ps !=null)  ps.close();
    }
}   
public static InputStream processOUT(String id)    throws SQLException {
    Statement stmt = null;
    ResultSet rs = null;
    InputStream in = null;

    try {
        stmt = conn.createStatement();
        rs = stmt.executeQuery
                ("SELECT * from pictures where id= '" +id+ "'");

        while (rs.next()) {
          System.out.println(rs.getString(1));
          in = rs.getBinaryStream(2);
        }
    }
    finally {
        if (stmt!=null)  stmt.close();
        if (rs != null)    rs.close();
    }
    return in;
}

public Main() throws SQLException {
      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setSize(500, 400);
      
      this.getContentPane().add(new MyComponetn(processOUT("1")));
}
public static void main(String [] args) {
    try {

        Class.forName(
        "com.microsoft.sqlserver.jdbc.SQLServerDriver");

        conn = DriverManager.getConnection("jdbc:sqlserver://localhost;"
              +"database=AdventureWorks;user=DBuser;password=1234");

//      processIN("1","H:\\1.jpg");
//      processOUT("1");
      
        new Main().setVisible(true);

        conn.close();
    }
    catch (Exception e) {
        System.err.println("Exception: "+e.getMessage());
    }
  }
}

