import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Emp_insert
 * 
 * @author Ashubala
 */
public class Emp_insert extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     * 
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h4 style=\"text-align:center\">Balaji.M 20MIC0108</h4>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Emp_insert</title>");
            out.println("</head>");
            out.println("<body>");
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scse", "root", "")) {
                    PreparedStatement st = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)");

                    // Set parameters using the request object
                    st.setInt(1, Integer.parseInt(request.getParameter("id")));
                    st.setString(2, request.getParameter("name"));
                    st.setString(3, request.getParameter("mob_no"));
                    st.setString(4, request.getParameter("year"));
                    st.setInt(5, Integer.parseInt(request.getParameter("salary")));
                    st.setInt(6, Integer.parseInt(request.getParameter("exp")));

                    // Execute the insert command
                    st.executeUpdate();

                    // Display successful result
                    out.println("<h1 style=\"color:white;text-align:center;font-size:25px;background-color:rgb(243, 115, 179)\">⚪ Successfully Inserted ⚪</h1>");
                } catch (Exception e) {
                    out.println("<p>Error: " + e.getMessage() + "</p>");
                }
            } catch (Exception e) {
                out.println("<p>Error: " + e.getMessage() + "</p>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Emp_insert Servlet";
    }
}
