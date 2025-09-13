import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;
    Integer num1;
    Integer num2;

    @BeforeAll
    static void beforeAll() {
        //System.out.println("Before all called!");
        calculator = new Calculator();
    }

    @BeforeEach
    void setUp() {
        //System.out.println("Before each called!");
        num1 = 5;
        num2 = 3;
    }

    @Test
    void additionTest() {
        int result = calculator.addition(num1, num2);
        num1 = num1 - 2;
        assertEquals(8, result);
    }

    @Test
    void multiplicationTest() {
        int result = calculator.multiplication(num1, num2);
        assertEquals(15, result);
    }

    @AfterEach
    void tearDown() {
        //System.out.println("After each called!");
        num1 = 5;
        num2 = 3;
    }

    @AfterAll
    static void afterAll() {
        //System.out.println("After all called!");
        //System.out.println(calculator.resultsHistory);
    }
}