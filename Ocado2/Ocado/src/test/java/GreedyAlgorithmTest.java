import com.ocado.basket.GreedyAlgorithm;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GreedyAlgorithmTest {

    @Test
    void predictSets() {
        List<String> products = List.of("Garden Chair","Espresso Machine","Carrots", "Cold Beer", "Steak","Carrots", "Cold Beer", "Steak","AA Battery");
        Map<String, List<String>> productsDelivery = new HashMap<>();
        productsDelivery.put("Carrots", List.of( "Click&Collect"));
        productsDelivery.put("Cold Beer", List.of("Express delivery"));
        productsDelivery.put("Steak", List.of("Express delivery", "Click&Collect"));
        productsDelivery.put("AA Battery", List.of( "Courier"));
        productsDelivery.put("Espresso Machine", List.of("Click&Collect", "Courier"));
        productsDelivery.put("Garden Chair", List.of("Courier","Express delivery"));

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(products,productsDelivery);
        Map<String, List<String>> result = greedyAlgorithm.predictSets();

        Set<String> expectedExpress = new HashSet<>(Arrays.asList("Cold Beer","Garden Chair"));
        Set<String> expectedCourier = new HashSet<>(Arrays.asList("AA Battery"));
        Set<String> expectedClick = new HashSet<>(Arrays.asList("Carrots","Steak","Espresso Machine"));

        Set<String> resultExpress = new HashSet<>(result.get("Express delivery"));
        Set<String> resultCourier = new HashSet<>(result.get("Courier"));
        Set<String> resultClick = new HashSet<>(result.get("Click&Collect"));

        assertTrue(resultExpress.equals(expectedExpress));
        assertTrue(resultCourier.equals(expectedCourier));
        assertTrue(resultClick.equals(expectedClick));
    }

    @Test
    void predictSetsEmpty() {
        List<String> products = List.of();
        Map<String, List<String>> productsDelivery = new HashMap<>();
        productsDelivery.put("Carrots", List.of( "Click&Collect"));
        productsDelivery.put("Cold Beer", List.of("Express delivery"));
        productsDelivery.put("Steak", List.of("Express delivery", "Click&Collect"));
        productsDelivery.put("AA Battery", List.of( "Courier"));
        productsDelivery.put("Espresso Machine", List.of("Click&Collect", "Courier"));
        productsDelivery.put("Garden Chair", List.of("Courier","Express delivery"));

        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(products,productsDelivery);
        Map<String, List<String>> result = greedyAlgorithm.predictSets();
        System.out.println(result);

        assertTrue(result.isEmpty());

    }
}