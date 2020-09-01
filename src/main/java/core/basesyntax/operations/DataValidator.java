package core.basesyntax.operations;

import core.basesyntax.exeptions.NotValidDataException;
import java.time.LocalDate;
import java.util.List;

public class DataValidator {

    public void dataValidation(List<String> fruitsFromFile)
            throws NotValidDataException {
        if (fruitsFromFile.size() == 0) {
            throw new NotValidDataException("You have entered empty list.");
        }
        if (fruitsFromFile.get(0).equals("type,fruit,quantity,date")) {
            fruitsFromFile.remove(0);
        } else {
            throw new NotValidDataException("File without correct upper line.");
        }
        for (String s : fruitsFromFile) {
            String[] line = s.split(",");
            String toCheck = line[0] + "," + line[1] + "," + line[2];
            if (!toCheck.matches("[s,b,r],[a-zA-Z]+,\\d+")) {
                throw new NotValidDataException("You have entered incorrect data type.");
            }
            try {
                LocalDate dateSupply = LocalDate.parse(line[3]);
            } catch (Exception e) {
                throw new NotValidDataException("You have entered incorrect date type.");
            }
        }
    }
}
