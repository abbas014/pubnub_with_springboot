package com.syed.springboot.pubnubpoc.springboot.pubnuboc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.syed.springboot.pubnubpoc.springboot.pubnuboc.main.*;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Application {
	@RequestMapping("/")
	public void pubnubInfo() {
		PNConfiguration pnConfiguration = new PNConfiguration();
	    pnConfiguration.setSubscribeKey("demo");
	    pnConfiguration.setPublishKey("demo");
	     
	    PubNub pubnub = new PubNub(pnConfiguration);
	    PubnubChannel gc = new PubnubChannel();
	 
	    //final String channelName = "awesomeChannel";
	    final String channelName = gc.getChannelName();
	 
	    // create message payload using Gson
	    final JsonObject messageJsonObject = new JsonObject();
	    messageJsonObject.addProperty("msg", "hello");
	 
	    System.out.println("Message to send: " + messageJsonObject.toString());
	 
	   PubnubPublisher pc = new PubnubPublisher();
	   pc.publishMessage(pubnub, channelName, messageJsonObject);
	   
	   PubnubSubcriber ps = new PubnubSubcriber();
	   ps.subscribeToChannel(pubnub, channelName);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

