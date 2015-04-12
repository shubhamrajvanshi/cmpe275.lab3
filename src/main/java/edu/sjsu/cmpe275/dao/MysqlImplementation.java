package edu.sjsu.cmpe275.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;
@Component
public class MysqlImplementation implements DaoOperationsInterface { 
	@Autowired
	private DataSource datasource ;
	
	Connection conn = null;
	PreparedStatement ps ;
	ResultSet rs ;
	Sponsor s ;
	public MysqlImplementation(DataSource datasource){
	try {
	//	Class.forName("com.mysql.jdbc.Driver").newInstance(); as it is already there in servlet-context
			this.conn = datasource.getConnection();
		}
		catch(Exception e){System.out.println("error in getting connection");}
	}
	
	
	
	@Override
	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("Select * from player where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
		//	Player p = new Player(id, rs.getString("firstname"), rs.getString("lastname"),
	//				rs.getString("email"),rs.getString("description"),null , rs.getString("sponsor"), null );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setPlayer(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sponsor getSponsor(int id) {
		// TODO Auto-generated method stub
		try {
			ps = conn.prepareStatement("Select * from sponsor where id=?");
			ps.setInt(1, id);
		//	System.out.println("Query about to execute");
			rs = ps.executeQuery();
	//		System.out.println("Query executed");
			if(rs.next())
			{	s = new Sponsor(id, rs.getString("name"), rs.getString("description"));
			 return s;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setSponsor(Sponsor s) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAddress(Address a) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @return the datasource
	 */
	public DataSource getDatasource() {
		return datasource;
	}



	/**
	 * @param datasource the datasource to set
	 */
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}


}

