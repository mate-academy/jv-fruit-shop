package service.read;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class ProcessFileContentImpl implements ProcessFileContent {
    private static final String CSV_SEPARATOR = ",";
    private static final String OPERATION_TYPE_NAME = "type";
    private static final String FRUIT_QUANTITY_NAME = "quantity";
    private static final String FRUIT_NAME = "fruit";
    private static final int TYPES_INDEX = 0;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    private final OperationTypeService operationTypeService = new OperationTypeServiceImpl();

    @Override
    public List<FruitTransaction> processFile(List<String> fileContent) {
        String[] columnNames = fileContent.get(TYPES_INDEX).split(CSV_SEPARATOR);
        int[] typeIndexes = getTypesIndexes(columnNames);
        List<String> transactions = fileContent;
        transactions.remove(TYPES_INDEX);
        return transactions.stream()
                .map(e -> e.split(CSV_SEPARATOR))
                .map(e -> new FruitTransaction(
                        operationTypeService.getOperation(e[typeIndexes[TYPE_INDEX]]),
                        e[typeIndexes[FRUIT_NAME_INDEX]],
                        Integer.parseInt(e[typeIndexes[FRUIT_QUANTITY_INDEX]])))
                .collect(Collectors.toList());
    }

    @Override
    public int[] getTypesIndexes(String[] columnNames) {
        int[] result = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            if (columnNames[i].equals(OPERATION_TYPE_NAME)) {
                result[TYPE_INDEX] = i;
            } else if (columnNames[i].equals(FRUIT_QUANTITY_NAME)) {
                result[FRUIT_QUANTITY_INDEX] = i;
            } else if (columnNames[i].equals(FRUIT_NAME)) {
                result[FRUIT_NAME_INDEX] = i;
            }
        }
        return result;
    }
}
