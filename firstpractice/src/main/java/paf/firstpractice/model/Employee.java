package paf.firstpractice.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer salary;

    //Link to the child table
    private List<Dependant> dependant;

}
