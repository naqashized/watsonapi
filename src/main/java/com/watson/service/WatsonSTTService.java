package com.watson.service;

/**
 * Created by user on 24/01/2017.
 */

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import com.ibm.watson.developer_cloud.http.HttpMediaType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.BaseRecognizeCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.*;
public class WatsonSTTService {

    private Logger log = LoggerFactory.getLogger(WatsonSTTService.class);
    private SpeechToText service;
    private String uploadPath = "src/main/resources/static/stt.wav";

    public WatsonSTTService(){
        service = new SpeechToText();
        service.setUsernameAndPassword("f69ea6aa-6c64-4ac5-965d-0594083536c2", "DviONNvdCNIN");
    }

    /*
    ** method to convert to text
     */
    public SpeechResults convert() throws UnsupportedAudioFileException {

        File audio = new File(uploadPath);
        SpeechResults transcript = service.recognize(audio).execute();

        System.out.println(transcript);
        return transcript;
    }

    /*
    ** method to upload file to predefined location
     */
    public SpeechResults uploadFile(MultipartFile file){
        SpeechResults result = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(uploadPath)));
                stream.write(bytes);
                stream.close();
                log.info( "You successfully uploaded ");
                result =  convert();
            } catch (Exception e) {
                log.info("You failed to upload " +  e.getMessage());
            }
        }
        return result;
    }
}
