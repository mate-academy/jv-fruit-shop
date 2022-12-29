package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;

import java.util.HashMap;
import java.util.Map;

public class ProcessServiceImpl extends FruitTransaction implements ProcessService {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    public static final String COMMA_DELIMITTER = ",";
    public static final String NEW_LINE_DELIMITER = "\n";
    FruitTransaction fruitTransaction = new FruitTransaction();
    Map<String, Integer> fruitMap = new HashMap<>();

    @Override
    public String getReport(String lines) {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity\n");
        String[] splittedLines = lines.split(NEW_LINE_DELIMITER);
        for (int i = 1; i < splittedLines.length; i++) {
            String[] splittedLine = splittedLines[i].trim().split(COMMA_DELIMITTER);
            switch (splittedLine[OPERATION_TYPE_INDEX]) {
                case "b":
                    int quantity = Integer.parseInt(splittedLine[AMOUNT_INDEX]);
                        fruitMap.put(splittedLine[FRUIT_TYPE_INDEX], quantity);
                    break;
                case "s":
                case "r":
                        quantity = fruitMap.get(splittedLine[FRUIT_TYPE_INDEX]) + Integer.parseInt(splittedLine[AMOUNT_INDEX]);
                        fruitMap.replace(splittedLine[FRUIT_TYPE_INDEX], quantity);
                    break;
                case "p":
                        quantity = fruitMap.get(splittedLine[FRUIT_TYPE_INDEX]) - Integer.parseInt(splittedLine[AMOUNT_INDEX]);
                        fruitMap.replace(splittedLine[FRUIT_TYPE_INDEX], quantity);
                    break;
                default:
                    continue;
            }
        }
        for (Map.Entry<String, Integer> set : fruitMap.entrySet()) {
            reportBuilder.append(set.getKey()).append(",").append(set.getValue()).append("\n");
        }
        return reportBuilder.toString();
    }
}
