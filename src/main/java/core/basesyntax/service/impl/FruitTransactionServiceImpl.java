package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final String TITLE = "type";
    private static final String SEPARATOR = ",";
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int OPERATION_INDEX = 0;
    private static final int TRANSACTION_DATA_QUANTITY = 3;

    private final ReaderService readerService = new ReaderServiceImpl();

    @Override
    public List<FruitTransaction> getFruitTransactionsFromCvsFile(String fileName) {
        List<String> fruitInfoFromFile = readerService.getInformationFromCvsFile(fileName);
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String information : fruitInfoFromFile) {
            String[] infoAboutFruitTransaction = information.split(SEPARATOR);
            if (infoAboutFruitTransaction[0].equals(TITLE)) {
                continue;
            }
            validateTransactionInfo(information);
            FruitTransaction fruitTransaction = new FruitTransaction(getOperation(
                    infoAboutFruitTransaction[OPERATION_INDEX]),
                            infoAboutFruitTransaction[FRUIT_INDEX],
                            Integer.parseInt(infoAboutFruitTransaction[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }

    private FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException("Your operation code \"" + code
                + "\" is not correct! Please, enter the correct type of operation");
    }

    private static void validateTransactionInfo(String information) {
        String[] infoAboutFruitTransaction = information.split(SEPARATOR);
        if (infoAboutFruitTransaction.length != TRANSACTION_DATA_QUANTITY) {
            throw new RuntimeException("Wrong data format in the string " + information);
        }
        try {
            Integer.parseInt(infoAboutFruitTransaction[QUANTITY_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Enter the correct value for the fruits quantity");
        }
        if (Integer.parseInt(infoAboutFruitTransaction[QUANTITY_INDEX]) < 0) {
            throw new RuntimeException("Fruits quantity can`t be less than 0");
        }
        for (String info : infoAboutFruitTransaction) {
            if (info.equals("") || info.equals(" ")) {
                throw new RuntimeException("Wrong data format in the string " + information);
            }
        }
    }
}
