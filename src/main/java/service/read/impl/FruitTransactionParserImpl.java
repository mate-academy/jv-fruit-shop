package service.read.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.read.FruitTransactionParser;
import service.read.OperationMapper;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int COLUMN_NAMES_INDEX = 0;
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final int FIRST_LINE = 1;
    private final OperationMapper operationMapper = new OperationMapperImpl();
    private String csvSeparator;
    private String operationTypeName;
    private String fruitQuantityName;
    private String fruitName;

    public FruitTransactionParserImpl(String csvSeparator, String operationTypeName,
                                      String fruitQuantityName, String fruitName) {
        this.csvSeparator = csvSeparator;
        this.operationTypeName = operationTypeName;
        this.fruitQuantityName = fruitQuantityName;
        this.fruitName = fruitName;
    }

    @Override
    public List<FruitTransaction> parse(List<String> fileContent) {
        String[] columnNames = fileContent.get(COLUMN_NAMES_INDEX).split(csvSeparator);
        int[] typeIndexes = getColumnIndexes(columnNames);
        return fileContent.stream().skip(FIRST_LINE)
                .map(e -> e.split(csvSeparator))
                .map(e -> new FruitTransaction(
                        operationMapper.mapToOperation(e[typeIndexes[TYPE_INDEX]]),
                        e[typeIndexes[FRUIT_NAME_INDEX]],
                        Integer.parseInt(e[typeIndexes[FRUIT_QUANTITY_INDEX]])))
                .collect(Collectors.toList());
    }

    public int[] getColumnIndexes(String[] columnNames) {
        int[] result = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            if (columnNames[i].equals(operationTypeName)) {
                result[TYPE_INDEX] = i;
            } else if (columnNames[i].equals(fruitQuantityName)) {
                result[FRUIT_QUANTITY_INDEX] = i;
            } else if (columnNames[i].equals(fruitName)) {
                result[FRUIT_NAME_INDEX] = i;
            }
        }
        return result;
    }
}
