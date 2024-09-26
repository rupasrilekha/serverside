package StringManipulationServlet;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manipulate")
public class StringManipulationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String string1 = request.getParameter("string1");
        String string2 = request.getParameter("string2");

        // String Manipulations
        String joined = string1 + string2;
        String removed = string1.replaceAll(string2, "");
        String replaced = string1.replace('a', '@'); // Example replacement
        String upperCase = string1.toUpperCase();
        String reversed = new StringBuilder(string1).reverse().toString();

        request.setAttribute("joined", joined);
        request.setAttribute("removed", removed);
        request.setAttribute("replaced", replaced);
        request.setAttribute("upperCase", upperCase);
        request.setAttribute("reversed", reversed);

        RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
        rd.forward(request, response);
    }
}
