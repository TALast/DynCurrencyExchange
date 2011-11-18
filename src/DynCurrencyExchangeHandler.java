package mywww.project2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Tolis
 */
public class DynCurrencyExchangeHandler extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String[] currency = new String[] {"USD", "EUR", "GBP"};
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String inputCur = request.getParameter("inputCur");
        String outputCur = request.getParameter("outputCur");
        
        URL rateURL = new URL("http://www.google.com/ig/calculator?hl=en&q=1"+inputCur+"=?"+outputCur);
        URLConnection yc = rateURL.openConnection();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        
        String inputLine = in.readLine();
        String value = inputLine.substring(inputLine.indexOf("rhs: \"") + 6);
        
        double valueOf1 = Double.valueOf(value.substring(0, value.indexOf(" "))).doubleValue();
        double valueFrom1 = 1.0 / valueOf1;
        double val = Double.valueOf(request.getParameter("amount1")).doubleValue();
        double newVal = valueOf1 * val;
        
        
        PrintWriter out = response.getWriter();
        try {
            
            request.setAttribute("result", roundTwoDecimals(newVal));
            request.setAttribute("valOf1", roundTwoDecimals(valueOf1));
            request.setAttribute("valFrom1", roundTwoDecimals(valueFrom1));
            
            request.getRequestDispatcher("/display.jsp").forward(request, response); 
            //response.sendRedirect("display.jsp");
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    double roundTwoDecimals(double d) {
        int x = (int)(d * 100);
        d = ((double)x) / 100.0;
        return d;
    }
}
