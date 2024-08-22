package service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import model.FruitTransaction;
import service.DataConverter;
import service.ValidatorService;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int REPORT_START_INDEX = 1;
    private static final String DATA_SEPARATOR = ",";
    private static final int EMPTY_REPORT_LENGTH = 1;
    private final ValidatorService validator;

    public DataConverterImpl(ValidatorService validator) {
        this.validator = validator;
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        checkReportLength(inputReport);
        for (int i = REPORT_START_INDEX; i < inputReport.size(); i++) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] line = inputReport.get(i).split(DATA_SEPARATOR);
            validator.validate(line);
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

    private void checkReportLength(List<String> data) {
        if (data.size() <= EMPTY_REPORT_LENGTH) {
            throw new RuntimeException("This reportFile is empty");
        }
    }
}
