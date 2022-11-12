package com.ibm.Aula08.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.Aula08.model.Grocery;
import com.ibm.Aula08.repositoy.GroceryRepository;

@RestController
@RequestMapping("/api/grocery")
public class GroceryController {
	Logger logger = LoggerFactory.getLogger(Grocery.class);

	@Autowired
	private GroceryRepository groceryRepository;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> addDocuments(@RequestBody List<Grocery> documents) {
		Map<String, String> map = new HashMap<String, String>();
		List<Grocery> list = new ArrayList<Grocery>();
		try {
			list.addAll(groceryRepository.saveAll(documents));
			for (Grocery grocery : list) {
				map.put(grocery.getId(), grocery.toString());
				logger.info(grocery.toString());
			}
		} catch (Exception ex) {
			map.put("error", ex.toString());
			logger.error(ex.toString());
		}

		return map;
	}

	@GetMapping("/getall")
	public List<Grocery> getAllDocuments() {
		try {
			return groceryRepository.findAll();
		} catch (Exception ex) {
			logger.error(ex.toString());
			return null;
		}
	}

	@GetMapping("/count")
	public Map<String, String> findCountOfGroceryItems() {
		Map<String, String> map = new HashMap<String, String>();
		try {
			long count = groceryRepository.count();
			map.put("Number of documents in the collection", Long.toString(count));
			logger.info("Number of documents in the collection: " + Long.toString(count));
		} catch (Exception ex) {
			logger.error(ex.toString());
			map.put("error", ex.toString());
		}
		return map;
	}

	@GetMapping("/get/{key}/{field}")
	public List<Grocery> getGroceryItem(@PathVariable String key, @PathVariable String field) {
		List<Grocery> list = new ArrayList<Grocery>();
		try {
			switch (field) {
			case "id":
				Optional<Grocery> tmp = groceryRepository.findById(key);
				Grocery grocery = new Grocery(tmp.get().getId(), tmp.get().getName(), tmp.get().getQuantity(),
						tmp.get().getCategory());
				list.add(grocery);
				break;
			case "name":
				list.addAll(groceryRepository.findItemByName(key));
				break;
			default:
				list.addAll(groceryRepository.findAll(key));
			}
			logger.info(list.toString());
		} catch (Exception ex) {
			logger.error(ex.toString());
		}

		return list;
	}
	
	@DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> deleteDocuments(@RequestBody List<Grocery> documents)
	{
		Map<String, String> map = new HashMap<String, String>();
		try
		{
			groceryRepository.deleteAll(documents);			
			logger.info("the documents list has been deleted!");
			map.put("successful", "the documents list has been deleted!");
		}catch(Exception ex)
		{			
			map.put("error", ex.toString());
			logger.error(ex.toString());
		}
		return map;
	}
	
	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, String> updateDocuments(@RequestBody List<Grocery> documents)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		try
		{
			groceryRepository.saveAll(documents);
			logger.info("the documents list has been updated!");
			map.put("successful", "the documents list has been updated!");
			
		}catch(Exception ex)
		{
			map.put("error", ex.toString());
			logger.error(ex.toString());			
		}		
		return map;
	}

	

}
