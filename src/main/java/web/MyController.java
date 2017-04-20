//Get data from sql database by using Hibernate
package web;

import java.util.*;
import org.hibernate.*;
import javax.transaction.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Controller
public class MyController {
    @RequestMapping("/update")@ResponseBody
    String updateData(){
        Branch b = new Branch();
        b.id=20;
        b.name="New York";
        b.branchtype='K';
        b.staff=17;
        Session worker = factory.openSession();
        worker.update(b);
        worker.flush(); 
        return"done";
    }
    @RequestMapping("/test-insert")@ResponseBody
    String testInsertData(){
        Branch b = new Branch();
        b.name="";
        b.branchtype='F';
        b.staff = 25;
        Session worker = factory.openSession();
        worker.save(b);
        worker.flush();
        return "done";
    }

    @RequestMapping("/view-coffee")
    String viewCoffee(Model model) {
        Session worker = factory.openSession();
        Query query = worker.createQuery("from Coffee");
        model.addAttribute("coffee", query.list());

        return "coffee";
    }

    @RequestMapping("/view-branch")
    String viewBranch(Model model) {
        Session worker = factory.openSession();
        Query query = worker.createQuery("from Branch");
        model.addAttribute("branch", query.list()); 
        return "branch";
    }

    @RequestMapping("/show-branch")
    @ResponseBody
    List showBranch() {
        Session worker = factory.openSession();
        Query query = worker.createQuery("from Branch");
        return query.list();
    }

    @RequestMapping("/show-staff")
    @ResponseBody
    List showStaff() {
        Session worker = factory.openSession();
        Query query = worker.createQuery("from Staff");
        return query.list();
    }

    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/test")
    String test() {
        return "test.jsp";
    }

    @RequestMapping("/coffee/{name}")
    @ResponseBody
    List showCoffeeByName(@PathVariable String name) {
        String hql = "from Coffee where name = :x";
        Session worker = factory.openSession();
        Query query = worker.createQuery(hql);
        query.setString("x", name);
        return query.list();
    }
    @RequestMapping("/detail")
    @ResponseBody
    List showDetail(String name) {
        String hql = "from Coffee where name = :x";
        Session worker = factory.openSession();
        Query query = worker.createQuery(hql);
        query.setString("x", name);
        return query.list();
    }
    
    @RequestMapping("/list")
    @ResponseBody
    List showCoffee() {
        Session database = factory.openSession();
        Query query = database.createQuery("from Coffee");
        List list = query.list();
        database.close();
        return list;
    }

    @RequestMapping("/list-all")
    @ResponseBody
    List showAll() {
        Session worker = factory.openSession();
        Query query = worker.createQuery("from Coffee");
        return query.list();
    }

    @RequestMapping("/list-mocha")
    @ResponseBody
    List showMocha() {
        String hql = "from Coffee where name = :x";
        Session worker = factory.openSession();
        Query query = worker.createQuery(hql);
        query.setString("x", "Mocha");
        return query.list();
    }
    @Autowired 
    SessionFactory factory;


interface Taxable {

    double total();
}

class Equipment implements Taxable {

    public double total() {
        return 100;
    }
}
}