package web;
import javax.persistence.*;

@Entity @Table(name="coffee")
public class Coffee {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public Long id;
	public String name;
	public char size;
	public double price;
        
        public long getID(){return id;}
        public String getName(){return name;}
        public char getSize(){return size;}
        public double getPrice(){return price;}
        }

