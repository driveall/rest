package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class AppController {
    @RequestMapping("/main")
    public void main(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form action='/persons' method='POST'>");
        out.println("How many persons in the list?: <input name='count'/>");
        out.println("<input type='submit' value='Set count of persons'/>");
        out.println("</form>");
        out.close();
    }
}
