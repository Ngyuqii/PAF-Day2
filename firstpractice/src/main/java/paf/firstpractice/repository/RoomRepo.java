package paf.firstpractice.repository;

import java.util.List;

import paf.firstpractice.model.Room;

public interface RoomRepo {

    int count();

    //Method to create, check if it is saved successfully
    Boolean save(Room room);

    //Method to read all records
    List<Room> findAll();

    //Method to read a record based on Id
    Room findById(Integer id);

    //Method to update the room details
    int update(Room room);

    //Method to delete a record based on Id
    int deleteById(Integer id);
    
}
