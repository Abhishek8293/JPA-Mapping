package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Laptop;

@Repository
public interface LaptopRepository  extends JpaRepository<Laptop, Integer>{

}
