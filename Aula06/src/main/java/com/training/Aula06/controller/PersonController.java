package com.training.Aula06.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.Aula06.model.PersonModel;
import com.training.Aula06.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {

	Logger logger = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/starting")
	public Map<String, String> getStarting() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "server it's works!");
		return map;
	}

	@PostMapping(path = "/person/new", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> addNewPerson(@RequestBody PersonModel person) {
		Map<String, String> map = new HashMap<String, String>();

		try {
			personRepository.save(person);
			map.put("status", "salvo com sucesso");
		} catch (Exception ex) {
			map.put("error", ex.toString());
		}

		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@PostMapping(path = "/person/news", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, String>> addNewPersons(@RequestBody List<PersonModel> persons) {
		Map<String, String> map = new HashMap<String, String>();

		for (PersonModel person : persons) {

			try {
				personRepository.save(person);
				map.put("status", person.getName()+" salvo com sucesso");
			} catch (Exception ex) {
				map.put("error", person.getName()+" "+ex.toString());
			}
		}
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@GetMapping("/person/deleteByID/{ID}")
	public Map<String, String> deleteByRequestNumber(@PathVariable int ID) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			personRepository.deletePerson(ID);
			map.put("status", "person removida com sucesso");
		} catch (Exception ex) {
			map.put("status", "erro ao remover a pessoa");
		}
		return map;
	}

	@GetMapping("/person/findbyID/{ID}")
	public List<PersonModel> findPersonsByID(@PathVariable int ID) {
		List<PersonModel> modelPersonList = new ArrayList<PersonModel>();
		modelPersonList.addAll(personRepository.findByPersonID(ID));
		return modelPersonList;
	}

	@GetMapping("/person/findall")
	public List<PersonModel> findPersons() {
		List<PersonModel> modelPersonList = new ArrayList<PersonModel>();
		modelPersonList.addAll(personRepository.findAll());
		return modelPersonList;
	}

	@DeleteMapping("/person/delete/{id}")
	public ResponseEntity<HttpStatus> deletePerson(@PathVariable("id") long id) {
		try {
			personRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(path = "/person/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonModel> updatePerson(@RequestBody PersonModel person) {
		Optional<PersonModel> personData = personRepository.findById(person.getID());

		if (personData.isPresent()) {
			PersonModel _person = personData.get();
			_person.setID(person.getID());
			_person.setAge(person.getAge());
			_person.setName(person.getName());
			return new ResponseEntity<>(personRepository.save(_person), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
