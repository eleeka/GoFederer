package com.mmt.servlets;
//package com.amzi.servlets;  
  
import java.io.IOException;  
import java.io.PrintWriter;  
  

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  

import com.mmt.dao.LoginDao;
  
//import com.amzi.dao.LoginDao;  
  
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
  
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          String str=null;
        String n=request.getParameter("cityname");    
        
       // String p=request.getParameter("userpass");   
          
        
  str= LoginDao.validate(n);
  HttpSession session = request.getSession(false);  
  if(session!=null)  
  session.setAttribute("name", str);  
          
            RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");    
            rd.forward(request,response);    
     
  
        out.close();    
    }    
}   