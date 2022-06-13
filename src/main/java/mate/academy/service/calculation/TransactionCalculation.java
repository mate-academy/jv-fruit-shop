package mate.academy.service.calculation;

import mate.academy.service.ParseFile;

import java.util.Map;

public interface TransactionCalculation {
    Map<String, Integer> calculate(ParseFile parseFile);
}
