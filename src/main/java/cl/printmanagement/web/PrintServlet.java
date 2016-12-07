package cl.printmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mysql.jdbc.StringUtils;

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
 * 
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
		print.setJobId(request.getParameter("jobId"));
		
		String pagesNumberS = request.getParameter("pagesNumber");
		Integer pagesNumber = Integer.parseInt(pagesNumberS);
		print.setPagesNumber(pagesNumber);
		
		
		logger.info("Trying to insert " + print);
		
		PrintWriter out = response.getWriter();
		
		if(!StringUtils.isNullOrEmpty(print.getComputer()) && !StringUtils.isNullOrEmpty(print.getJobId())){
			try {
				Print oldPrint = DBService.getInstance().getPrint(print.getJobId(), print.getComputer());
				if(oldPrint != null){
					oldPrint.setPagesNumber(print.getPagesNumber());
					DBService.getInstance().saveDBEntry(oldPrint);
					print(out, "Print updated, found a print object with same jobId and computer. " + oldPrint.toString());
				}else{
					DBService.getInstance().saveDBEntry(print);
					print(out, "Print saved as new. " + print.toString());
				}
				out.print(print.toString());
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(e);
				print(out, "Internal Error in print-manager service\n" + e.toString());
			}	
		}else{
			print(out, "The Print could not be saved, because the parameters list was incomplete\n" + print.toString());
		}
		
		out.close();
	}

	private static void print(PrintWriter out, String text){
		logger.info(text);
		out.println(text);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}