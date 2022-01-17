package com.example.demo.Car1.Repository;

import com.example.demo.Car1.Entity.Car1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Car1Repository extends JpaRepository<Car1, Integer>{
        List<Car1> findByModelName(String modelName);
        List<Car1> findByColour(String colour);
        List<Car1> findByColourAndModelName(String colour, String modelName);
        List<Car1> findByColourOrModelName(String colour, String modelName);
        List<Car1> findByModelNameIgnoreCase(String modelName);
        List<Car1> findTop3ByModelName(String modelName);
        List<Car1> findByModelNameOrderByPriceAsc(String modelName);

}
