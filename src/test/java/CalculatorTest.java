import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private static Calculator calculator;
    Integer num1;
    Integer num2;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        num1 = 5;
        num2 = 3;
    }

    @RepeatedTest(3)
    void additionTest() {
        int result = calculator.addition(num1, num2);
        assertEquals(8, result);
        assertEquals(List.of(8), calculator.resultsHistory);
    }

    @Test
    void additionTestNegativeNumber() {
        num2 = -3;
        int result = calculator.addition(num1, num2);
        assertEquals(2, result);
        assertEquals(List.of(2), calculator.resultsHistory);
    }

    @Test
    void multiplicationTest() {
        int result = calculator.multiplication(num1, num2);
        assertEquals(15, result);
        assertEquals(List.of(15), calculator.resultsHistory);
    }

    @Test
    void multiplicationTestNegativeNumber() {
        num2 = -3;
        int result = calculator.multiplication(num1, num2);
        assertEquals(-15, result);
        assertEquals(List.of(-15), calculator.resultsHistory);
    }

    @Test
    void divisionTest() {
        num1 = 6;
        int result = calculator.division(num1, num2);
        assertEquals(2, result);
        assertEquals(List.of(2), calculator.resultsHistory);
    }

    @Test
    void divisionTestNegativeNumber() {
        num1 = 6;
        num2 = -2;
        int result = calculator.division(num1, num2);
        assertEquals(-3, result);
        assertEquals(List.of(-3), calculator.resultsHistory);
    }

    @Test
    void divisionTestThrowsArithmeticExceptionIfZero() {
        num2 = 0;
        assertThrowsExactly(ArithmeticException.class, () -> calculator.division(num1, num2));
        assertEquals(List.of(), calculator.resultsHistory);
    }
}