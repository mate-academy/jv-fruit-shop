package core.basesyntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitDataCounterImpl implements FruitDataCounter {
    @Override
    public List<String> fruits(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            int quant = quantFinder(fruitTransaction.getQuantity(),
                    fruitTransaction.getOperation());
            fruitMap.merge(fruitTransaction.getFruit(), quant, Integer::sum);
        }
        List<String> fruitLines = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : fruitMap.entrySet()) {
            String result = entry.getKey() + "," + entry.getValue();
            fruitLines.add(result);
        }
        return fruitLines;
    }

    private int quantFinder(int quant, FruitTransaction.Operation operation) {
        if (operation == FruitTransaction.Operation.PURCHASE) {
            quant = -quant;
        }
        return quant;
    }
}
