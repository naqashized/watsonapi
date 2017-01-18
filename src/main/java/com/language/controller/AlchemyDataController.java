package com.language.controller;

import com.alchemy.language.model.Text;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by user on 17/01/2017.
 */

@Controller
@RequestMapping("/alchemy/data/")
public class AlchemyDataController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("text", new Text());
        return "data";
    }

}
