package com.watson.controller;

import com.watson.model.Transcript;
import com.watson.service.WatsonTTSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Map;

/**
 * Created by user on 19/01/2017.
 */

@Controller
@RequestMapping("/watson/tts/")
public class TTSController {

    WatsonTTSService service = new WatsonTTSService();
    private Logger log = LoggerFactory.getLogger(STTController.class);

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("text", new Transcript());
        return "tts";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String results(@ModelAttribute Transcript item, Map<String,Object> model) throws IOException {
        log.info("text =>"+item.getText());
        String audio = service.convert(item.getText());
        model.put("audio", audio);
        return "tts";
    }
}
