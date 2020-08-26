package core.basesyntax.service;

import core.basesyntax.FruitBatch;
import core.basesyntax.FruitStorage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CsvFileWriterService implements FileWriterService {

    @Override
    public void writeToFile(String filePath, Map<FruitBatch, Integer> fruits) {
        String newFilePath = filePath.substring(0, filePath.length() - 4) + "_output.csv";
        Map<String, Integer> stockOverview = formatData(fruits);
        StringBuilder formattedLines = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : stockOverview.entrySet()) {
            formattedLines.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue().toString())
                    .append("\n");
        }
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new File(newFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.write(formattedLines.toString());
        writer.close();
        FruitStorage.clearStock();
    }

    public Map<String, Integer> formatData(Map<FruitBatch, Integer> fruits) {
        Map<String, Integer> stockOverview = new HashMap<>();
        for (Map.Entry<FruitBatch, Integer> entry : fruits.entrySet()) {
            String fruitType = entry.getKey().getFruitType();
            if (stockOverview.containsKey(fruitType)) {
                stockOverview.put(fruitType,
                        stockOverview.get(fruitType) + entry.getValue());
            } else {
                stockOverview.put(fruitType, entry.getValue());
            }
        }
        return stockOverview;
    }
}
