package edu.sjsu.cmpe275.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;
@Component
public interface DaoOperationsInterface {
	// DAO functions for Player
	public Player getPlayer(long id);
	public boolean setPlayer(Player p);
	// DAO functions for Sponsor	
	public Sponsor getSponsor(long id);
	public boolean setSponsor(Sponsor s);
	// DAO functions for Address
	public Address getAddress(long id, String type );
	public boolean setAddress(Address a);
	public List<Integer> getOpponent(long id);
	public boolean isOpponent(long id1, long id2);
	public boolean setOpponent(long id1, long id2);
	// DAO delete functions
	public boolean deletePlayer(long id);
	public boolean deleteSponsor(long id);
	public boolean deleteOpponent(long id);

}
