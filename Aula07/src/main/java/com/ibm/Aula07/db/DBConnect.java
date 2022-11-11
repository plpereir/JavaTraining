package com.ibm.Aula07.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.query.QueryBuilder;
import com.cloudant.client.api.query.QueryResult;
import com.cloudant.client.api.query.Selector;
import com.ibm.Aula07.controller.ResultsController;


import static com.cloudant.client.api.query.Expression.eq;
import static com.cloudant.client.api.query.Operation.and;

public class DBConnect {
    Logger logger = LoggerFactory.getLogger(ResultsController.class);

    public CloudantClient getCloudClient() {
        try {
            CloudantClient cloudantClient = ClientBuilder
                    .url(new URL(
                            "https://xxxx"))
                    .username("apikey-xxxx")
                    .password("xxxx")
                    .build();
            return cloudantClient;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            logger.error(e.toString());
            return null;
        }
    }

    public Database getCloudDatabase(String dbname) {
        return getCloudClient().database(dbname, false);
    }

    
    public Map<String, String> getStarting() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "server it's works!");
        logger.info("server it's works!");
        return map;
    }

    public List<String> getDataBases() {
        List<String> listDB = new ArrayList<String>();

        try {

            for (String x : getCloudClient().getAllDbs()) {
                logger.info(x);
                listDB.add(x);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error(e.toString());
            listDB.add(e.toString());
        }
        return listDB;
    }

    public Map<String, String> addDocument(@RequestBody Object document, String dbName) {
        Map<String, String> map = new HashMap<String, String>();

        try {
            String iD = getCloudDatabase(dbName).save(document).getId();
            map.put("ID_", iD);
            logger.info("created ID: " + iD);
            return map;
        } catch (Exception ex) {
            map.put("error", ex.toString());
            logger.error(ex.toString());
            return map;
        }

    }
    
    public Map<String, String> deleteDocument(@RequestBody Object document, String dbName) {
        Map<String, String> map = new HashMap<String, String>();
        try {
            String iD = getCloudDatabase(dbName).remove(document).getId();
            map.put("ID_", iD);
            logger.info("deleted ID: " + iD);
            return map;
        } catch (Exception ex) {
            map.put("error", ex.toString());
            logger.error(ex.toString());
            return map;
        }
    }

    public Object getDocument(String idDoc, String dbName) throws IOException {
        Object tmp = "";

        InputStream document = getCloudDatabase(dbName).find(idDoc);
        BufferedReader br = new BufferedReader(new InputStreamReader(document));
        String line = "";
        while ((line = br.readLine()) != null) {
            if (line.equalsIgnoreCase("quit")) {
                break;
            }
            tmp = tmp + line;
        }
        System.out.println(tmp);
        return tmp;
    }

    public List<Object> getAllDocuments(String dbName) throws IOException {
        List<String> listDocuments = getCloudDatabase(dbName).getAllDocsRequestBuilder().build().getResponse().getDocIds();
        List<Object> listdocs = new ArrayList<Object>();
        for (String doc : listDocuments) {
            System.out.println("All my docs Id : " + doc);
            listdocs.add(getDocument(doc, dbName));
        }
        return listdocs;
    }      
    
    public List<Object> searchDocuments(String dbName, String city, String type, String title) throws IOException {
        
        Selector selector = and(eq("type", type),eq("city", city));

        QueryResult<Object> newtenant = getCloudDatabase(dbName).query(new QueryBuilder(selector).build(), Object.class);
        List<Object> listdocs = new ArrayList<Object>();
        
        for (Object doc : newtenant.getDocs()) {
            if(title.length()<0)
            {
                System.out.println("All my docs Id : " + doc);
                listdocs.add(doc);                   
            }else
            {
                if (doc.toString().indexOf(title)!=-1)
                {
                    System.out.println("Filter my docs Id : " + doc);
                    listdocs.add(doc);
                }              
            }
        }
        return listdocs;
    }  
}
