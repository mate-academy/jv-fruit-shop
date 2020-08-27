package core.basesyntax.parser;

import core.basesyntax.exception.InvalidDateException;
import core.basesyntax.model.InputDataModel;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ProductParser implements Parser<InputDataModel> {

    @Override
    public InputDataModel parse(List<String> parseData) {
        InputDataModel inputDataModel;
        try {
            inputDataModel = new InputDataModel(
                    parseData.get(1), LocalDate.parse(parseData.get(3)));
        } catch (DateTimeParseException e) {
            throw new InvalidDateException(String.format("Invalid Data %s", parseData.get(3)), e);
        }
        return inputDataModel;
    }
}
