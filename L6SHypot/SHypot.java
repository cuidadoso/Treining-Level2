// This servlet computes the length of the hypotenuse
// given the length of the two opposing sides.

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SHypot extends HttpServlet {
	public void doGet(HttpServletRequest request,
					  HttpServletResponse response)
					  throws ServletException, IOException {
					  
		// Obtain the parameters that contain the lengths
		// of the two sides.
		String side1 = request.getParameter("firstside");
		String side2 = request.getParameter("secondside");
		
		// Set the content type and get a stream
		// for the response.
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			double a, b;
			a = Double.parseDouble(side1);
			b = Double.parseDouble(side2);
			pw.println("Hypotenuse is " + Math.sqrt(a*a + b*b));
		} catch(NumberFormatException exc) {
			pw.println("Invalid Data");
		}
		pw.close();
	}
}