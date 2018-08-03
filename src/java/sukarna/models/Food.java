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
public class Food {
    public int foodId;
    public String name;
    public String category;
    public int price;
    public String description;
    
    public Food(int foodId,String name,String category,int price,String description){
        this.foodId = foodId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }
}
