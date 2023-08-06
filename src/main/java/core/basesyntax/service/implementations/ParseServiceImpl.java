package core.basesyntax.service.implementations;

import core.basesyntax.exceptions.WrongDataBaseException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final String COMMA = ",";
    private static final int REQUIRED_ROW_LENGTH = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEADER_INDEX = 1;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parseDataToTransaction(List<String> data) {
        validateData(data);
        return data.stream()
                .skip(HEADER_INDEX)
                .map(this::buildTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction buildTransaction(String row) {
        String[] columns = row.split(COMMA);
        validateColumns(columns);
        try {
            String operationType = columns[OPERATION_INDEX];
            String fruit = columns[FRUIT_INDEX];
            int quantity = Integer.parseInt(columns[QUANTITY_INDEX]);
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(operationType);
            return new FruitTransaction(operation, fruit, quantity);
        } catch (NumberFormatException e) {
            throw new WrongDataBaseException(
                    "Invalid quantity format: " + columns[QUANTITY_INDEX], e);
        } catch (IllegalArgumentException e) {
            throw new WrongDataBaseException(
                    "Invalid operation code: " + columns[OPERATION_INDEX], e);
        }
    }

    private void validateColumns(String[] column) {
        if (column.length != REQUIRED_ROW_LENGTH) {
            throw new WrongDataBaseException("Wrong csv file: Row length is "
                    + column.length
                    + " Need: "
                    + REQUIRED_ROW_LENGTH);
        }
    }

    private void validateData(List<String> data) {
        if (data == null || data.size() == 0) {
            throw new WrongDataBaseException("Empty data from file");
        }
        if (!data.get(0).equals(HEADER)) {
            throw new WrongDataBaseException("Data without header: " + data);
        }
    }
}
