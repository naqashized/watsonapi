package com.alchemy.language.model;

import com.ibm.watson.developer_cloud.alchemy.v1.model.*;

/**
 * Created by user on 17/01/2017.
 */
public class AlchemyLanguageResult {

    private Entities entities;
    private Keywords keywords;
    private Concepts concepts;
    private SAORelations relations;
    private Dates dates;

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

    public Concepts getConcepts() {
        return concepts;
    }

    public void setConcepts(Concepts concepts) {
        this.concepts = concepts;
    }

    public SAORelations getRelations() {
        return relations;
    }

    public void setRelations(SAORelations relations) {
        this.relations = relations;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
