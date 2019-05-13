package com.beniregev.bigpandahomeexercise.services;

import com.beniregev.bigpandahomeexercise.models.StreamEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

@Component
public class StreamProcessService {
    @Value("${stream.generator.exe.path}")
    String path;

    @Autowired
    CountersService countService;

    final ObjectMapper jsonMapper = new ObjectMapper();

    @PostConstruct
    public void init() {
        try {
            Process process = Runtime.getRuntime()
                    .exec(path);

            EventStream eventStream =
                    new EventStream(process.getInputStream(), streamEvent -> {
                        if(streamEvent != null) {
                            countService.countTypes(streamEvent.getType());
                            countService.countWords(streamEvent.getData());
                        }
                    });
            Executors.newSingleThreadExecutor().submit(eventStream);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    private  class EventStream implements Runnable {
        private InputStream inputStream;
        private Consumer<StreamEvent> consumer;

        public EventStream(InputStream inputStream, Consumer<StreamEvent> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .map(s -> {
                        StreamEvent streamEvent = null;
                        try {
                            streamEvent = jsonMapper.readValue(s, StreamEvent.class);
                        }catch(Exception e) {
                            //bad JSON String. Skip it
                        }
                        return streamEvent;
                    }).forEach( consumer);
        }
    }
}
