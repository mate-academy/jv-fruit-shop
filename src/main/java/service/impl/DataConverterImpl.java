package service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> convertData(List<String> fruitTransactions) {
        return fruitTransactions.stream()
                .filter(s -> s.split(COMMA)[ZERO_INDEX].length() == 1
                        && Character.isLetter(s.charAt(ZERO_INDEX)))
                .map(s -> new FruitTransaction(model.Operation
                        .getByCode(s.split(COMMA)[ZERO_INDEX]),
                       s.split(COMMA)[FIRST_INDEX], Integer.parseInt(s.split(COMMA)[SECOND_INDEX])))
                 .collect(toList());
    }
}
