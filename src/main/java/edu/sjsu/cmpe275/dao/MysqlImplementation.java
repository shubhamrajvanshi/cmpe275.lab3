package edu.sjsu.cmpe275.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	Player pl ;
	Address addr ;
	
	public MysqlImplementation(){
	
	}
	
	// Used to retrieve player details from database. Returns an object of type player
	
	@Override
	public Player getPlayer(long id) {
		// TODO Auto-generated method stub
		try {
			conn=datasource.getConnection();
			ps = conn.prepareStatement("Select * from player where id=?");
			ps.setInt(1, (int) id);
			rs = ps.executeQuery();
			
			if(rs.next())
			{	
				pl = new Player((long)id, rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),
						rs.getString("description"),getAddress(id,"player"),getSponsor(rs.getInt("sponsorid")));
			 return pl;
			}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
		return null;
	}

	// Used to save Player details and returns a boolean object
	@Override
	public boolean setPlayer(Player p) {
		// TODO Auto-generated method stub
		try {
			conn=datasource.getConnection();
			ps = conn.prepareStatement("Insert into player values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, (int) p.getId());
			ps.setString(2,p.getFirstname());
			ps.setString(3,p.getLastname());
			ps.setString(4,p.getDescription());
			ps.setString(5,p.getEmail());
			ps.setInt(6,(int) p.getSponsor().getId());
			ps.setString(7,p.getAddress().getStreet());
			ps.setString(8,p.getAddress().getCity());
			ps.setString(9,p.getAddress().getState());
			ps.setString(10,p.getAddress().getZip());
			//Insert the record into the table
			if(ps.executeUpdate()>0)
			 {	
				 return true;
			 }
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		finally {
			try {
				System.out.println("Closing connection in sponsor");
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
		
		return false;
	}

	@Override
	public Sponsor getSponsor(long id) {
		// TODO Auto-generated method stub
		try {
			conn=datasource.getConnection();
			ps = conn.prepareStatement("Select * from sponsor where id=?");
			ps.setInt(1, (int) id);
			rs = ps.executeQuery();
			if(rs.next())
			{	s = new Sponsor((int) id, rs.getString("name"), rs.getString("description"),getAddress(id,"sponsor"));
			 return s;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		finally {
			try {
				System.out.println("Closing connection in sponsor");
			//	conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
		return null;
	}

	@Override
	public boolean setSponsor(Sponsor s) {
		// TODO Auto-generated method stub
		try {
			conn=datasource.getConnection();
			ps = conn.prepareStatement("Insert into sponsor values(?,?,?,?,?,?,?)");
			ps.setInt(1, (int) s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getDescription());
			ps.setString(4,s.getAddress().getStreet());
			ps.setString(5,s.getAddress().getCity());
			ps.setString(6,s.getAddress().getState());
			ps.setString(7,s.getAddress().getZip());
			//Insert the record into the table
			if(ps.executeUpdate()>0) 
			 {	
				 return true;
			 }
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
				}
		finally {
			try {
				System.out.println("Closing connection in sponsor");
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
		
		return false;
	}

	@Override
	public Address getAddress(long id, String type) {
		// TODO Auto-generated method stub
		try {
			conn=datasource.getConnection();
			if(type.equalsIgnoreCase("player")){
			ps = conn.prepareStatement("Select * from player where id=?");
			}
			else{
			ps = conn.prepareStatement("Select * from sponsor where id=?");
			}
			
			ps.setInt(1, (int) id);
			rs = ps.executeQuery();
			if(rs.next())
			{	
				addr= new Address(rs.getString("street"), rs.getString("city"), rs.getString("state"),rs.getString("zip"));
			 return addr;
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		finally {
			try {
				System.out.println("Closing in Address");
	//			conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
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

	@Override
	public List<Integer> getOpponent(long id) {
		// TODO Auto-generated method stub
		List<Integer> oplist = null;
		try {
			conn=datasource.getConnection();
			ps = conn.prepareStatement("select * from opponent where playerid=?");
			ps.setInt(1, (int) id);
			rs = ps.executeQuery();
			while(rs.next()){
				oplist.add(rs.getInt("opponentid"));
			}
			return oplist ;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		finally {
			try {
				System.out.println("Closing connection in opponent");
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
		
		return null;
	}





	@Override
	public boolean setOpponent(long id1, long id2) {
		// TODO Auto-generated method stub
		try {
			conn=datasource.getConnection();
			ps = conn.prepareStatement("Insert into opponent values(?,?)");
			ps.setInt(1, (int) id1);
			ps.setInt(2, (int) id2);
			//Insert the record into the table
			if(ps.execute())
			 {	
				 return true;
			 }
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
				}
		finally {
			try {
				System.out.println("Closing connection in opponent");
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error while closing the connection.");
			}
		}
		return false;
	}

	@Override
	public boolean deletePlayer(long id) {
		// TODO Auto-generated method stub
		
		try {
			conn= datasource.getConnection();
			ps =conn.prepareStatement("Delete from player where id=?");
			ps.setInt(1, (int)id);
		    if(   ps.executeUpdate()>0)
		    {	
		    	ps.close();
		    	return true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteSponsor(long id) {
		// TODO Auto-generated method stub
		try {
			conn= datasource.getConnection();
			ps =conn.prepareStatement("Delete from sponsor where id=?");
			ps.setInt(1, (int)id);
		    if(   ps.executeUpdate()>0)
		    {	
		    	ps.close();
		    	return true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

	@Override
	public boolean deleteOpponent(long id) {
		// TODO Auto-generated method stub
		try {
			conn= datasource.getConnection();
			ps =conn.prepareStatement("Delete from opponent where opponentid=?");
			ps.setInt(1, (int)id);
		    if(ps.executeUpdate()>0)
		    {	
		    	ps.close();
		    	return true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isOpponent(long id1, long id2) {
		// TODO Auto-generated method stub
		try {
			conn= datasource.getConnection();
			ps =conn.prepareStatement("Select * from opponent where playerid=? and opponentid=?");
			ps.setInt(1, (int)id1);
			ps.setInt(2,(int)id2);
			rs = ps.executeQuery();
			if(rs.next())
		    {	
		    	ps.close();
		    	return true;
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	

}

