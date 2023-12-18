package com.example.mid_exam_013.servlets;

import com.example.mid_exam_013.models.Prime;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "PrimeCheck", value = "/013/is_Prime")
public class PrimeCheck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/isPrime.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number = request.getParameter("number");
        HttpSession session = request.getSession();
        Prime prime = (Prime) session.getAttribute("ALLPrime");

        if(prime == null){
            prime = new Prime();
        }

        if (number.isEmpty()){
            request.setAttribute("message", "Empty is Invalid Input");
        } else if (isNumber(number) && Integer.parseInt(number) >= 2) {
            boolean check = prime.isPrimeCheck(Integer.parseInt(number));
            if (!check){
                prime.setAllPrimesCheck(Integer.parseInt(number), true);
                request.setAttribute("messagePrime", number + " is prime number.");
            }else {
                prime.setAllPrimesCheck(Integer.parseInt(number), false); // use Models to work in servlet setAllPrimesCheck
                request.setAttribute("messagePrime", number + " is not prime number."); // sent to Jsp
            }

        }else {
            request.setAttribute("message" ,number+" is invalid input !!!");
        }

        session.setAttribute("ALLPrime" , prime);
        session.setAttribute("Get_ALLPrime" , prime.getAllPrimesCheck());
        session.setAttribute("Get_CountIsPrime" , prime.getCountAllIsPrime());
        doGet(request,response);
    }
    private Boolean isNumber(String str){
        return str.matches("\\d+?");
    }
}