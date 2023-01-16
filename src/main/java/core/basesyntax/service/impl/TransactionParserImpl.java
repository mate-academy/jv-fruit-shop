package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int LIST_TITLES_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;

    @Override
    public List<FruitTransaction> parse(List<String> inputFileList) {
        String[] dividedLine;
        List<FruitTransaction> transactions = new ArrayList<>();
        inputFileList.remove(LIST_TITLES_INDEX);

        for (String line : inputFileList) {
            dividedLine = line.split(",");
            transactions.add(new FruitTransaction(dividedLine[NAME_INDEX].strip(), 
                    Integer.parseInt(dividedLine[QUANTITY_INDEX].strip()), 
                    Operation.getByLabel(dividedLine[OPERATION_INDEX].strip())));
        }
        return transactions;
    }
}
