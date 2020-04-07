package sa.gov.sfd.leave.infrastructure.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonConverter {


    public Map getMap(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Map.class);

    }

    public JsonNode getJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readTree(json);
    }

}
