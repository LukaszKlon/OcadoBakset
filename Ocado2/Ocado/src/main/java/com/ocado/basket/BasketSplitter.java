package com.ocado.basket;

import java.util.List;
import java.util.Map;

public class BasketSplitter {
    private final Map<String, List<String>> map;

    public BasketSplitter(String absolutePathToConfigFile) {
        map = JsonLoader.loadFromJson(absolutePathToConfigFile);
    }

    public Map<String, List<String>> split(List<String> items) {
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(items,map);
        return greedyAlgorithm.predictSets();
    }

    public Map<String, List<String>> split(String absolutePathToProducts) {
        return split(JsonLoader.loadProductsFromJson(absolutePathToProducts));
    }
}

