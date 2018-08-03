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
public class User {
    public int userId;
    public String username;
    public String email;
    public String mobileNo;
    public String address;
    
    public User(int userId,String username,String email,String mobileNo,String address){
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
    }
}
