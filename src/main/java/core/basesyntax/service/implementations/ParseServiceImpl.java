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
    private static final int HEADER_ROW = 1;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> parseDataToTransaction(List<String> data) {
        if (data == null) {
            throw new WrongDataBaseException("How did you dare to give me null as file data?");
        }
        if (!data.isEmpty() && !data.get(0).equals(HEADER)) {
            throw new WrongDataBaseException("Data without header: " + data);
        }
        return data.stream()
                .skip(HEADER_ROW)
                .map(line -> {
                    String[] row = line.split(COMMA);
                    if (row.length != REQUIRED_ROW_LENGTH) {
                        throw new WrongDataBaseException("Wrong csv file: Row length is "
                                + row.length
                                + " Need: "
                                + REQUIRED_ROW_LENGTH);
                    }
                    try {
                        String operationType = row[OPERATION_INDEX];
                        String fruit = row[FRUIT_INDEX];
                        int quantity = Integer.parseInt(row[QUANTITY_INDEX]);
                        FruitTransaction.Operation operation =
                                FruitTransaction.Operation.fromCode(operationType);
                        return new FruitTransaction(operation, fruit, quantity);
                    } catch (NumberFormatException e) {
                        throw new WrongDataBaseException(
                                "Invalid quantity format: " + row[QUANTITY_INDEX]);
                    } catch (IllegalArgumentException e) {
                        throw new WrongDataBaseException(
                                "Invalid operation code: " + row[OPERATION_INDEX]);
                    }
                })
                .collect(Collectors.toList());
    }

}
