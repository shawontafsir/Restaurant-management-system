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
public class Order {
    public int foodId;
    public String name;
    public String category;
    public int orderno;
    public int price;
    public int cost;
    
    public Order(int foodId,String name,String category,int orderno,int price,int cost){
        this.foodId = foodId;
        this.name = name;
        this.category = category;
        this.orderno = orderno;
        this.price = price;
        this.cost = cost;
    }
}
