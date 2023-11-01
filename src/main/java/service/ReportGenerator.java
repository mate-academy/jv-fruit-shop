package service;

import java.util.ArrayList;
import java.util.HashMap;
import model.FruitTransaction;

public interface ReportGenerator {
    String generateReport(HashMap<String, Integer> inventoryMap);
}
