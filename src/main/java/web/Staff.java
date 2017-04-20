package web;

import javax.persistence.*;

@Entity
@Table(name="staff")
public class Staff{
    @Id
    long id;
    public String name;
    public double salary;
    char gender;
}