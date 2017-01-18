package com.alchemy.language.service;

import com.alchemy.language.model.AlchemyLanguageResult;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.*;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 17/01/2017.
 */
public class AlchemyLanguageService {

    AlchemyLanguage service;

    public AlchemyLanguageService(){
        service = new AlchemyLanguage();
        init();
    }

    private void init(){
        service.setApiKey("2b5994124840aa345d5aaf3a348555e4873bd26b");
    }

    public AlchemyLanguageResult getResults(String text){
        AlchemyLanguageResult results = new AlchemyLanguageResult();
        Map<String, Object> params = new HashMap<String, Object>();

        params.put(AlchemyLanguage.TEXT, text);

        // get keywords
        Keywords keywords = service.getKeywords(params).execute();
        results.setKeywords(keywords);
        System.out.println("Sentiment: " + keywords);

        // get entities
        Entities entities = service.getEntities(params).execute();
        results.setEntities(entities);
        System.out.println("Entities: " + entities);

        // get concepts
        Concepts concepts = service.getConcepts(params).execute();
        results.setConcepts(concepts);
        System.out.println("concepts: " + concepts);

        // get relations
        SAORelations relations = service.getRelations(params).execute();
        results.setRelations(relations);
        System.out.println("concepts: " + relations);

        // get dates
        Dates dates = service.getDates(params).execute();
        results.setDates(dates);
        System.out.println("concepts: " + relations);



        return results;
    }
}
