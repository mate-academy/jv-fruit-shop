package service.parse;

import model.FruitRecord;

import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {

    @Override
    public List<FruitRecord> parseFruitRecords(List<String> lines) {
        List<FruitRecord> transactions = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");

            String operationCode = parts[0].trim();
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());

            FruitRecord.Operation operation = FruitRecord.Operation.fromCode(operationCode);
            transactions.add(new FruitRecord(operation, fruit, quantity));
        }
        return transactions;
    }
}