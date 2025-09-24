import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;
import java.util.stream.Stream;

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

    @Test
    void additionTest() {
        int result = calculator.addition(num1, num2);
        assertEquals(8, result);
        assertEquals(List.of(8), calculator.resultsHistory);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 20, 50, 333, 5676})
    void additionTestVariousCases(Integer num) {
        int result = calculator.addition(num, num2);
        assertEquals(num + num2, result);
        assertEquals(List.of(result), calculator.resultsHistory);
    }

    @ParameterizedTest
    @EnumSource(value = Calculation.class, names = { "ADDITION", "MULTIPLICATION", "DIVISION" })
    void simpleTest(Calculation calculation) {
        int result = calculator.performCalculation(num1, num2, calculation);
        switch (calculation) {
            case ADDITION -> assertEquals(num1 + num2, result);
            case MULTIPLICATION -> assertEquals(num1 * num2, result);
            case DIVISION -> assertEquals(num1 / num2, result);
        }
        assertEquals(List.of(result), calculator.resultsHistory);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 4",
            "3, 9"
    })
    void squareTest(Integer num, Integer square) {
        int result = calculator.square(num);
        assertEquals(square, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/square_test.csv")
    void squareTestFromFile(Integer num, Integer square) {
        int result = calculator.square(num);
        assertEquals(square, result);
    }

    @ParameterizedTest
    @MethodSource("squareTestArguemntsProvider")
    void squareTestMethodSource(Integer num, Integer square) {
        int result = calculator.square(num);
        assertEquals(square, result);
    }

    static Stream<Arguments> squareTestArguemntsProvider() {
        return Stream.of(
            Arguments.arguments(1, 1),
            Arguments.arguments(5, 25),
            Arguments.arguments(10, 100)
        );
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