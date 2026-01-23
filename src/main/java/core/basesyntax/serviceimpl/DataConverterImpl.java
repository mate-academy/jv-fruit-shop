package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvert;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConvert {
    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new RuntimeException("File can't be null or empty");
        }
        List<FruitTransaction> result = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line == null || line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.trim().split(",");
            if (parts.length != 3) {
                throw new RuntimeException("Invalid format at line " + i + 1 + ": " + line);
            }
            FruitTransaction fruitTransaction = new FruitTransaction();
            String code = parts[0].trim();
            String fruit = parts[1].trim();
            String quantity = parts[2].trim();
            try {
                fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(code));
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid operation code at line "
                        + i + ": " + code, e);
            }
            fruitTransaction.setFruit(fruit);
            int qty;
            try {
                qty = Integer.parseInt(quantity);
                fruitTransaction.setQuantity(qty);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity at line " + i + ": " + parts[2], e);
            }
            result.add(fruitTransaction);
        }
        return result;
    }
}
