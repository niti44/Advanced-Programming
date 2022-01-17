package com.example.demo.Car1.Repository;

import com.example.demo.Car1.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
