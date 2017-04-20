//Get data from sql database By using JDBC
package web;
import java.sql.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
class Main {

    @RequestMapping("/show-coffee")
    @ResponseBody
    LinkedList showCoffee() {
        LinkedList data = new LinkedList();
        try {
           
            String sql = "select * from coffee order by size";
            Class.forName("com.mysql.jdbc.Driver"); // get a driver
            Connection c =DriverManager.getConnection(
                    "jdbc:mysql://128.199.119.79/icoffee",
                    "hibernate","p@ssword"
            );
           Statement s = c.createStatement();
           ResultSet r = s.executeQuery(sql);
           while(r.next()){
               //data.add(r.getString("name")); //first method directly add
               //second method create class then add
               Product p = new Product();
               p.name = r.getString("name");
               p.size = r.getString("size");
               p.price = r.getDouble("price");
               data.add(p);
           } 
           r.close(); s.close(); c.close();
                    

        } catch(Exception e)  {
            System.out.println(e);

        }
        return data;
    }
    public class Product{
        public String name;
        public String size;
        public double price;
        
        public String getName(){return name;}
        public String getSize(){return size;}
        public double getPrice(){return price;}
    }

}
