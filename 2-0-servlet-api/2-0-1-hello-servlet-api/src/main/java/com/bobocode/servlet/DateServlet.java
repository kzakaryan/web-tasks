package com.bobocode.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * This servlet responds to requests sent to the "/date" path.
 * It will return the current date as the response using LocalDate.now().
 */
@WebServlet("/date")
public class DateServlet extends HttpServlet {

    /**
     * This method is overridden to handle GET requests on the /date path.
     * It will return the current date in the response.
     *
     * @param request an {@link HttpServletRequest} object that contains the request
     *                the client has made of the servlet.
     * @param response an {@link HttpServletResponse} object that contains the response
     *                 the servlet sends to the client.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the response content type to "text/html"
        response.setContentType("text/html");

        // Get a PrintWriter object to write the response
        PrintWriter out = response.getWriter();

        // Get the current date using LocalDate.now()
        LocalDate currentDate = LocalDate.now();

        // Write the HTML content to the response
        out.println("<html><body align=\"center\">");
        out.println("<h1>The current date is: " + currentDate + "</h1>");
        out.println("</body></html>");
    }
}
