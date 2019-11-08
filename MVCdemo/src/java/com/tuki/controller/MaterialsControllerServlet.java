/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.controller;

import com.tuki.core.Category;
import com.tuki.core.Materials;
import com.tuki.dao.CategoryDao;
import com.tuki.dao.MaterialsDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet("/MaterialsControllerServlet")
public class MaterialsControllerServlet extends HttpServlet {
        private static final long serialVersionUID = 1L;
	public static CategoryDao categoryDAO = new CategoryDao();
	public static MaterialsDao materialsDAO = new MaterialsDao();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing Materials
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "NEW":
				newMaterials(request, response);
				break;
			case "LIST":
				listMaterials(request, response);
				break;
				
			case "ADD":
				addMaterials(request, response);
				break;
				
			case "LOAD":
				loadMaterials(request, response);
				break;
				
			case "UPDATE":
				updateMaterials(request, response);
				break;
			
			case "DELETE":
				deleteMaterials(request, response);
				break;
			default:
				listMaterials(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
    }
    
    private void deleteMaterials(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Materials id from form data
		String theMaterialsId = request.getParameter("materialsId");
		
		// delete Materials from database
		materialsDAO.deleteMaterialsById(Long.parseLong(theMaterialsId));
		
		// send them back to "list Materials" page
		listMaterials(request, response);
	}
    
    private void updateMaterials(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read Materials info from form data
		int id = Integer.parseInt(request.getParameter("materialsId"));
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String categoryId = request.getParameter("categoryName");
		Category category=categoryDAO.findCategoryById(Long.parseLong(categoryId));
		// create a new Materials object
		Materials theMaterials= new Materials(id, name,Double.parseDouble(price),category);
		
		// perform update on database
		materialsDAO.modifyMaterials(theMaterials);
		
		// send them back to the "list Materials" page
		listMaterials(request, response);
		
	}
    
    private void newMaterials(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {

			ArrayList<Category> category_List=categoryDAO.findAllCategory();
			
			request.setAttribute("category_List", category_List);
			// send to jsp page: update-Materials-form.jsp
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("/Materials/add-materials-form.jsp");
			dispatcher.forward(request, response);		
		}
	private void loadMaterials(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read Materials id from form data
		String theMaterialsId = request.getParameter("materialsId");
		
		// get Materials from database (db util)
		Materials theMaterials = materialsDAO.findMaterialsById(Long.parseLong(theMaterialsId));
		
		// place MAterials in the request attribute
		request.setAttribute("the_Materials", theMaterials);
		ArrayList<Category> category_List=categoryDAO.findAllCategory();
		
		request.setAttribute("category_List", category_List);
		// send to jsp page: update-Materials-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/Materials/update-materials-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addMaterials(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long id = materialsDAO.generateId();
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String categoryId = request.getParameter("categoryName");
		Category category=categoryDAO.findCategoryById(Long.parseLong(categoryId));
		// create a new Materials object
		Materials theMaterials = new Materials(id, name,Double.parseDouble(price),category);
		
		// perform update on database
		materialsDAO.addNewMaterials(theMaterials);
		
		// send them back to the "list Materials" page
		listMaterials(request, response);
	}

	private void listMaterials(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// get Materials from db util
		List<Materials> Materials = materialsDAO.findMaterials();
		
		// add Materials to the request
		request.setAttribute("MATERIALS_LIST", Materials);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Materials/list-materials.jsp");
		dispatcher.forward(request, response);
	}

   

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
