package core.basesyntax;

import core.basesyntax.exeptions.NotValidDataException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DataValidation {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    public void dataValidation(List<String> fruitsFromFile, List<String> rangeOfShop)
            throws NotValidDataException {
        if (fruitsFromFile == null || fruitsFromFile.size() == 0) {
            throw new NotValidDataException("You have entered empty list.");
        }
        if (fruitsFromFile.get(0).split(",")[0].equals("type")
                && fruitsFromFile.get(0).split(",")[1].equals("fruit")
                && fruitsFromFile.get(0).split(",")[2].equals("quantity")
                && fruitsFromFile.get(0).split(",")[3].equals("date")) {
            fruitsFromFile.remove(0);
        } else {
            throw new NotValidDataException("File without correct upper line.");
        }
        for (String s : fruitsFromFile) {
            String[] line = s.split(",");
            if (line.length != 4) {
                throw new NotValidDataException("You have entered incorrect data type.");
            }
            if (!line[0].equals("s") && !line[0].equals("b") && !line[0].equals("r")) {
                throw new NotValidDataException("You have entered incorrect transaction type.");
            }
            int count = 0;
            for (int i = 0; i < rangeOfShop.size(); i++) {
                if (line[1].toLowerCase().equals(rangeOfShop.get(i))) {
                    count++;
                }
            }
            if (count == 0) {
                throw new NotValidDataException("You have entered incorrect type of fruit.");
            }
            if (!line[2].matches("\\d+")) {
                throw new NotValidDataException("You have entered incorrect amount type.");
            }
            try {
                LocalDate dateSupply = LocalDate.parse(line[3], FORMATTER);
            } catch (Exception e) {
                throw new NotValidDataException("You have entered incorrect date type.");
            }
        }
    }
}
