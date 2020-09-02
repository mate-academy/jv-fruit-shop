package core.basesyntax.operations;

import core.basesyntax.exeptions.NotValidDataException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class DataValidator {

    public void dataValidation(List<String> fruitsFromFile) {
        if (fruitsFromFile.size() == 0) {
            throw new NotValidDataException("You have entered empty list.");
        }
        if (!fruitsFromFile.get(0).equals("type,fruit,quantity,date")) {
            throw new NotValidDataException("File without correct upper line.");
        }
        for (int i = 1; i < fruitsFromFile.size(); i++) {
            String[] line = fruitsFromFile.get(i).split(",");
            String toCheck = line[0] + "," + line[1] + "," + line[2];
            if (!toCheck.matches("[s,b,r],[a-zA-Z]+,\\d+")) {
                throw new NotValidDataException("You have entered incorrect data type.");
            }
            try {
                LocalDate.parse(line[3]);
            } catch (DateTimeException e) {
                throw new NotValidDataException("You have entered incorrect date type.");
            }
        }
    }
}
