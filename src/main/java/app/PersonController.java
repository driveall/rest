package app;

import entity.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Former;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private int count = 5;
    private List<Person> perss = new LinkedList<>();
    {
        for(int i = 0; i < count; i++){
            perss.add(Former.formPerson(perss));
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> persons(@RequestParam(name="city", required=false, defaultValue="All") String city) {
        List<Person> out = new LinkedList<>();
        if(city.equals("Kiev")){
            for(Person p:perss){
                if(p.getCity().equals("Kiev")){
                    out.add(p);
                }
            }
        }else if(city.equals("Dnepr")){
            for(Person p:perss){
                if(p.getCity().equals("Dnepr")){
                    out.add(p);
                }
            }
        }else{
            out = perss;
        }
        return out;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setCount(@RequestParam(value="count", required=false, defaultValue="5") String count, HttpServletResponse resp) throws IOException {
        this.count = Integer.parseInt(count);
        perss.clear();
        for(int i = 0; i < this.count; i++){
            perss.add(Former.formPerson(perss));
        }
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<form action='/persons'>");
        out.println("Input city(Kiev, Dnepr or any other):<input name='city'/>");
        out.println("<input type='submit' value='Take persons by city'/>");
        out.println("</form>");
        out.println("<form action='/persons'>");
        out.println("<input type='submit' value='Take persons'/>");
        out.println("</form>");
        out.println("<form action='/persons' method='POST'>");
        out.println("How many persons in the list?: <input name='count'/>");
        out.println("<input type='submit' value='Set count of persons'/>");
        out.println("</form>");
        out.close();
    }
}