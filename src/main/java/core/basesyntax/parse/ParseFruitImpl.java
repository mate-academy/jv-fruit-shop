package core.basesyntax.parse;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class ParseFruitImpl implements ParseFruit {
    @Override
    public List<TransactionDto> parse(List<String[]> data) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (String[] line : data) {
            transactionDtos.add(createTransactionDto(line));
        }
        return transactionDtos;
    }

    private TransactionDto createTransactionDto(String[] line) {
        return new TransactionDto(new Fruit(line[1]),
                Integer.parseInt(line[2]), Operation.findValue(line[0]));
    }
}
