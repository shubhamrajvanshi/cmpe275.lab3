package edu.sjsu.cmpe275.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


//import org.springframework.web.bind.annotation.RestController;
import edu.sjsu.cmpe275.dao.DaoOperationsInterface;
import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;

/**
 * Handles requests for the application home page.
 */

//import scala.annotation.meta.getter;

//Controller class

@Controller
public class HomeController {
	//Counters for player n sponsor id
//	private final AtomicLong counter = new AtomicLong();
//  private final AtomicLong pcounter = new AtomicLong();
//  private final AtomicLong scounter = new AtomicLong();
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	DaoOperationsInterface mysqlImplementation;
	
	Player p1;
	Sponsor s1,s2;
	Address a1;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
	return "home";	
		}
  //Create a player
  @RequestMapping(value="/player", method=RequestMethod.POST)
  @ResponseBody
  public Player createPlayer(@RequestParam(value="fname") String fname,
  					@RequestParam(value="lname") String lname,
  					@RequestParam(value="email") String email,
  					@RequestParam(value="description") String description,
  					@RequestParam(value="street") String street,
  					@RequestParam(value="city") String city,
  					@RequestParam(value="state") String state,
  					@RequestParam(value="zip") String zip,
  					@RequestParam(value="sponsor") long sponsorid){

  	a1=new Address(street,city,state,zip);
  	s2 = mysqlImplementation.getSponsor(sponsorid);
  	long id = System.currentTimeMillis();
  	p1=  new Player(id,fname,lname,email,description,a1,s2);
  		if(mysqlImplementation.setPlayer(p1)) 
  			return mysqlImplementation.getPlayer(id);
  	//System.out.println(p1.toString());
      return null;
 	}

  @RequestMapping(value="/player/{id}", method=RequestMethod.GET)
  @ResponseBody
  public Player getPlayer(@PathVariable long id) {
  	System.out.println(id);
  	p1=mysqlImplementation.getPlayer(id);
      if(p1.getId()==id)
      	return p1;
      return null;
  }
  
  //get a player
  @RequestMapping(value="/cmpe275/{id}", method=RequestMethod.GET)
  public String getcPlayer(@PathVariable long id) {
  	System.out.println(id);
  	p1=mysqlImplementation.getPlayer(id);
      if(p1.getId()==id)
      	return p1.toString();
      return null;
  }
  
  //update a player
  @RequestMapping(value="/player/{id}", method=RequestMethod.POST)
  public String updatePlayer(@PathVariable long id,
  	    					@RequestParam(value="fname") String fname,
  	    					@RequestParam(value="lname") String lname,
  	    					@RequestParam(value="email") String email,
  	    					@RequestParam(value="street") String street,
  	    					@RequestParam(value="city") String city,
  	    					@RequestParam(value="state") String state,
  	    					@RequestParam(value="zip") String zip,
  	    					@RequestParam(value="sponsorid") long sponsorid) {
  
  		if(p1.getId()==id){
  	        		System.out.println(p1.toString());
  	        		return p1.toString();
  	        }
  	        return null;
  	    }
 

  //delete a sponsor
  @RequestMapping(value="/player/{id}", method=RequestMethod.DELETE)
  public String deletePlayer(@PathVariable long id) {
  	System.out.println(id);
      if(p1.getId()==id)
      	return (p1.toString() + "deleted");
      return null;
  }
  
  
  //create a sponsor
  @RequestMapping(value="/sponsor", method=RequestMethod.POST)
  @ResponseBody
  public Sponsor createSponsor(@RequestParam(value="name") String name,
			@RequestParam(value="description") String description,
			@RequestParam(value="street") String street,
			@RequestParam(value="city") String city,
			@RequestParam(value="state") String state,
			@RequestParam(value="zip") String zip){

  	Address a1=new Address(street,city,state,zip);
  	long id = (long)System.currentTimeMillis();
  	//s1=mysqlImplementation.getSponsor(id);
  	s1 = new Sponsor(id,name,description,a1);	
  	if(mysqlImplementation.setSponsor(s1))
  	{
  		return mysqlImplementation.getSponsor(id);
  	}
  	
      return null;

  	}
  
  //get a sponsor
  @RequestMapping(value="/sponsor/{id}", method=RequestMethod.GET)
  @ResponseBody
  public Sponsor getSponsor(@PathVariable long id) {
  	System.out.println(id);
  	s1= mysqlImplementation.getSponsor(id);
      if(s1.getId()==id)
      	return s1;
      return null;
  }
  
  //update a sponsor
  @RequestMapping(value="/sponsor/{id}", method=RequestMethod.POST)
  public String updateSponsor(@RequestParam(value="name") String name,
			@RequestParam(value="description") String description,
			@RequestParam(value="street") String street,
			@RequestParam(value="city") String city,
			@RequestParam(value="state") String state,
			@RequestParam(value="zip") String zip){

  		    		return s1.toString();
  	    }
 

  //delete a sponsor
  @RequestMapping(value="/sponsor/{id}", method=RequestMethod.DELETE)
  public String deleteSponsor(@PathVariable long id) {
  	System.out.println(id);
      if(s1.getId()==id)
      	return (s1.toString() + "deleted");
      return null;
  }

  //add opponent
  @RequestMapping(value="/opponents/{id1}/{id2}",method=RequestMethod.PUT)
  @ResponseBody
  public String addOpponent(@PathVariable(value="id1") long id1,
  						@PathVariable(value="id2") long id2) {
  	if(mysqlImplementation.setOpponent(id1, id2))
  	{
  		return "Opponent Added";
  	}	
  return "Opponent Added";
  }
  //delete opponent
//  @RequestMapping(value="opponents/{id1}/{id2}", method= RequestMethod.DELETE)
//  public String deleteOpponent(@PathVariable long id2){
//		
//  	return "Opponent deleted";
//  	
//  }
  
}