package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> result = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            result.add(new FruitTransaction(operation, fruit, quantity));
        }
        return result;
    }
}
