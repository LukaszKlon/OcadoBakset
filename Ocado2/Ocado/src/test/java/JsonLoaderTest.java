import com.ocado.basket.JsonLoader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JsonLoaderTest {

    @Test
    void loadFromJsonSizeCheck() {
        String path = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\config.json";

        Map<String, List<String>> file = JsonLoader.loadFromJson(path);
        assertEquals(100, file.size());
    }

    @Test
    void loadFromJsonValue() {
        String path = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\config.json";

        Map<String, List<String>> file = JsonLoader.loadFromJson(path);
        String key ="Juice - Ocean Spray Cranberry";
        List<String> value =List.of("Pick-up point");
        assertEquals(file.get(key),value);
    }

    @Test
    void loadProductsFromJsonSize() {
        String path = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\basket-1.json";

        List<String> file = JsonLoader.loadProductsFromJson(path);

        assertEquals(6,file.size());
    }

    @Test
    void loadProductsFromJsonValues() {
        String path = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\basket-1.json";

        List<String> file = JsonLoader.loadProductsFromJson(path);
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("Cocoa Butter");
        expectedResult.add("Tart - Raisin And Pecan");
        expectedResult.add("Table Cloth 54x72 White");
        expectedResult.add("Flower - Daisies");
        expectedResult.add("Fond - Chocolate");
        expectedResult.add("Cookies - Englishbay Wht");

        assertEquals(expectedResult,file);
    }
}