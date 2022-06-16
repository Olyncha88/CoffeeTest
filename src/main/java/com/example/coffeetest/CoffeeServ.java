package com.example.coffeetest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CoffeeServlet", value = "/coffee")
public class CoffeeServ extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Coffee coffee = new Coffee();
        List<Coffee> coffeesList = coffee.getAllInfoDB();
        request.setAttribute("coffee", coffeesList);
        getServletContext().getRequestDispatcher("/coffeeprod.jsp").forward(request, response);

    }
}
