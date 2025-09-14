import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    Integer num1;
    Integer num2;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Nested
    class AdditionTests {
        @BeforeEach
        void setUp() {
            num1 = 5;
            num2 = 3;
        }

        @Test
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
    }

    @Nested
    class MultiplicationTests {
        @BeforeEach
        void setUp() {
            num1 = 4;
            num2 = 4;
        }

        @Test
        void multiplicationTest() {
            int result = calculator.multiplication(num1, num2);
            assertEquals(16, result);
            assertEquals(List.of(16), calculator.resultsHistory);
        }

        @Test
        void multiplicationTestNegativeNumber() {
            num2 = -4;
            int result = calculator.multiplication(num1, num2);
            assertEquals(-16, result);
            assertEquals(List.of(-16), calculator.resultsHistory);
        }
    }

    @Nested
    class DivisionTests {
        @BeforeEach
        void setUp() {
            num1 = 6;
            num2 = 2;
        }

        @Test
        void divisionTest() {
            int result = calculator.division(num1, num2);
            assertEquals(3, result);
            assertEquals(List.of(3), calculator.resultsHistory);
        }

        @Test
        void divisionTestNegativeNumber() {
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
}