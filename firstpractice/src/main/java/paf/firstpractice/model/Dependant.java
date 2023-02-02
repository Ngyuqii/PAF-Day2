package paf.firstpractice.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dependant {

    private Integer id;
    private String firstName;
    private String lastName;
    private String relationship;
    private Date birthDate;
    private Employee employee;
    
}
