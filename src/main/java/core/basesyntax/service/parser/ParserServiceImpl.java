package core.basesyntax.service.parser;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int INDEX_FIRST = 0;
    private static final int INDEX_SECOND = 1;
    private static final int INDEX_THIRD = 2;

    @Override
    public List<FruitTransaction> parserData(List<String> inputDataFromFile) {
        return inputDataFromFile.stream()
                .map(inputData -> inputData.split(","))
                .filter(data -> data[INDEX_FIRST].trim().length() == 1)
                .map(data -> new FruitTransaction(
                        FruitTransaction.Operation.getByCode(data[INDEX_FIRST].trim()),
                        data[INDEX_SECOND],Integer.parseInt(data[INDEX_THIRD])))
                .collect(Collectors.toList());
    }
}