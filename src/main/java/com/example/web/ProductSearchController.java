package com.example.web;

import com.example.model.Product;
import com.example.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/search")
public class ProductSearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        // 1. 取得輸入參數 ------------------------------------------------------
        String productName = req.getParameter("productName");

        // 2. 進行查詢 ----------------------------------------------------------
        try {
            // 透過商品名稱進行模糊查詢 -------------------------------
            List<Product> products = new ProductService().searchProductsByName(productName);

            // 回傳商品資料清單與商品名稱 -----------------------------
            req.setAttribute("productName", productName);
            req.setAttribute("products", products);

            // 跳轉結果頁面
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("Search failed", e);
        }
    }
}
