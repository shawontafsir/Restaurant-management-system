/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sukarna.models;

/**
 *
 * @author shawontafsir
 */
public class OrderList {
    public int orderId;
    public int foodId;
    public int userId;
    public int customerId;
    public String orderTime;
    public int orderNo;
    public int employeeId;
    public OrderList(int orderId,int foodId,int userId,int customerId,String orderTime,int orderNo,int employeeId){
        this.orderId = orderId;
        this.foodId = foodId;
        this.userId = userId;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.orderNo = orderNo;
        this.employeeId = employeeId;
    }
}
