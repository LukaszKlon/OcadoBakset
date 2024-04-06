import com.ocado.basket.BasketSplitter;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BasketSplitterTest {

    @Test
    void splitBasket1() {
        String configPath = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\config.json";
        String basketPath = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\basket-1.json";

        BasketSplitter basketSplitter = new BasketSplitter(configPath);
        Map<String, List<String>> result = basketSplitter.split(basketPath);

        assertEquals(2, result.size());

    }

    @Test
    void splitBasket2() {
        String configPath = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\config.json";
        String basketPath = "C:\\Users\\klonl\\OneDrive\\Pulpit\\STUDIA\\rekrutacja\\Ocado2\\Ocado\\src\\basket-2.json";

        BasketSplitter basketSplitter = new BasketSplitter(configPath);
        Map<String, List<String>> result = basketSplitter.split(basketPath);

        assertEquals(3, result.size());

    }
}