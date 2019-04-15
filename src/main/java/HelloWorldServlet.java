import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter output = response.getWriter();
        if (name == null) {
            name = "World";
        }

        output.println("<h1>Hello " +name+ ".</h1>");



    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
            String email = request.getParameter("email");
            PrintWriter output = response.getWriter();
            output.println("This is your email: " +email+ "");
        }
}



