package com.example.coffeetest;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Coffee {
    private String name;
    private int packingKg;
    private int quantity;
    private int price$;

    public Coffee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPackingKg() {
        return packingKg;
    }

    public void setPackingKg(int packingKg) {
        this.packingKg = packingKg;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice$() {
        return price$;
    }

    public void setPrice$(int price$) {
        this.price$ = price$;
    }

    public List<Coffee> getAllInfoDB(){
        ArrayList<Coffee> coffees = new ArrayList<>();
        String sql = "SELECT * FROM \"coffee\";";
        Connection connection;
        Statement statement;
        String url = "jdbc:postgresql://localhost/postgres";
        String user = "postgres";
        String password = "zn23102010";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Coffee coffee = new Coffee();
                String name = rs.getString("name");
                int packingKg = rs.getInt("packingKG");
                int quantity = rs.getInt("quantity");
                int price$ = rs.getInt("price$");
                coffee.setName(name);
                coffee.setPackingKg(packingKg);
                coffee.setQuantity(quantity);
                coffee.setPrice$(price$);
                coffees.add(coffee);
            }
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
        return coffees;
    }

    @Override
    public String toString() {
        return "Coffee: " +
                "name='" + name + '\'' +
                ", packingKg=" + packingKg +
                ", quantity=" + quantity +
                ", price$=" + price$ +
                '.';
    }
}