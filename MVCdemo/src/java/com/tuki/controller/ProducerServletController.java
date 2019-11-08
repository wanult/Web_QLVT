/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuki.controller;

import com.tuki.core.Producer;
import com.tuki.dao.ProducerDao;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet("/ProducerServletController")
public class ProducerServletController extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public static ProducerDao producerDao = new ProducerDao();
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");

			// if the command is missing, then default to listing Categorys
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {

			case "LIST":
				listProducer(request, response);
				break;

			case "NEW":
				newProducer(request, response);
				break;
			case "ADD":
				addProducer(request, response);
				break;

			case "LOAD":
				loadProducer(request, response);
				break;

			case "UPDATE":
				updateProducer(request, response);
				break;

			case "DELETE":
				deleteProducer(request, response);
				break;
			default:
				listProducer(request, response);
			}

		} catch (Exception exc) {
			throw new ServletException(exc);
		}

	}

	private void addNewProducer(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, SQLException {
		String name = request.getParameter("nameProducer");
		String stringDate = request.getParameter("dobString");

		Date date = (Date) sdf.parse(stringDate);
		Producer theProducer = new Producer(producerDao.generateId(), name, date);
		producerDao.addNewProducer(theProducer);
		try {
			listProducer(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void newProducer(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Producer/add-producer-form.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addProducer(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, SQLException, ServletException, IOException {
		Long id = producerDao.generateId();
		String name = request.getParameter("nameProducer");
		String dobString = request.getParameter("dobString");
		Date dob = (Date) sdf.parse(dobString);
		// create a new Category object
		Producer theProducer = new Producer(id, name, dob);

		// perform update on database
		producerDao.addNewProducer(theProducer);

		// send them back to the "list Categorys" page
		listProducer(request, response);

	}

	private void listProducer(HttpServletRequest request, HttpServletResponse response)
			throws ParseException, SQLException, ServletException, IOException {
		// get Categorys from db util
		List<Producer> Categorys = producerDao.findAllProducer();

		// add Categorys to the request
		request.setAttribute("PRODUCER_LIST", Categorys);

		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Producer/list-producer.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteProducer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read Category id from form data
		String producerId = request.getParameter("producerId");

		// delete Category from database
		producerDao.deleteProducerById(Long.parseLong(producerId));

		// send them back to "list Categorys" page
		listProducer(request, response);
	}

	private void updateProducer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read Category info from form data
		int id = Integer.parseInt(request.getParameter("producerId"));
		String name = request.getParameter("name");
		String dobString = request.getParameter("dob");
		Date dob = (Date) sdf.parse(dobString);
		// create a new Category object
		Producer theProducer = new Producer(id, name, dob);

		// perform update on database
		producerDao.modifyProducer(theProducer);

		// send them back to the "list Categorys" page
		listProducer(request, response);

	}

	private void loadProducer(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read Category id from form data
		String producerId = request.getParameter("producerId");

		Producer theProducer = producerDao.findProducerById(Long.parseLong(producerId));

		request.setAttribute("the_Producer", theProducer);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/Producer/update-producer-form.jsp");
		dispatcher.forward(request, response);
	}




   
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
