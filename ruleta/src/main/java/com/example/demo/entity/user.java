package com.example.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Yareth Pinzon
 */
@Entity
@Table(name="user")
public class user {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="mail")
    private String mail;
    @Column(name="password")
    private String password;
    @Column(name="money")
    private String money;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getMoney() {
    	return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public user(int id, String name, String mail, String password, String money ) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.money = money;
    }
   public user(){  
   }
    
}

