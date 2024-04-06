package com.ocado.basket;

import java.util.*;
import java.util.stream.Collectors;

public class GreedyAlgorithm {

    private final Set<String> productSet;
    private final Map<String, Set<String>> deliverproduct;
    private final Map<String, List<String>> result;

    public GreedyAlgorithm(List<String> products, Map<String, List<String>> delivery) {
        PrepareSets prepareSets = new PrepareSets(products, delivery);
        this.productSet = prepareSets.createProductSet();
        this.deliverproduct = prepareSets.mapReverse();
        this.result = new HashMap<>();
    }

    public Map<String, List<String>> predictSets() {

        while (!productSet.isEmpty()) {
            Set<String> x = findBestSet();
            productSet.removeAll(x);
        }

        return result;
    }


    private Set<String> findBestSet(){
        int numberOfCorrectValues = 0;
        Set<String> bestResult = new HashSet<>();
        Set<String> temporarySet;
        Set<String> samePart;
        String saveKey = null;

        for (String key: deliverproduct.keySet()) {
            temporarySet = deliverproduct.get(key);
            samePart = productSet.stream().filter(temporarySet::contains).collect(Collectors.toSet());
//
            if (numberOfCorrectValues < samePart.size()){
                saveKey = key;
                bestResult = samePart;
                numberOfCorrectValues = samePart.size();
            }
        }

        if(saveKey != null){
            deliverproduct.remove(saveKey);
            result.put(saveKey,bestResult.stream().toList());
        }

        return bestResult;
    }

}
