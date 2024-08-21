package service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REPORT_START_INDEX = 1;
    private static final String DATA_SEPARATOR = ",";
    private static final int EMPTY_REPORT_LENGTH = 1;
    private static final int DEFAULT_TRANSACTION_LENGTH = 3;
    private List<FruitTransaction> fruitTransactions;

    public DataConverterImpl() {
        this.fruitTransactions = new ArrayList<>();
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        checkReportLength(inputReport);
        for (int i = REPORT_START_INDEX; i < inputReport.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] line = inputReport.get(i).split(DATA_SEPARATOR);
            checkDataLength(line);
            fruitTransaction.setOperation(Arrays.stream(FruitTransaction.Operation.values())
                    .filter(o -> o.getCode().equals(line[OPERATION_INDEX]))
                    .findAny()
                    .orElseThrow(() -> new NoSuchElementException("Invalid operation name: "
                            + line[OPERATION_INDEX] + ". Must be one of these 'b,p,r,s'")));
            fruitTransaction.setFruit(line[FRUIT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(line[QUANTITY_INDEX]));
            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }

    private void checkDataLength(String[] line) {
        if (line.length != DEFAULT_TRANSACTION_LENGTH) {
            throw new RuntimeException("This data has incorrect length: " + line.length);
        }
        if (line[FRUIT_INDEX].isBlank()) {
            throw new RuntimeException("The name of the fruit cannot be blank");
        }
        if (line[FRUIT_INDEX].equals("null")) {
            throw new RuntimeException("The name of the fruit cannot be null");
        }
        if (line[QUANTITY_INDEX].isBlank()) {
            throw new RuntimeException("The quantity can't be empty");
        }
        if (!line[QUANTITY_INDEX].matches("\\d+")) {
            throw new RuntimeException("The quantity must consist of numbers only: "
                    + line[QUANTITY_INDEX]);
        }
        if (Integer.parseInt(line[QUANTITY_INDEX]) < 0 ) {
            throw new RuntimeException("The quantity can't be less than zero: "
                    + line[QUANTITY_INDEX]);
        }
    }

    private void checkReportLength(List<String> data) {
        if (data.size() <= EMPTY_REPORT_LENGTH) {
            throw new RuntimeException("This reportFile is empty");
        }
    }
}
