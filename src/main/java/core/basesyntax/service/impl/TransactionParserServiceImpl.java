package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.interfaces.TransactionParserService;
import core.basesyntax.service.interfaces.TransactionValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final String REPORT_HEADING = "fruit,quantity\r\n";
    private static final String COMMA = ",";
    private TransactionValidator validator;

    public TransactionParserServiceImpl(TransactionValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> parseFruitTransaction(String data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        String[] records = data.split(System.lineSeparator());
        for (int i = 1; i < records.length; i++) {
            validator.validate(records[i]);
            fruitTransactions.add(FruitTransaction.valueOf(records[i]));
        }
        return fruitTransactions;
    }

    @Override
    public String parseReport(Map<Fruit, Integer> mapOfRecords) {
        StringBuilder report = new StringBuilder().append(REPORT_HEADING);
        for (Map.Entry<Fruit, Integer> entry : mapOfRecords.entrySet()) {
            report.append(entry.getKey().name().toLowerCase())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
