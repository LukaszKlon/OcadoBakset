package com.ocado.basket;

import java.util.*;

public class PrepareSets {

    private final List<String> products;
    private final Map<String,List<String>> deliverymap;

    public PrepareSets(List<String> products,Map<String,List<String>> productsdelivery){
        this.products = products;
        this.deliverymap = productsdelivery;
    }

    public Set<String> createProductSet(){

        Set<String> set = new HashSet<>(products);
        return set;
    }

    public Map<String,Set<String>> mapReverse(){
        Map<String,List<String>> productsdeliver = deliverymap;
        Map<String,Set<String>> deliveryproducts = new HashMap<>();

        for (String key: productsdeliver.keySet()) {
            if (products.contains(key)){
                prepareReverseMap(deliveryproducts,productsdeliver.get(key),key);
            }
        }

        return deliveryproducts;
    }

    private void prepareReverseMap(Map<String,Set<String>> deliveryproducts,List<String> values,String key){
        for (String value: values) {
            if (!deliveryproducts.containsKey(value)){
                deliveryproducts.put(value,new HashSet<>());
            }
            deliveryproducts.get(value).add(key);
        }
    }
}
