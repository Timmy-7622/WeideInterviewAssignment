package com.example.service;

import com.example.dao.ProductDao;
import com.example.model.Product;
import com.microsoft.sqlserver.jdbc.StringUtils;

import java.util.List;

public class ProductService {

    private ProductDao productDAO;

    public ProductService() {
        this.productDAO = new ProductDao();
    }

    public List<Product> searchProductsByName(String searchName) {
        if (StringUtils.isEmpty(searchName)) {
            return productDAO.findAll();
        }

        return productDAO.findByNameLike(searchName.trim());
    }
}