package com.training.Aula06.repository;

import com.training.Aula06.model.PersonModel;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository  extends JpaRepository<PersonModel, Long>{

    @Modifying
    @Query(value =  "INSERT INTO PERSON (ID, NAME, AGE) VALUES(:ID, :name, :age)", nativeQuery = true)
    @Transactional
    void saveCustom(@Param("ID") int ID,
    				@Param("name") String name, 
    				@Param("age") int age);
    
    @Query(value =  "SELECT * FROM PERSON where ID = :ID", nativeQuery = true)
    List<PersonModel> findByPersonID(@Param("ID") int ID);
    
    @Modifying
    @Query(value =  "DELETE FROM PERSON  WHERE ID = :ID", nativeQuery = true)
    @Transactional
    void deletePerson(@Param("ID") int ID);
}
