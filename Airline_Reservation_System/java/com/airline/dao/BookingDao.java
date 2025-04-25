package com.airline.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.airline.entity.Booking;
import com.airline.utils.JdbcUtils;

public class BookingDao {
	private String query;
	
	public boolean save(int userId,int flightId) {
		boolean status = false;
		query = "insert into booking (user_id,flight_id) values(?,?)";
		try (
				Connection con = JdbcUtils.getConnection();
				PreparedStatement pstm = con.prepareStatement(query);
				){
			pstm.setInt(1, userId);
			pstm.setInt(2, flightId);
			int count = pstm.executeUpdate();
			if(count>0) {
				System.out.println(count +" Row inserted");
				status = true;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
	public List<Booking> findById(int userId){
		List<Booking> bookings = new ArrayList<Booking>();
		query="select * from booking where user_id=?";
		try(
				Connection con = JdbcUtils.getConnection();
				PreparedStatement pstm = con.prepareStatement(query);
				){
			pstm.setInt(1, userId);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
			bookings.add(new Booking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4).toLocalDate()));
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return bookings;
	}
	public boolean getAllFlights() {
		
		return false;
		
	}
	public List<Booking> findAllById(){
		List<Booking> bookings = new ArrayList<Booking>();
		query="select * from booking";
		try (
				Connection con = JdbcUtils.getConnection();
				Statement stmt = con.createStatement();){
				
		
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				bookings.add(new Booking(rs.getInt("id"),rs.getInt("user_Id"),rs.getInt("flight_id"),rs.getDate("booking_date").toLocalDate()));
			}
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return bookings;
		
	}
	
	public boolean cancelFlight(int id) {
		boolean status = false;
		query = "delete from booking where id =?";
		try (
				Connection con = JdbcUtils.getConnection();
				PreparedStatement pstm = con.prepareStatement(query);
				
				){
			pstm.setInt(1, id);
			
			int count = pstm.executeUpdate();
			if(count > 0) {
				
				status = true;
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return status;
	}

}
