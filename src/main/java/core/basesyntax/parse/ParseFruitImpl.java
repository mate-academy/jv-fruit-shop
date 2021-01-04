package core.basesyntax.parse;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class ParseFruitImpl implements ParseFruit {
    @Override
    public List<TransactionDto> parse(String data) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        String[] lines = data.split(System.lineSeparator());
        for (int i = 1; i < lines.length; i++) {
            transactionDtos.add(createTransactionDto(lines[i]));
        }
        return transactionDtos;
    }

    private TransactionDto createTransactionDto(String line) {
        String[] words = line.split(",");
        return new TransactionDto(new Fruit(words[1]),
                Integer.parseInt(words[2]), Operation.findValue(words[0]));
    }
}
