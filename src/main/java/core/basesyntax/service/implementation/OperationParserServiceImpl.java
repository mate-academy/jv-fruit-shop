package core.basesyntax.service.implementation;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationParserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationParserServiceImpl implements OperationParserService {

    private static final String SEPARATOR = ",";
    private static final int OPERATION_ABBREVIATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<Operation> parseDataFromList(List<String> data) {

        return data.subList(1, data.size()).stream()
                .map(s -> s.split(SEPARATOR))
                .map(s -> new Operation(Operation.OperationType.getOperationTypeByAbbreviation(
                        s[OPERATION_ABBREVIATION_INDEX]),
                        s[FRUIT_NAME_INDEX],
                        Integer.parseInt(s[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
