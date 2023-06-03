package fruitshop.service.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.service.ParseText;
import fruitshop.service.ReadReport;

import java.util.ArrayList;
import java.util.List;

public class ParseTextImpl implements ParseText {
    private static final String COMMA_SEPARATOR = ",";
    private static final int TYPE_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private List<FruitTransaction> fruitTransactions;

    @Override
    public List<FruitTransaction> parseReport(ReadReport report) {
        List<String> allReport = report.readReport();
        fruitTransactions = new ArrayList<>();
        for (int i = 1; i < allReport.size(); i++) {
            String[] parts = allReport.get(i).split(COMMA_SEPARATOR);
            FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(parts[TYPE_POSITION]);
            String fruit = parts[FRUIT_POSITION];
            int quantity = Integer.parseInt(parts[QUANTITY_POSITION]);
            fruitTransactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactions;
    }
}
