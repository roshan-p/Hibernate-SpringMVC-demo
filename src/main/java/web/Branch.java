package web;

import javax.persistence.*;

@Entity
@Table(name="branch")
// in free marker class need to be public
public class Branch{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) 
    public long id;
    public String name;
    @Column(name="type") // map variable in java to db. If the name are same we no need to do this.
    char branchtype;
    int staff;
    // in free marker we need to create get method to show the data in html
    public String getName(){return name;}
    public char getBranchType(){return branchtype;}
    public int getStaff(){return staff;}
    
}

