package com.internet.shop.controllers;

import com.internet.shop.lib.Injector;
import com.internet.shop.models.Product;
import com.internet.shop.models.ShoppingCart;
import com.internet.shop.services.ProductService;
import com.internet.shop.services.ShoppingCartService;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CartController extends HttpServlet {
    private static final Long USER_ID = 1L;

    private static final Injector injector =
            Injector.getInstance("com.internet.shop");
    ShoppingCartService shoppingCartService =
            (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
    ProductService productService =
            (ProductService) injector.getInstance(ProductService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            ShoppingCart shoppingCart = shoppingCartService.getByUserId(USER_ID);
            req.setAttribute("cart", shoppingCart.getProducts());
            req.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp").forward(req, resp);
        } catch (NoSuchElementException e) {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(USER_ID);
            shoppingCartService.create(shoppingCart);
            System.out.println(555);
            req.setAttribute("cart", shoppingCart.getProducts());
            req.getRequestDispatcher("/WEB-INF/views/cart/cart.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        ShoppingCart shoppingCart = shoppingCartService.getByUserId(USER_ID);
        shoppingCartService.addProduct(shoppingCart, productService.get(Long.parseLong(id)));
        resp.sendRedirect(req.getContextPath() + "/cart");

    }
}
