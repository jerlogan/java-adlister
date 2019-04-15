import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/counter")
public class counter extends HttpServlet {
    static int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        response.setContentType("text/html");
        String.format("counter", counter);
        PrintWriter output = response.getWriter();
        output.println("counter: " + counter + "");
        counter++;
        String count = request.getParameter("count");
        if (count.equalsIgnoreCase("reset")) {
            counter = 0;
        }

    }
}
