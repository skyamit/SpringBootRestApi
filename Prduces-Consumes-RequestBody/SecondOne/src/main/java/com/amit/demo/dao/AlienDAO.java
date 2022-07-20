package com.amit.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amit.demo.model.Alien;

public interface AlienDAO extends JpaRepository<Alien,Integer>{

}
