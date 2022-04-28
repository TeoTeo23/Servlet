/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author TeoTeo23_
 */
public class Servlet extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        // Setting up types printwriter, and calculator Object
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Calculator c = new Calculator(0.0, 0.0);
        
        // Working on URL and fetching parameters
        String url = request.getRequestURL().toString();
        String[] sel = url.split("/");
        String end = sel[sel.length - 1];
        
        String var1 = request.getParameter("x");
        String var2 = request.getParameter("y");
        // String var3 = request.getParameter("z"); // exponent for powers
        // Working with parameters
        if(var1 == null || var2 == null || var1.equals("") || var2.equals("")){
            response.sendError(400, "Missing parameters.\r\n");
            return;
        }
        double x = Double.parseDouble(var1);
        double y = Double.parseDouble(var2);
        // double z = Double.parseDouble(var3);
        
        try{
            if(end.equalsIgnoreCase("ADD")) c.setResult(c.add(x, y));
            if(end.equalsIgnoreCase("SUB")) c.setResult(c.sub(x, y));
            if(end.equalsIgnoreCase("MUL")) c.setResult(c.mul(x, y));
            if(end.equalsIgnoreCase("DIV")){
                c.setSuffix(y);
                if(c.getSuffix() == 0.0 || (int)c.getSuffix() == 0){
                    response.sendError(400, "Division by zero.\r\n");
                    return;
                }
                c.setResult(c.div(x, y));
            }
            if(end.equalsIgnoreCase("ROOT")) c.setResult(c.squareRoot(x));
            if(end.equalsIgnoreCase("PERCENTAGE")) c.setResult(c.toPercentage(x));
            if(end.equalsIgnoreCase("POWER")) c.setResult(c.elvTen(x));
            if(end.equalsIgnoreCase("FACT")) c.setResult(c.factorial(x));
            if(end.equalsIgnoreCase("LOG")) c.setResult(c.logarythm(x));
            if(end.equalsIgnoreCase("RTD")) c.setResult(c.radToDeg(x));
            if(end.equalsIgnoreCase("DTR")) c.setResult(c.degToRad(x));
            if(end.equalsIgnoreCase("SIN")) c.setResult(c.toSin(x));
            if(end.equalsIgnoreCase("COS")) c.setResult(c.toCos(x));
            if(end.equalsIgnoreCase("TAN")) c.setResult(c.toTan(x));
        }catch(DivisionException exception){
        response.sendError(400, exception.getMessage());
        }
        // printing the result
        out.println("<result>" + c.getResult() + "</result>");
        // out.println("<prefix>" + c.getPrefix() + "</prefix>");
        // out.println("<suffix>" + c.getSuffix() + "</suffix>");
    }
}
