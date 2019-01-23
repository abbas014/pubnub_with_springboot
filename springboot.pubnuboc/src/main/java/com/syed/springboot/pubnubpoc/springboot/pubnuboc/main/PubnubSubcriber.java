package com.syed.springboot.pubnubpoc.springboot.pubnuboc.main;

import java.util.Arrays;

import com.pubnub.api.PubNub;

public class PubnubSubcriber {
	public void subscribeToChannel(PubNub pubnub, String channelName) {
		pubnub.subscribe().channels(Arrays.asList(channelName)).execute();
	}

}
