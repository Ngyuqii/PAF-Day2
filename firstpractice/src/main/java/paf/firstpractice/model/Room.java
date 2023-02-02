package paf.firstpractice.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/*
Room fields
id int not null auto_increment,
room_type enum ('standard', 'deluxe', 'suite', 'presidential') not null,
price int not null,
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    
    private Integer id;
    private String roomType;
    private Integer price;
}
