package com.language.controller;

import java.util.HashMap;
import java.util.Map;

import com.alchemy.language.model.AlchemyLanguageResult;
import com.alchemy.language.model.Text;
import com.alchemy.language.service.AlchemyLanguageService;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyLanguage;
import com.ibm.watson.developer_cloud.alchemy.v1.model.DocumentSentiment;
import com.ibm.watson.developer_cloud.alchemy.v1.model.Entities;
import com.ibm.watson.developer_cloud.alchemy.v1.model.TypedRelations;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LanguageController {

    AlchemyLanguageResult results = new AlchemyLanguageResult();

	@RequestMapping("/")
	public String index(Map<String, Object> model) {
        model.put("text", new Text());
		return "language";
	}

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String results(@ModelAttribute Text item, Map<String, Object> model) {

        System.out.println("Text is "+item.getText());
        results = new AlchemyLanguageService().getResults(item.getText());
        model.put("results", results);
        model.put("text", item);
		return "language";
	}

}