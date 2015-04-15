package edu.sjsu.cmpe275.dao;


import java.util.List;

import org.springframework.stereotype.Component;

import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;

@Component
public class MongoImplementation implements DaoOperationsInterface{

	public Player getPlayer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPlayer(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

	public Sponsor getSponsor(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setSponsor(Sponsor s) {
		// TODO Auto-generated method stub
		return false;
	}

	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setAddress(Address a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Player getPlayer(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sponsor getSponsor(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddress(long id,String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> getOpponent(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setOpponent(long id1, long id2) {
		// TODO Auto-generated method stub
		return false;
	}
	
			
	

}
