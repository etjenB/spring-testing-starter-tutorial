import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public List<Integer> resultsHistory = new ArrayList<>();

    public Integer addition(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        resultsHistory.add(result);
        int counter = 0;
        while(true){
            System.out.println(counter++);
        }
    }

    public Integer multiplication(Integer num1, Integer num2) {
        Integer result = num1 * num2;
        resultsHistory.add(result);
        return result;
    }

    public Integer division(Integer num1, Integer num2) {
        if (num2 == 0)
            throw new ArithmeticException("Cannot divide by 0!");
        Integer result = num1 / num2;
        resultsHistory.add(result);
        return result;
    }

    public Integer performCalculation(Integer num1, Integer num2, Calculation calculation) {
        switch (calculation) {
            case ADDITION -> { return this.addition(num1, num2); }
            case MULTIPLICATION -> { return this.multiplication(num1, num2); }
            case DIVISION -> { return this.division(num1, num2); }
            case null, default -> throw new ArithmeticException("No calculation was provided.");
        }
    }

    public Integer square(Integer num) {
        Integer result = num * num;
        resultsHistory.add(result);
        return result;
    }
}
