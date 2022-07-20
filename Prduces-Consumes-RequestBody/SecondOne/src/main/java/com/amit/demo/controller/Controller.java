package com.amit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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
	
	@RequestMapping(path="/getAlien", 
			produces = {"application/json","application/xml"})
	public List<Alien> getAlien(){
		return alienDao.findAll();
	}
	
	@RequestMapping("/download")
	public String getAlienDownloaded() throws IOException{
		InputStream in = new URL("file:///C:\\Users\\amin0004\\Documents\\geoIp.txt").openStream();
		Files.copy(in, Paths.get("C:\\Users\\amin0004\\Documents\\download\\download.txt"), StandardCopyOption.REPLACE_EXISTING);
		return "File Downloaded";
	}
	
	@RequestMapping(path="/getAlien/{id}", 
			produces = {"application/json","application/xml"})
	public Alien getAlien(@PathVariable("id") int id) {
		return alienDao.findById(id).orElse(new Alien(200,"Doesn't Exists"));
	}
	
	@GetMapping(path="/searchAlien/{id}", 
			produces = "application/json")
	public Alien searchAlien(@PathVariable("id") int id) {
		return alienDao.findById(id).orElse(new Alien(404,"Not Found"));
	}
	
	@DeleteMapping(path="/deleteAlien/{id}", 
			produces = "application/json")
	public Alien deleteAlien(@PathVariable("id") int id) {
		alienDao.deleteById(id);
		return new Alien(200,"Alien with Id:"+id+" got Deleted");
	}
	
	@PutMapping(path="/updateAlien", 
			produces = "application/json",
			consumes = {"application/json","application/xml"})
	public Alien updateAlien(@RequestBody Alien alien) {
		alienDao.deleteById(alien.getId());
		alienDao.save(alien);
		return alien;
	}
	
	@PostMapping(path="/addAlien", 
			produces = "application/json",
			consumes = {"application/json","application/xml"})
	public Alien addAlien(@RequestBody Alien alien) {
		alienDao.save(alien);
		return alien;
	}
}






