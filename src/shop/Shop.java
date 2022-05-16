/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shop;
import java.util.*;
import java.sql.*;
/**
 *
 * @author ASUS
 */
class Employee
{
 String name;
 int id;
 void set(int a,String b)
 {
  name = b;
  id = a;
 }
 void viewAllItems()
 {
  Connection cn = null;
  try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","maarlesh");
   System.out.println("Connected with the database:");
 }
 catch(ClassNotFoundException c)
 {
    System.out.println(c);
 }
 catch(SQLException s)
 {
    System.out.println(s);
 }
 try
 {
    Statement st = null;
    st = cn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM item;");
    //rs.next();
    while(rs.next())
    {
      System.out.println("-----------------------------------------------------");
      System.out.println("        NAME:"+rs.getString("name"));
      System.out.println("       PRICE:"+rs.getFloat("price"));
      System.out.println("          id:"+rs.getInt("id"));
      System.out.println("-----------------------------------------------------");
    }
  }
  catch(SQLException e)
  {
   System.out.println(e);  
  }
 }
 void displayEmployeeDetails()
 {
 Connection cn = null;
  try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","maarlesh");
   System.out.println("Connected with the database:");
 }
 catch(ClassNotFoundException c)
 {
    System.out.println(c);
 }
 catch(SQLException s)
 {
    System.out.println(s);
 }
 try
 {
    Statement st = null;
    st = cn.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM employee where id = "+this.id);
    //rs.next();
    while(rs.next())
    {
      System.out.println("-----------------------------------------------------");
      System.out.println("        NAME:"+rs.getString("name"));
      //System.out.println("       PRICE:"+rs.getFloat("price"));
      System.out.println("          id:"+rs.getInt("id"));
      System.out.println("-----------------------------------------------------");
    }
  }
  catch(SQLException e)
  {
   System.out.println(e);  
  }
 }
}
class Item
{
 int id;
 String name;
 float price;
 Item(int a,String b,float c)
 {
  id=a;
  name=b;
  price =c;
 }
 void addItem()
 {
  Connection cn = null;
  try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","maarlesh");
   System.out.println("Connected with the database:");
 }
 catch(ClassNotFoundException c)
 {
    System.out.println(c);
 }
 catch(SQLException s)
 {
    System.out.println(s);
 }
 try
 {
    Statement st = null;
    st = cn.createStatement();
    System.out.println("insert into item(name,price,id) values('"+this.name+"',"+this.price+","+this.id+");");
    st.executeUpdate("insert into item(name,price,id) values('"+name+"',"+price+","+id+")");
  }
  catch(SQLException e)
  {
   System.out.println(e);  
  }
 }
 void deleteItem()
 {
  Connection cn = null;
  try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","maarlesh");
   System.out.println("Connected with the database:");
 }
 catch(ClassNotFoundException c)
 {
    System.out.println(c);
 }
 catch(SQLException s)
 {
    System.out.println(s);
 }
 try
 {
    Statement st = null;
    st = cn.createStatement();
    System.out.println("delete from item where id ="+id);
    st.executeUpdate("delete from item where id ="+id);
  }
  catch(SQLException e)
  {
   System.out.println(e);  
  }
 }
 void modifyItem()
 {
  Connection cn = null;
  try
 {
   Class.forName("com.mysql.cj.jdbc.Driver");
   cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop","root","maarlesh");
   System.out.println("Connected with the database:");
 }
 catch(ClassNotFoundException c)
 {
    System.out.println(c);
 }
 catch(SQLException s)
 {
    System.out.println(s);
 }
 try
 {
    Statement st = null;
    st = cn.createStatement();
    System.out.println("update item set name ='"+name+"',price ="+price+"where id="+id);
    st.executeUpdate("update item set name ='"+name+"',price ="+price+"where id="+id);
  }
  catch(SQLException e)
  {
   System.out.println(e);  
  }
 }
}
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    Employee e = new Employee();
    e.set(101,"maarlesh");
    e.viewAllItems();
    e.displayEmployeeDetails();
    Item i = new Item(1008,"fruitee",43);
    i.addItem();
   // i.deleteItem();
    Item j = new Item(1008,"murukku",16);
    j.modifyItem();
}

}
