/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.db;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import sukarna.models.Food;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import sukarna.models.BankTransaction;
import sukarna.models.Employee;
import sukarna.models.Order;
import sukarna.models.OrderList;
import sukarna.models.User;

/**
 *
 * @author shawontafsir
 */
public class DataAccess {
    String dbURL = "jdbc:oracle:thin:@localhost:1521:orcl";
    String username = "hr";
    String password = "hr";

    Connection conn = null;
    public DataAccess()
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(dbURL, username, password);
            if(conn!=null) System.out.println("Connection successfully established between oracle and web.");
            else System.out.println("Could not establish connection");
        }
        catch(Exception e)
        {
            System.out.println("Could not establish connection");
            e.printStackTrace();
        }
    }
    
    public int createAccount(int userid, String username,String email,String mobileno,String password,String address)
    {
        System.out.println("I am in createAccount method of DataAccess class");
        //String insertCommand = "insert into USERACCOUNT values(?,?,?,?,?,?)";
        String insertCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "createAccount(?,?,?,?,?,?);\n" +
                                "END;";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, String.valueOf(userid));
            stmt.setString(2, username);
            stmt.setString(3, email);
            stmt.setString(4, mobileno);
            stmt.setString(5, password);
            stmt.setString(6, address);
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return 0;
        }       
    }
    
    public int createOrder(int orderId,int foodId,int userId,int customerId,int noOfOrder){
        
        System.out.println("I am in createOrder method of DataAccess class");
        DataAccess dbAccess = new DataAccess();
        int a = dbAccess.getMaxEmployeeId();
        Random rn = new Random();
        int employeeId = rn.nextInt(a-1) + 1;
        //String insertCommand = "insert into ordertable values(?,?,?,?,sysdate,?,?)";
        String insertCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "createOrder(?,?,?,?,?,?);\n" +
                                "END;";
        try{
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, String.valueOf(orderId));
            stmt.setString(2, String.valueOf(foodId));
            stmt.setString(3, String.valueOf(userId));
            stmt.setString(4, String.valueOf(customerId));
            stmt.setString(5, String.valueOf(noOfOrder));
            stmt.setString(6, String.valueOf(employeeId));
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        
    }
    
    public int addCustomer(int customerId,String customerName, int tableNo) {
        //String insertCommand = "insert into customerAccount values(?,?,?)";
        String insertCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "addCustomer(?,?,?);\n" +
                                "END;";
        try{
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, String.valueOf(customerId));
            stmt.setString(2, customerName);
            stmt.setString(3, String.valueOf(tableNo));
            
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
 
    public boolean existManager(String email,String password){
        String query = "select * from employee where email = ? and password = ?";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean existUser(String email,String password)
    {
        String query = "select * from useraccount where email = ? and password = ?";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                return true;
            }
            return false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
               
        
    }
    
    public ArrayList<Employee> getEmployeeList(){
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        String selectStatement = "select * from Employee order by employeeId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int employeeId = rs.getInt("employeeId");
                String employeeName = rs.getString("employeeName");
                String email = rs.getString("email");
                String joinDate = rs.getString("joinDate");
                String address = rs.getString("address");
                int salary = rs.getInt("salary");
                String mobileNo = rs.getString("mobileNo");
                int managerId = rs.getInt("managerId");               
                
                Employee employee = new Employee(employeeId,employeeName,email,joinDate,address,salary,mobileNo,managerId);
                employeeList.add(employee); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return employeeList;
    }
    
    public ArrayList<Employee> getPreviousEmployeeList(){
        ArrayList<Employee> previousEmployeeList = new ArrayList<Employee>();
        String selectStatement = "select * from employeeHistory order by employeeId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int employeeId = rs.getInt("employeeId");
                String employeeName = rs.getString("employeeName");
                String email = rs.getString("email");
                String joinDate = rs.getString("joinDate");
                String address = rs.getString("address");
                int salary = rs.getInt("salary");
                String mobileNo = rs.getString("mobileNo");              
                
                Employee employee = new Employee(employeeId,employeeName,email,joinDate,address,salary,mobileNo,1);
                previousEmployeeList.add(employee); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return previousEmployeeList;
    }
    
    
    public ArrayList<Food> getFoodList()
    {
        ArrayList<Food> foodList = new ArrayList<Food>();
        
        String selectStatement = "select * from Food order by foodId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int foodId = rs.getInt("foodId");
                String name = rs.getString("name");
                String category = rs.getString("category");
                int price = rs.getInt("price");
                String description = rs.getString("description");
                
                Food food = new Food(foodId,name,category,price,description);
                foodList.add(food); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return foodList;

    }
    
    public ArrayList<User> getUserInfo(String email){
        String selectStatement = "select * from useraccount where email = ?";
        ArrayList<User> userInfo = new ArrayList<User>();
        try{
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                User user = new User(rs.getInt("userId"),rs.getString("username"),rs.getString("email"),rs.getString("mobileno"),rs.getString("address"));
                userInfo.add(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return userInfo;
    }
    
    public ArrayList<Order> getOrderInfo(int customerId){
        String selectStatement = "select food.foodId,FOOD.NAME,category,orderno,Price,price*orderno from ordertable,food,customeraccount where ordertable.foodId=food.foodId and ORDERTABLE.customerID=customerACCOUNT.customerID and CUSTOMERACCOUNT.customerId=? order by orderTime asc";
        ArrayList<Order> orderInfo = new ArrayList<Order>();
        try{
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, String.valueOf(customerId));
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Order order = new Order(rs.getInt("foodId"),rs.getString("name"),rs.getString("category"),rs.getInt("orderno"),rs.getInt("Price"),rs.getInt("price*orderno"));
                orderInfo.add(order);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return orderInfo;
    }
    
    public ArrayList<Order> getOrderInfo(String email){
        String selectStatement = "select food.foodId,name,category,orderno,Price,price*orderno from ordertable,food,useraccount where ordertable.foodId=food.foodId and ORDERTABLE.USERID=USERACCOUNT.USERID and email = ?  order by orderTime asc";
        ArrayList<Order> orderInfo = new ArrayList<Order>();
        try{
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Order order = new Order(rs.getInt("foodId"),rs.getString("name"),rs.getString("category"),rs.getInt("orderno"),rs.getInt("Price"),rs.getInt("price*orderno"));
                orderInfo.add(order);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return orderInfo;
    }
    
    public ArrayList<OrderList> getOrderList()
    {
        ArrayList<OrderList> orderInfo = new ArrayList<OrderList>();
        
        String selectStatement = "select * from orderTable order by orderId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int orderId = rs.getInt("orderId");
                int foodId = rs.getInt("foodId");
                int userId = rs.getInt("userId");
                int customerId = rs.getInt("customerId");
                String orderTime = rs.getString("orderTime");
                int orderNo = rs.getInt("orderNo");
                int employeeId = rs.getInt("employeeId");
                
                OrderList orderList = new OrderList(orderId,foodId,userId,customerId,orderTime,orderNo,employeeId);
                orderInfo.add(orderList); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return orderInfo;
    }
    
     public ArrayList<OrderList> getOrderHistoryList(String from,String to)
    {
        ArrayList<OrderList> orderHistoryInfo = new ArrayList<OrderList>();
        
        String selectStatement = "select orderId,food.foodId,userId,price*orderNo,orderTime,orderNo,employeeId from orderHistory,food where orderHistory.foodId=food.foodId and orderTime>=? and orderTime<=? order by orderId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, from);
            stmt.setString(2, to);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int orderId = rs.getInt("orderId");
                int foodId = rs.getInt("foodId");
                int userId = rs.getInt("userId");
                int cost = rs.getInt("price*orderNo");
                String orderTime = rs.getString("orderTime");
                int orderNo = rs.getInt("orderNo");
                int employeeId = rs.getInt("employeeId");
                
                OrderList orderList = new OrderList(orderId,foodId,userId,cost,orderTime,orderNo,employeeId);
                orderHistoryInfo.add(orderList); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return orderHistoryInfo;
    }

    public ArrayList<OrderList> getOrderHistoryList()
    {
        ArrayList<OrderList> orderHistoryInfo = new ArrayList<OrderList>();
        
        String selectStatement = "select orderId,food.foodId,userId,price*orderNo,orderTime,orderNo,employeeId from orderHistory,food where orderHistory.foodId=food.foodId order by orderId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int orderId = rs.getInt("orderId");
                int foodId = rs.getInt("foodId");
                int userId = rs.getInt("userId");
                int cost = rs.getInt("price*orderNo");
                String orderTime = rs.getString("orderTime");
                int orderNo = rs.getInt("orderNo");
                int employeeId = rs.getInt("employeeId");
                
                OrderList orderList = new OrderList(orderId,foodId,userId,cost,orderTime,orderNo,employeeId);
                orderHistoryInfo.add(orderList); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return orderHistoryInfo;
    }
    
    public int deleteOrder(int orderId) {
        System.out.println("I am in deleteOrder method of DataAccess class");
        String deleteCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "deleteOrder(?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteCommand);
            stmt.setString(1, String.valueOf(orderId));
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int addEmployee(int employeeId, String employeeName,String email,String address, int salary, String mobileNo, int managerId) {
        //String insertCommand = "insert into employee values(?,?,?,null,sysdate,?,?,?,?)";
        String insertCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "addEmployee(?,?,?,?,?,?,?);\n" +
                                "END;";
        try{
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, String.valueOf(employeeId));
            stmt.setString(2, employeeName);
            stmt.setString(3, email);
            stmt.setString(4, address);
            stmt.setString(5, String.valueOf(salary));
            stmt.setString(6, mobileNo);
            stmt.setString(7, String.valueOf(managerId));
            
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateEmployee(int employeeId, String employeeName, String email, String mobileNo, String address, int salary, int managerId){
        String updateCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "updateEmployee(?,?,?,?,?,?,?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(updateCommand);
            stmt.setString(1, employeeName);
            stmt.setString(2, email);
            stmt.setString(3, mobileNo);
            stmt.setString(4, address);
            stmt.setString(5, String.valueOf(salary));
            stmt.setString(6, String.valueOf(managerId));
            stmt.setString(7, String.valueOf(employeeId));
            
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deleteEmployee(int employeeId) {
        System.out.println("I am in deleteEmployee method of DataAccess class");
        String deleteCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "deleteEmployee(?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteCommand);
            stmt.setString(1, String.valueOf(employeeId));
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    
    public int addFood(int foodId,String name,String category,int price,String description){
        System.out.println("I am in addFood method of DataAccess class");
        String insertCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "addFood(?,?,?,?,?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(insertCommand);
            stmt.setString(1, String.valueOf(foodId));
            stmt.setString(2, name);
            stmt.setString(3, category);
            stmt.setString(4, String.valueOf(price));
            stmt.setString(5, description);
            
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
        
    }
    
    public int updateFood(int foodId, String foodName, String category, int price, String description){
        System.out.println("I am in updateFood method of DataAccess class");
        String updateCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "updateFood(?,?,?,?,?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(updateCommand);
            stmt.setString(1, foodName);
            stmt.setString(2, category);
            stmt.setString(3, String.valueOf(price));
            stmt.setString(4, description);
            stmt.setString(5, String.valueOf(foodId));
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int deleteFood(int foodId){
        System.out.println("I am in deleteFood method of DataAccess class");
        String deleteCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "deleteFood(?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(deleteCommand);
            stmt.setString(1, String.valueOf(foodId));
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int assignOrder(int orderId, int employeeId) {
        String updateCommand = "DECLARE\n" +
                                "BEGIN\n" +
                                "assignOrder(?,?);\n" +
                                "end;";
        try{
            PreparedStatement stmt = conn.prepareStatement(updateCommand);
            stmt.setString(1, String.valueOf(employeeId));
            stmt.setString(2, String.valueOf(orderId));
            int count = stmt.executeUpdate();
            return count;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public ArrayList<OrderList> employeeTasks(int employeeId) {
        ArrayList<OrderList> orderInfo = new ArrayList<OrderList>();
        
        String selectStatement = "select * from orderTable where employeeId=? order by orderId asc";
        
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, String.valueOf(employeeId));
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                int orderId = rs.getInt("orderId");
                int foodId = rs.getInt("foodId");
                int userId = rs.getInt("userId");
                int customerId = rs.getInt("customerId");
                String orderTime = rs.getString("orderTime");
                int orderNo = rs.getInt("orderNo");
                
                OrderList orderList = new OrderList(orderId,foodId,userId,customerId,orderTime,orderNo,employeeId);
                orderInfo.add(orderList); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return orderInfo;
    }
    
    public int getMaxUserId(){
        String selectCommand = "select getmaxUserId from userAccount";
        int maxUser = 0;
        try
        {
            PreparedStatement stmt = conn.prepareStatement(selectCommand);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                maxUser = rs.getInt("getMaxUserId");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return maxUser;
    }
    
    public int getMaxEmployeeId() {
        String selectStatement = "select GETMAXEmployeeID from employee";
        int maxEmployee = 0;
        try
        {
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                maxEmployee = rs.getInt("GETMAXEmployeeID");
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return maxEmployee;
    }
    
    public int getMaxCustomerId() {
        String selectStatement = "select GETMAXCustomerID from customerAccount";
        //String selectStatement = "declare begin getMaxUserId(?);End;";
        int maxCustomer = 0;
        try
        {
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                maxCustomer = rs.getInt("GETMAXCustomerID");
            }
            //PreparedStatement stmt = conn.prepareStatement(selectStatement);
            //stmt.setString(1,maxCustomer);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return maxCustomer;

    }


    public int getMaxOrderId() {
        //String selectStatement = "DECLARE i number; BEGIN GETMAXorderID(i); End;";
        String selectStatement = "select GETMAXOrderID from ordertable";
        int maxOrder=0;
        try
        {
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                maxOrder = rs.getInt("GETMAXOrderID");
            }
            System.out.println(maxOrder);
            
            return maxOrder;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return maxOrder;
    }

    public int getMaxFoodId() {
        int maxFoodId = 0;
        String selectStatement = "select getMaxFoodId from food";
        try
        {
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                maxFoodId = rs.getInt("getMaxFoodId");
            }   
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        return maxFoodId;
    }
    
    public ArrayList<BankTransaction> getTransactions(String bankAccountNo)
    {
        ArrayList<BankTransaction> transactions = new ArrayList<BankTransaction>();
        
        String selectStatement = "select accountno, amount,"
                + "to_char(datetime,'DD/MM/YY hh:mi') dt from banktransaction"
                + " where accountno = ? order by datetime asc";
        try
        {    
            PreparedStatement stmt = conn.prepareStatement(selectStatement);
            stmt.setString(1, bankAccountNo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                String accountno = rs.getString("accountno");
                double amount = rs.getDouble("amount");
                String datetime = rs.getString("dt");
                BankTransaction trans = new BankTransaction(accountno, amount, datetime);
                transactions.add(trans);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return transactions;

    }
    public boolean processTransaction(String bankAccountNo, double amount)
    {
        String sql = "{ call processTransaction(?,?) }";
        try
        {
            CallableStatement statement = conn.prepareCall(sql);
            statement.setString(1,bankAccountNo);
            statement.setDouble(2,amount);
            statement.execute();
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
