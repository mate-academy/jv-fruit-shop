package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParserImpl implements Parser<TransactionDto> {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private Validator validator;

    public ParserImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public List<TransactionDto> parse(List<String> lines) {
        validator.validate(lines);
        List<TransactionDto> transactions = new ArrayList<>();
        IntStream.range(1, lines.size())
                .mapToObj(i -> lines.get(i).split(","))
                .forEach(array -> transactions.add(new TransactionDto(array[OPERATION_TYPE_INDEX],
                        array[FRUIT_NAME_INDEX], Integer.parseInt(array[QUANTITY_INDEX]))));
        return transactions;
    }
}
