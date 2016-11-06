package cl.printmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cl.printmanagement.DBService;
import cl.printmanagement.bo.Print;

/**
 * 
 * http://localhost:8080/print-management/printServlet?userName=jurzua&computer=PC01&printer=Lexon_01&document=tesis.docx&pagesNumber=1
 * http://localhost:8080/print-management/printServlet?userName=rcontreras&computer=PC0X&printer=Brother_01&document=tesis.doc&pagesNumber=10
 * http://localhost:8080/print-management/printServlet?userName=kjara&computer=PC04&printer=Brother_01&document=viajes.doc&pagesNumber=50
 * http://localhost:8080/print-management/printServlet?userName=jperez&computer=PC04&printer=Lexon_01&document=lujos.doc&pagesNumber=46
 * http://localhost:8080/print-management/printServlet?userName=jurzua&computer=PC05&printer=Brother_01&document=ontologia.doc&pagesNumber=156
 * http://localhost:8080/print-management/printServlet?userName=ricardo&computer=PC06&printer=Lexon_01&document=tesis_template.doc&pagesNumber=1
 * http://localhost:8080/print-management/printServlet?userName=ricardo&computer=PC06&printer=Lexon_01&document=tesis.doc&pagesNumber=4
 * 
 * 
 * @author jurzua
 *
 */

@WebServlet(name = "testServlet", urlPatterns = { "/printServlet" })
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 6901513653212389552L;
	
	private static final Logger logger = Logger.getLogger(PrintServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Print print = new Print();
		
		print.setUserName(request.getParameter("userName"));
		print.setComputer(request.getParameter("computer"));
		print.setDocument(request.getParameter("document"));
		print.setPrinter(request.getParameter("printer"));
		
		String pagesNumberS = request.getParameter("pagesNumber");
		Integer pagesNumber = Integer.parseInt(pagesNumberS);
		print.setPagesNumber(pagesNumber);
		
		
		logger.info("Trying to insert " + print);
		
		PrintWriter out = response.getWriter();
		try {
			DBService.getInstance().saveDBEntry(print);
			out.print("The print has been saved ");
			out.print(print.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
			out.println(e.toString());
		}
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}