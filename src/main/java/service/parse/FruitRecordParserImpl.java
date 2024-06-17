package service.parse;

import java.util.ArrayList;
import java.util.List;
import model.FruitRecord;

public class FruitRecordParserImpl implements FruitRecordParser {
    @Override
    public List<FruitRecord> convertToObject(String[] lines) {
        List<FruitRecord> object = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Invalid line format: " + line);
            }
            FruitRecord.Type type = FruitRecord.Type.valueOfType(parts[0].trim().toUpperCase());
            String fruit = parts[1].trim();
            int quantity;
            quantity = Integer.parseInt(parts[2]);

            FruitRecord record = new FruitRecord(type, fruit, quantity);
            object.add(record);
        }
        return object;
    }
}
