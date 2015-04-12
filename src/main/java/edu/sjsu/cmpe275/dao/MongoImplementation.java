package edu.sjsu.cmpe275.dao;


import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;

@Component
public class MongoImplementation implements DaoOperationsInterface{

	@Override
	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
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
	
			
	

}
