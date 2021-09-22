package core.basesyntax.services.impl;

import core.basesyntax.dao.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.services.ParserService;
import core.basesyntax.services.ReportFruitService;
import core.basesyntax.services.Validator;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public class ReportFruitServiceImpl implements ReportFruitService {
    public static final String COMMA = ",";

    @Override
    public String createReport(List<String> listData,
                               Map<Transaction.Operation, Operation> operationMap) {
        Validator validator = new ValidatorImpl();
        ParserService parserService = new ParserServiceImpl();
        for (String row : listData) {
            validator.checkInputData(listData);
            Transaction transaction = parserService.parseData(row);
            operationMap.get(transaction.getOperation()).apply(transaction);
        }
        return getReport();
    }

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruitStorageMap.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
