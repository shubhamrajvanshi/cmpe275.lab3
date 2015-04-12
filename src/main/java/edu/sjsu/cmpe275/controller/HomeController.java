package edu.sjsu.cmpe275.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sjsu.cmpe275.model.Address;
import edu.sjsu.cmpe275.model.Player;
import edu.sjsu.cmpe275.model.Sponsor;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	Player p1;
	Address a1;
	Sponsor s1;
	Address a2;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicLong pcounter = new AtomicLong();
    private final AtomicLong scounter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Guest") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
  //***********Player*********
    
    @RequestMapping(value="/player", method=RequestMethod.POST)
    public String createPlayer(@RequestParam(value="fname") String fname,
    					@RequestParam(value="lname") String lname,
    					@RequestParam(value="email") String email,
    					@RequestParam(value="street") String street,
    					@RequestParam(value="city") String city,
    					@RequestParam(value="state") String state,
    					@RequestParam(value="zip") String zip,
    					@RequestParam(value="sponsorid") long sponsorid) {
    	System.out.println(fname);
    	System.out.println(lname);
    	System.out.println(email);
        p1=  new Player(pcounter.incrementAndGet(), fname, lname, email);
        System.out.println(p1.toString());
        return p1.toString();
    }
    
    @RequestMapping(value="/player/{id}", method=RequestMethod.GET)
    public String getPlayer(@PathVariable long id) {
    	System.out.println(id);
        if(p1.getId()==id)
        	return p1.toString();
        return null;
    }
    
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
    	System.out.println(fname);
    	System.out.println(lname);
    	System.out.println(email);
        if(p1.getId()==id){
        		p1=  new Player(id, fname, lname, email);
        		System.out.println(p1.toString());
        		return p1.toString();
        }
        return null;
    }
    
    @RequestMapping(value="/player/{id}", method=RequestMethod.DELETE)
    public String deletePlayer(@PathVariable long id) {
    	System.out.println(id);
        if(p1.getId()==id)
        	return (p1.toString() + "deleted");
        return null;
    }
    
    //***********Sponsor*********
    
    @RequestMapping(value="/sponsor", method=RequestMethod.POST)
    public String createSponsor(@RequestParam(value="name") String name,
    					@RequestParam(value="description") String description,
    					@RequestParam(value="street") String street,
    					@RequestParam(value="city") String city,
    					@RequestParam(value="state") String state,
    					@RequestParam(value="zip") String zip) {
    	System.out.println(name);
    	System.out.println(description);
    	
    	a2 = new Address(street, city, state, zip);
    	System.out.println(a2.toString());
    	
        s1=  new Sponsor(scounter.incrementAndGet(), name, description, a2);
        System.out.println(s1.toString());
        return s1.toString();
    }
    
    @RequestMapping(value="/sponsor/{id}", method=RequestMethod.GET)
    public String getSponsor(@PathVariable long id) {
    	System.out.println(id);
        if(s1.getId()==id)
        	return s1.toString();
        return null;
    }
    
    @RequestMapping(value="/sponsor/{id}", method=RequestMethod.POST)
    public String updatePlayer(@PathVariable long id,
			    		@RequestParam(value="name") String name,
						@RequestParam(value="description") String description,
						@RequestParam(value="street") String street,
						@RequestParam(value="city") String city,
						@RequestParam(value="state") String state,
						@RequestParam(value="zip") String zip) {
    	
    	System.out.println(name);
    	System.out.println(description);
    	
    	a2 = new Address(street, city, state, zip);
    	System.out.println(a2.toString());
    	
        if(s1.getId()==id){
        		s1=  new Sponsor(id, name, description, a2);
        		System.out.println(s1.toString());
        		return s1.toString();
        }
        return null;
    }
    
    @RequestMapping(value="/sponsor/{id}", method=RequestMethod.DELETE)
    public String deleteSponsor(@PathVariable long id) {
    	System.out.println(id);
        if(s1.getId()==id)
        	return (s1.toString() + "deleted");
        return null;
    }
    
    //*************Opponents*********
    @RequestMapping(value="/opponents/{id1}/{id2}", method=RequestMethod.PUT)
    public String addOpponent(@PathVariable long id1,@PathVariable long id2){
    	
    	System.out.println(id1);
    	System.out.println(id2);
    	
    	if(id1 == p1.getId()){	//check for id2 as well
    		System.out.println("Opponent Added");
    		return "Opponent Added";
    	}
    	return null;
    }
    
    @RequestMapping(value="/opponents/{id1}/{id2}", method=RequestMethod.DELETE)
    public String deleteOpponent(@PathVariable long id1,@PathVariable long id2){
    	
    	System.out.println(id1);
    	System.out.println(id2);
    	
    	if(id1 == p1.getId()){	//check for id2 as well
    		System.out.println("Opponent Deleted");
    		return "Opponent Deleted";
    	}
    	return null;
    }
}
