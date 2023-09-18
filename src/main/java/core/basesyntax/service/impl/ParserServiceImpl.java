package core.basesyntax.service.impl;

import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int NUMBER_OF_TITLE_LINES = 1;
    private static final String TRANSACTION_SEPARATOR = ",";
    private static final List<String[]> transactionsList = new ArrayList<>();

    @Override
    public List<String[]> parseInputData(List<String> inputData) {
        for (String action : inputData.stream().skip(NUMBER_OF_TITLE_LINES).toList()) {
            String[] transaction = action.trim().split(TRANSACTION_SEPARATOR);
            transactionsList.add(transaction);
        }
        return transactionsList;
    }
}
