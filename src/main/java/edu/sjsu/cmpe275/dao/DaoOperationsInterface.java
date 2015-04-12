package edu.sjsu.cmpe275.dao;

import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;

public interface DaoOperationsInterface {
	// DAO functions for Player
	public Player getPlayer(int id);
	public boolean setPlayer(Player p);
	// DAO functions for Sponsor	
	public Sponsor getSponsor(int id);
	public boolean setSponsor(Sponsor s);
	// DAO functions for Address
	public Address getAddress(int id);
	public boolean setAddress(Address a);

}
