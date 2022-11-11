package com.ibm.Aula07.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.ibm.Aula07.db.DBConnect;
import com.ibm.Aula07.model.Opportunity;

@RestController
@RequestMapping("/api/opportunity")
public class OpportunityController {
    Logger logger = LoggerFactory.getLogger(OpportunityController.class);

    private DBConnect db = new DBConnect();
    private final static String dbName = "fireflaidb-opportunity";
    private Gson gson = new Gson();

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> addDocument(@RequestBody List<Opportunity> documents) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> mapReturn = new HashMap<String, String>();
        int i = 1;
        for (Opportunity document : documents) {
            map.putAll(db.addDocument(document, dbName));
            String id = map.get("ID_");
            mapReturn.put("item_" + i, "Created ID_" + id);
            map.clear();
            i++;
        }
        return mapReturn;
    }

    @DeleteMapping(path = "/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> deleteDocument(@RequestBody List<Opportunity> documents) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> mapReturn = new HashMap<String, String>();
        int i = 1;
        for (Opportunity document : documents) {
            map.putAll(db.deleteDocument(document, dbName));
            String id = map.get("ID_");
            mapReturn.put("item_" + i, "Deleted ID_" + id);
            map.clear();
            i++;
        }
        return mapReturn;
    }

    public Opportunity getDocument(String idDoc) throws IOException {
        return gson.fromJson(db.getDocument(idDoc, dbName).toString(), Opportunity.class);
    }

    @GetMapping("/getall")
    public List<Opportunity> getAllDocuments() throws IOException {
        List<Opportunity> list = new ArrayList<Opportunity>();
        for (Object o : db.getAllDocuments(dbName)) {
            list.add(gson.fromJson(o.toString(), Opportunity.class));
        }
        return list;
    }
    
    @GetMapping("/search/{city}/{type}/{title}")
    public List<Object> searchDocuments(@PathVariable String city, @PathVariable String type, @PathVariable String title) throws IOException {
        return db.searchDocuments(dbName, city, type, title);
    }
  

}
