package mate.academy.service.calculation;

import java.util.Map;
import mate.academy.service.ParseFile;

public interface TransactionCalculation {
    Map<String, Integer> calculate(ParseFile parseFile);
}
