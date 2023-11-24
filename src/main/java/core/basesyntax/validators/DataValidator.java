package core.basesyntax.validators;

import java.util.List;

public class DataValidator {
    public void validate(List<String> dataFromFile) {
        int count = (int) dataFromFile.stream()
                .skip(1)
                .filter(string -> string.split(",").length == 3
                        && string.split(",")[0]
                        .matches("[srbp]"))
                .count();
        if (count < dataFromFile.size() - 1) {
            throw new RuntimeException("Shit!");
        }
    }
}
