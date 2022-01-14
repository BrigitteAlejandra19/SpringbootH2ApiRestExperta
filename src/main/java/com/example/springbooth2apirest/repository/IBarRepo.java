package com.example.springbooth2apirest.repository;

import com.example.springbooth2apirest.entity.Bar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBarRepo extends JpaRepository<Bar, Integer> {
}
