package com.example.dao;

import com.example.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=ProductSearchDB;encrypt=false;trustServerCertificate=true";
    private static final String USER = "Timmy";
    private static final String PASS = "1028";

    public List<Product> findByNameLike(String keyword) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id, name, price, stock FROM products WHERE name LIKE ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + (keyword == null ? "" : keyword.trim()) + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setStock(rs.getInt("stock"));
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id, name, price, stock FROM products ";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
                PreparedStatement ps = conn.prepareStatement(sql)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setId(rs.getInt("id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getInt("price"));
                    product.setStock(rs.getInt("stock"));
                    list.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
