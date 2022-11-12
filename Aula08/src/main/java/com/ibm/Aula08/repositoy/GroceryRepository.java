package com.ibm.Aula08.repositoy;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ibm.Aula08.model.Grocery;

public interface GroceryRepository extends MongoRepository<Grocery, String> {
    
    @Query("{name:'?0'}")
    List<Grocery> findItemByName(String name);
    
    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
    List<Grocery> findAll(String category);
    
    public long count();

}