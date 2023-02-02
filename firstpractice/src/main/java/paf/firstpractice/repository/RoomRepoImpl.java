package paf.firstpractice.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import paf.firstpractice.model.Room;

@Repository
public class RoomRepoImpl implements RoomRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Set SQL Commands
    String countSQL = "select count(*) from room";
    String insertSQL = "insert into room (room_type, price) values (?, ?)";
    String selectSQL = "select * from room";
    String selectByIdSQL = "select * from room where id = ?";
    String updateSQL = "update room set room_type = ?, price =? where id = ?";
    String deleteSQL = "delete from room where id = ?";

    //Method to count total number of rooms
    //String countSQL = "select count(*) from room"
    @Override
    public int count() {
        Integer cnt = 0;
        cnt = jdbcTemplate.queryForObject(countSQL, Integer.class);
        if(cnt == null) {
            return 0;
        }
        else {
            return cnt;
        }
    }

    //Method to insert data in the table and confirm if data has been saved
    //String insertSQL = "insert into room (room_type, price) values (?, ?)"
    @Override
    public Boolean save(Room room) {
        Boolean saved = false;
        saved = jdbcTemplate.execute(insertSQL, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException {
                ps.setString(1, room.getRoomType());
                ps.setInt(2, room.getPrice());
                Boolean saving = ps.execute();
                return saving;
            }
            
        });
        return saved;
    }

    //Method to extract out the records of all the rooms
    //String selectSQL = "select * from room"
    @Override
    public List<Room> findAll() {
        List<Room> allRoom = new ArrayList<Room>();
        allRoom = jdbcTemplate.query(selectSQL, BeanPropertyRowMapper.newInstance(Room.class));
        return allRoom;
    }

    //Method to extract the record of room specified by Id
    //String selectByIdSQL = "select * from room where id = ?"
    @Override
    public Room findById(Integer id) {
        Room findRoom = new Room();
        findRoom = jdbcTemplate.queryForObject(selectByIdSQL, BeanPropertyRowMapper.newInstance(Room.class), id);
        return findRoom;
    }

    //Method to update the values in the record of room specified by Id
    //String updateSQL = "update room set room_type = ?, price =? where id = ?"
    @Override
    public int update(Room room) {
        int updated = 0;
        updated = jdbcTemplate.update(updateSQL, new PreparedStatementSetter() {

        @Override
        public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, room.getRoomType());
                ps.setInt(2, room.getPrice());
                ps.setInt(3, room.getId());
            }

        });
        return updated;
    }

    //Method to delete a record of room specified by Id
    //String deleteSQL = "delete from room where id = ?"
    @Override
    public int deleteById(Integer id) {

        int deleted = 0;

        PreparedStatementSetter pss = new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, id);
            }
        };

        deleted = jdbcTemplate.update(deleteSQL, pss);
        return deleted;
    }

}