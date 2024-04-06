package com.ocado.basket;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonLoader {


    public static Map<String, List<String>> loadFromJson(String absolutePathToConfigFile){
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String,List<String>> map;

        try{
            map = objectMapper.readValue(new File(absolutePathToConfigFile),Map.class);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }


    public static List<String> loadProductsFromJson(String absolutePathToConfigFile){
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> list = new ArrayList<>();

        try{
            JsonNode root = objectMapper.readTree(new File(absolutePathToConfigFile));

            Iterator<JsonNode> elements = root.elements();
            while (elements.hasNext()) {
                JsonNode element = elements.next();
                list.add(element.asText());
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
