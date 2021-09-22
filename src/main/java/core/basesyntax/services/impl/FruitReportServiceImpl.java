package core.basesyntax.services.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.services.FruitReportService;
import core.basesyntax.services.TransactionParser;
import core.basesyntax.services.Validator;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    public static final String COMMA = ",";

    @Override
    public String createReport(List<String> listData,
                               Map<Transaction.Operation, Operation> operationMap) {
        Validator validator = new ValidatorImpl();
        TransactionParser parserService = new TransactionParserImpl();
        for (String row : listData) {
            validator.checkInputData(listData);
            Transaction transaction = parserService.parse(row);
            operationMap.get(transaction.getOperation()).apply(transaction);
        }
        return getFormattedStringReport();
    }

    @Override
    public String getFormattedStringReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
