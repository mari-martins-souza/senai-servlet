package com.petshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Tutor extends HttpServlet {
    private static List<String> tutores = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tutor = request.getParameter("tutor");
        tutores.add(tutor);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Criado um novo Tutor: " + tutor);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("Tutores cadastrados: " + tutores.toString());
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oldTutor = request.getParameter("oldTutor");
        String newTutor = request.getParameter("newTutor");
        int index = tutores.indexOf(oldTutor);
        if (index != -1) {
            tutores.set(index, newTutor);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Tutor atualizado: " + newTutor);
        } else {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("Tutor não encontrado: " + oldTutor);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tutor = request.getParameter("tutor");
        boolean removed = tutores.remove(tutor);
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        if (removed) {
            out.println("Tutor deletado: " + tutor);
        } else {
            out.println("Tutor não encontrado: " + tutor);
        }
    }
}
