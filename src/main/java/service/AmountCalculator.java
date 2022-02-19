package service;

import java.util.List;
import java.util.Map;
import model.Operation;

public interface AmountCalculator {
    Map<String, Integer> calculateDataForReport(List<Operation> operations);
}
