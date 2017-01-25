package com.watson.controller;

import com.watson.model.Transcript;
import com.watson.service.WatsonSTTService;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by user on 19/01/2017.
 */

@Controller
@RequestMapping("/watson/stt/")
public class STTController {

    WatsonSTTService service = new WatsonSTTService();
    private Logger log = LoggerFactory.getLogger(STTController.class);

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("text", new Transcript());
        return "stt";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, Map<String,Object> model) {
        log.info("file name =>"+file.getOriginalFilename());
        WatsonSTTService service = new WatsonSTTService();
        SpeechResults results = service.uploadFile(file);
        model.put("result", results.getResults().get(0).getAlternatives().get(0).getTranscript());
        return "transcript";
    }
}
