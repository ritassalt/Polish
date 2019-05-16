package polish;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PolishTest {

    @Test
    public void testPolishNotation1() {
        String request = "15 7 1 1 + − ÷ 3 × 2 1 1 + + −";
        int answer = Polish.calculate(request);
        assertEquals(5, answer);
    }

    @Test
    public void testPolishNotation2() {
        String request = "15 7 1 1 + − ÷ 3 × 2 1 1 + + − ";
        int answer = Polish.calculate(request);
        assertEquals(5, answer);
    }

    @Test
    public void testWrongPolishNotation() {
        String request = "15 7 1 1 + − ÷ e × 2 1 1 + + −";
        try {
            int answer = Polish.calculate(request);
        } catch (Exception ex) {
            assertEquals("Input was incorrect", ex.getLocalizedMessage());
        }
    }
}
