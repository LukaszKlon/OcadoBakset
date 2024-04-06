import com.ocado.basket.PrepareSets;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PrepareSetsTest {


    @Test
    public void testMapReverseMethod() {
        List<String> products = List.of("Garden Chair","Espresso Machine","Carrots", "Cold Beer", "Steak","Carrots", "Cold Beer", "Steak","AA Battery");
        Map<String, List<String>> productsDelivery = new HashMap<>();
        productsDelivery.put("Carrots", List.of("Express delivery", "Click&Collect"));
        productsDelivery.put("Cold Beer", List.of("Express delivery"));
        productsDelivery.put("Steak", List.of("Express delivery", "Click&Collect"));
        productsDelivery.put("AA Battery", List.of("Express delivery", "Courier"));
        productsDelivery.put("Espresso Machine", List.of("Click&Collect", "Courier"));
        productsDelivery.put("Garden Chair", List.of("Courier"));

        PrepareSets prepareSets = new PrepareSets(products, productsDelivery);
        Map<String,Set<String>> result = prepareSets.mapReverse();

        assertEquals(3, result.size());

        Set<String> expectedExpress = new HashSet<>(Arrays.asList("Carrots", "Cold Beer","Steak","AA Battery"));
        Set<String> expectedClick = new HashSet<>(Arrays.asList("Carrots","Steak","Espresso Machine"));
        Set<String> expectedCourier = new HashSet<>(Arrays.asList("AA Battery", "Espresso Machine","Garden Chair"));

        assertTrue(result.containsValue(expectedClick));
        assertTrue(result.containsValue(expectedExpress));
        assertTrue(result.containsValue(expectedCourier));
    }

    @Test
    public void testMapReverseMethodProductListNotContainsAllProducts() {
        List<String> products = List.of("Espresso Machine","Carrots","Carrots", "Cold Beer","AA Battery");
        Map<String, List<String>> productsDelivery = new HashMap<>();
        productsDelivery.put("Carrots", List.of("Express delivery", "Click&Collect"));
        productsDelivery.put("Cold Beer", List.of("Express delivery"));
        productsDelivery.put("Steak", List.of("Express delivery", "Click&Collect"));
        productsDelivery.put("AA Battery", List.of("Express delivery", "Courier"));
        productsDelivery.put("Espresso Machine", List.of("Click&Collect", "Courier"));
        productsDelivery.put("Garden Chair", List.of("Courier"));

        PrepareSets prepareSets = new PrepareSets(products, productsDelivery);
        Map<String,Set<String>> result = prepareSets.mapReverse();

        assertEquals(3, result.size());
        System.out.println(result);
        Set<String> expectedExpress = new HashSet<>(Arrays.asList("Carrots", "Cold Beer","AA Battery"));
        Set<String> expectedClick = new HashSet<>(Arrays.asList("Carrots","Espresso Machine"));
        Set<String> expectedCourier = new HashSet<>(Arrays.asList("AA Battery", "Espresso Machine"));

        assertTrue(result.containsValue(expectedClick));
        assertTrue(result.containsValue(expectedExpress));
        assertTrue(result.containsValue(expectedCourier));
    }



    @Test
    public void testSetProducts() {
        List<String> products = List.of("Garden Chair","Espresso Machine","Carrots", "Cold Beer", "Steak","Carrots", "Cold Beer", "Steak","AA Battery");
        Map<String, List<String>> productsDelivery = new HashMap<>();

        PrepareSets prepareSets = new PrepareSets(products, productsDelivery);
        Set<String> result = prepareSets.createProductSet();

        assertEquals(6, result.size());

        for (String value: products) {
            assertTrue(result.contains(value));
        }

    }
}