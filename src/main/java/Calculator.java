import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public List<Integer> resultsHistory = new ArrayList<>();

    public Integer addition(Integer num1, Integer num2) {
        Integer result = num1 + num2;
        resultsHistory.add(result);
        return result;
    }

    public Integer multiplication(Integer num1, Integer num2) {
        Integer result = num1 * num2;
        resultsHistory.add(result);
        return result;
    }
}
