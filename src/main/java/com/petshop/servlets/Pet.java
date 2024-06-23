package com.petshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Pet extends HttpServlet {
    private static List<String> pets = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pet = request.getParameter("pet");
        pets.add(pet);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Criado um novo Pet: " + pet);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Pets cadastrados: " + pets.toString());
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldPet = request.getParameter("oldPet");
        String newPet = request.getParameter("newPet");
        int index = pets.indexOf(oldPet);
        if (index != -1) {
            pets.set(index, newPet);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Pet atualizado: " + newPet);
        } else {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Pet não encontrado: " + oldPet);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pet = request.getParameter("pet");
        boolean removed = pets.remove(pet);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (removed) {
            out.println("Pet deletado: " + pet);
        } else {
            out.println("Pet não encontrado: " + pet);
        }
    }
}
