package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parse;
import java.util.ArrayList;
import java.util.List;

public class ParseCsvImpl implements Parse {
    @Override
    public List<TransactionDto> parse(List<String> data) {
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (String line : data) {
            String[] split = line.split(",", 3);
            transactionDtoList.add(new TransactionDto(Operation.getOperationByLetter(split[0]),
                    new Fruit(split[1]), Integer.parseInt(split[2])));
        }
        return transactionDtoList;
    }
}
