package com.watson.service;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

import java.io.*;
import java.util.Random;

/**
 * Created by user on 19/01/2017.
 */
public class WatsonTTSService {

    TextToSpeech service;

    public WatsonTTSService(){
        service = new TextToSpeech();
        service.setUsernameAndPassword("20a1b2e3-602b-447d-aa1d-29459d7e2f73", "G2ozhf68N1Kz");
    }

    public String convert(String text) throws IOException {
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        String fileName = "tts.wav";
        Voice voice = new Voice("en-US_MichaelVoice", "male", "en-US");
        InputStream voices = service.synthesize(text, voice).execute();
        OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/main/resources/static/"+fileName,false));
        int token = -1;

        while((token = voices.read()) != -1)
        {
            bufferedOutputStream.write(token);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        voices.close();
        System.out.println("file saved named as audio-"+randomInt);
        return fileName;
    }
}
