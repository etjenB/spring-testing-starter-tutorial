import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void additionTest() {
        Calculator calculator = new Calculator();
        int result = calculator.addition(5, 3);
        assertEquals(8, result);
    }
}