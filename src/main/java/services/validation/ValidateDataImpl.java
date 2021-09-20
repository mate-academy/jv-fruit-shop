package services.validation;

import java.util.Objects;
import java.util.function.Predicate;
import model.TransactionDto;

public class ValidateDataImpl implements ValidateData, Predicate<String[]> {
    @Override
    public TransactionDto isDataOk(String record) {
        String[] partRecord = record.split(",");
        if (!test(partRecord)) {
            throw new ValidationException("Data is invalid!");
        }
        return new TransactionDto(partRecord[0],
                                partRecord[1],
                                Integer.parseInt(partRecord[2]));
    }

    @Override
    public boolean test(String[] strings) {
        return (Objects.equals(strings[0], "b")
                || Objects.equals(strings[0], "s")
                || Objects.equals(strings[0], "p")
                || Objects.equals(strings[0], "r"))
                && (Objects.equals(strings[1], "banana")
                || Objects.equals(strings[1], "apple"))
                && Integer.parseInt(strings[2]) >= 0;
    }
}
