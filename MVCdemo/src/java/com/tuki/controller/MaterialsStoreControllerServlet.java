/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.controller;

import com.tuki.core.Category;
import com.tuki.core.Producer;
import com.tuki.dao.CategoryDao;
import com.tuki.dao.MaterialsDao;
import com.tuki.dao.ProducerDao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pro
 */
@WebServlet("/MaterialsStoreControllerServlet")
public class MaterialsStoreControllerServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	public static CategoryDao categoryDAO = new CategoryDao();
	public static ProducerDao producerDAO = new ProducerDao();
	public static MaterialsDao materialsDAO = new MaterialsDao();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        
        
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing Books
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {
                            case "TOP_PRODUCER_REVENUE":
				topProducerByRevenue(request, response);
				break;
			
			case "TOP_CATEGORY_REVENUE":
				topCategoryByRevenue(request, response);
				break;

			default:
				showAll(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

    }
    
    public static void topCategoryByRevenue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ArrayList<Category> categoryList = categoryDAO.findAllCategory();
			Collections.sort(categoryList, Category.compare);
			request.setAttribute("category_List", categoryList);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/report/category_revenue.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static void topProducerByRevenue(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ArrayList<Producer> producerList = producerDAO.findAllProducer();
			Collections.sort(producerList, Producer.compare);
			request.setAttribute("producer_List", producerList);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/report/producer_revenue.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
   
    
    public static void showAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			ArrayList<Category> categoryList = categoryDAO.findAllCategory();
			Collections.sort(categoryList, Category.compare);
			request.setAttribute("category_List", categoryList);
                        
			ArrayList<Producer> producers = producerDAO.findAllProducer();
			Collections.sort(producers, Producer.compare);
			request.setAttribute("producer_List", producers);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/report/trangchu.jsp");
			try {
				dispatcher.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    

   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
