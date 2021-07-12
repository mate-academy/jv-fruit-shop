package core.basesyntax.model;

import core.basesyntax.dao.ReportsDao;
import java.util.List;
import java.util.stream.Collectors;

public class RecordsValidatorImpl implements RecordsValidator {
    private static final String SEPARATOR = ",";
    private final ReportsDao reportsDao;

    public RecordsValidatorImpl(ReportsDao reportsDao) {
        this.reportsDao = reportsDao;
    }

    @Override
    public List<Record> validateInput(String sourceFilename) {
        try {
            return reportsDao.getRawRecords(sourceFilename).stream()
                    .map((i) -> i.split(SEPARATOR))
                    .map((i) -> addRecord(i[0], i[1], i[2]))
                    .collect(Collectors.toList());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Input file has corrupted columns structure", e);
        }

    }

    private Record addRecord(String operationType, String fruitName, String quantity) {
        int fruitQuantity = Integer.parseInt(quantity);

        if (fruitQuantity < 0 || quantity.equals("")) {
            throw new IllegalArgumentException("Data input file contains illegal "
                    + "quantity record: " + quantity);
        }

        if (fruitName == null || fruitName.equals("")) {
            throw new IllegalArgumentException("Data input file contains illegal "
                    + "fruit name record: " + fruitName);
        }

        switch (operationType) {
            case "b":
                return new Record(Record.OperationType.BALANCE, fruitName, fruitQuantity);
            case "s":
                return new Record(Record.OperationType.SUPPLY, fruitName, fruitQuantity);
            case "p":
                return new Record(Record.OperationType.PURCHASE, fruitName, fruitQuantity);
            case "r":
                return new Record(Record.OperationType.RETURN, fruitName, fruitQuantity);
            default:
                throw new IllegalArgumentException("Data input file contains illegal "
                        + "operation record: " + operationType);
        }
    }
}
