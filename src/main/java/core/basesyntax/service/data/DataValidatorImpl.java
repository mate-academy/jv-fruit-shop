package core.basesyntax.service.data;

import java.util.List;

public class DataValidatorImpl implements DataValidator {
    @Override
    public void validate(List<String> data) {
        for (String datum : data) {
            String[] datumArray = datum.split(",");
            if (datumArray.length != 3 || Integer.parseInt(datumArray[2]) <= 0) {
                throw new RuntimeException("Wrong data input: " + data);
            }
        }
    }
}
