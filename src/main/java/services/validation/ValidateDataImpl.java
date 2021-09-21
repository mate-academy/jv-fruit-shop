package services.validation;

import java.util.Objects;
import java.util.function.Predicate;
import model.OperationTypes;
import model.TransactionDto;

public class ValidateDataImpl implements ValidateData, Predicate<String[]> {
    private static final int OPERATION_TYPE = 0;
    private static final int FRUIT = 1;
    private static final int AMOUNT = 2;
    private static final int MAX_LENGTH = 3;

    @Override
    public TransactionDto isDataOk(String record) {
        String[] partRecord = record.split(",");
        if (!test(partRecord)) {
            throw new ValidationException("Data is invalid!");
        }
        return new TransactionDto(partRecord[OPERATION_TYPE],
                                partRecord[FRUIT],
                                Integer.parseInt(partRecord[AMOUNT]));
    }

    @Override
    public boolean test(String[] strings) {
        String operationType = strings[OPERATION_TYPE];
        return strings.length == MAX_LENGTH
                && Objects.equals(strings[OPERATION_TYPE],
                        Objects.requireNonNull(OperationTypes
                                .valueOfShortName(operationType))
                                .getShortName())
                && Integer.parseInt(strings[AMOUNT]) >= 0;
    }
}
