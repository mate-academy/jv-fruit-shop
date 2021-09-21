package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.Fruit;
import core.basesyntax.fruitshop.model.OperationType;
import core.basesyntax.fruitshop.model.TransactionDto;
import core.basesyntax.fruitshop.validator.Validator;
import core.basesyntax.fruitshop.validator.ValidatorImpl;
import java.util.ArrayList;
import java.util.List;

public class TransactionDtoServiceImpl implements TransactionDtoService {
    private static final int OPERATIONS_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int AMOUNT_POSITION = 2;
    private static final String SPLIT_SEPARATOR = ",";
    private static final List<TransactionDto> transactionList = new ArrayList<>();
    private final Validator validator = new ValidatorImpl();

    public List<TransactionDto> createDto(String pathToFile) {
        for (String fruit : new FileReaderServiceImpl().readFile(pathToFile)) {
            String[] tmp = fruit.split(SPLIT_SEPARATOR);
            if (validator.validateTransaction(tmp)) {
                transactionList.add(new TransactionDto(OperationType
                        .valueOfLabel(tmp[OPERATIONS_POSITION]),
                        new Fruit(tmp[FRUIT_NAME_POSITION]),
                        Integer.parseInt(tmp[AMOUNT_POSITION])));
            }
        }
        return transactionList;
    }

}
