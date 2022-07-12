package com.amit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.amit.demo.model.*;
import com.amit.demo.dao.AlienDAO;

@RestController
public class Controller {
	
	@Autowired
	AlienDAO alienDao;
	
	@RequestMapping("/")
	public String home() {
		return "Home";
	}
	
	@RequestMapping("/getAlien")
	public List<Alien> getAlien(){
		return alienDao.findAll();
	}
	
	@RequestMapping("/getAlien/{id}")
	public Alien getAlien(@PathVariable("id") int id) {
		return alienDao.findById(id).orElse(new Alien(200,"Doesn't Exists"));
	}
	
	@RequestMapping("/searchAlien/{id}")
	public Alien searchAlien(@PathVariable("id") int id) {
		return alienDao.findById(id).orElse(new Alien(404,"Not Found"));
	}
	
	@RequestMapping("/deleteAlien/{id}")
	public Alien deleteAlien(@PathVariable("id") int id) {
		alienDao.deleteById(id);
		return new Alien(200,"Alien with Id:"+id+" got Deleted");
	}
	
	@RequestMapping("/updateAlien")
	public Alien updateAlien(Alien alien) {
		alienDao.deleteById(alien.getId());
		alienDao.save(alien);
		return alien;
	}
	
	@RequestMapping("/addAlien")
	public Alien addAlien(Alien alien) {
		alienDao.save(alien);
		return alien;
	}
}






