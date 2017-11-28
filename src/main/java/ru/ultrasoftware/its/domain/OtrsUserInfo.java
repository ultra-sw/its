package ru.ultrasoftware.its.domain;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OtrsUserInfo {

    @JsonProperty("SessionData")
    private List sessionData;
//	@JsonProperty
    Map<String, String> hashmap = new HashMap<String, String>();
    ObjectMapper mapper = new ObjectMapper();
    public Object getsessionData() {
        return sessionData;
    }

    public void outputList() {
    	for(int i=0;i<sessionData.size();i++){
    	    System.out.println(sessionData.get(i));
    	    try {
    	    hashmap = mapper.readValue(sessionData.get(i).toString(), new TypeReference<Map<String, String>>(){});
    	
    	    } catch (IOException e) {
    			e.printStackTrace();
    	    }
    	}
    }
    
//    @JsonAnyGetter
    public Map<String, String> getKeyvalues() {
        return hashmap;
    }
}
