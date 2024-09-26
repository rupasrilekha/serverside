import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation for deleting a record from the Employee table.
 * 
 * @author Ashubala
 * NAME: BALAJI.M REG.NO.:20MIC0108
 */
public class records_delete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use the following sample code. */
            out.println("<h4 style=\"text-align:center\">Balaji.M 20MIC0108</h4>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet servlet_jdbc</title>");
            out.println("</head>");
            out.println("<body>");

            int id = Integer.parseInt(request.getParameter("id"));
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scse", "root", "")) {
                    Statement stmt = con.createStatement();
                    out.println("<h1 style=\"color:rgb(99, 160, 240);text-align:center;font-size:25px;background-color:rgb(243, 115, 179);color:white\">⚪ Deleting the Employee detail whose ID : " + id + " ⚪</h1>");

                    ResultSet rs = stmt.executeQuery("Select * from Employee;");
                    out.print("<h3 style=\"text-align: center;background-color:rgb(99, 160, 240);color:white\">Before Deletion :</h3>");
                    out.println("<h3 style=\"font-style: italic; text-align: center;background-color:rgb(99, 160, 240);color:white\">Emp_ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile_No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Year_of_Birth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salary&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Experience</h3>");

                    while (rs.next()) {
                        out.println("<h3>" + rs.getInt(1) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(2) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(3) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(4) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getInt(5) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getInt(6) + "</h3>");
                    }

                    String sql = "DELETE FROM Employee WHERE id = " + id + ";";
                    stmt.executeUpdate(sql);

                    rs = stmt.executeQuery("Select * from Employee;");
                    out.print("<h3 style=\"text-align: center;background-color:rgb(99, 160, 240);color:white\">After Deletion:</h3>");
                    out.println("<h3 style=\"font-style: italic; text-align: center;background-color:rgb(99, 160, 240);color:white\">Emp_ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mobile_No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Year_of_Birth&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salary&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Experience</h3>");

                    while (rs.next()) {
                        out.println("<h3>" + rs.getInt(1) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(2) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(3) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString(4) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getInt(5) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getInt(6) + "</h3>");
                    }
                } catch (Exception e) {
                    out.println(e);
                }
            } catch (Exception e) {
                out.println(e);
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on 
    // the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
