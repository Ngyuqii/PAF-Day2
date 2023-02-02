package paf.firstpractice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import paf.firstpractice.model.Room;
import paf.firstpractice.service.RoomService;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    RoomService roomSvc;

    @GetMapping("/count")
    public Integer getRoomCount(){
        
    Integer roomCount = roomSvc.count();
    return roomCount;
    }

    @GetMapping("/")
    public ResponseEntity<List<Room>> findAllRooms(){

        List<Room> allRooms = new ArrayList<Room>();
        allRooms = roomSvc.findAll();

        if (allRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(allRooms, HttpStatus.OK);
        }
    }
    
    //Try
    @GetMapping("/{id}")
    public ResponseEntity<Room> findARoombyId(@PathVariable("id") int id){
        Room oneRoom = new Room();
        oneRoom = roomSvc.findById(id);
        
        if (oneRoom == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(oneRoom, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Boolean> createRoom(@RequestBody Room room) {
        Room rm = room;
        System.out.println(">>>>>" + rm);
        Boolean result = roomSvc.save(rm);

        if(result){
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/")
    public ResponseEntity<Integer> updateRoom(@RequestBody Room room){
        Room rm = room;
        int updated = roomSvc.update(rm);

        if(updated == 1){
            return new ResponseEntity<>(1, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteRoom (@PathVariable("id") int id){
        int delRoom = 0;
        delRoom = roomSvc.deleteById(id);

        if(delRoom == 0){
            return new ResponseEntity<>(0, HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(1, HttpStatus.OK);
        }

    }
}
