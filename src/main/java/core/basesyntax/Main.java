package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.FileReaderCsvImpl;
import core.basesyntax.service.impl.ParseCsvImpl;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String NAME_FILE = "src/main/resources/fruit-shop.csv";

    public static void main(String[] args) {
        FileReader fileReaderCsv = new FileReaderCsvImpl();
        List<String> fruitsFromFile = fileReaderCsv.readFromFile(NAME_FILE);
        System.out.println(fruitsFromFile);
        System.out.println(Operation.getOperationByLetter("s"));
        ParseCsvImpl parseCsvImple = new ParseCsvImpl();
        List<TransactionDto> transactionDtoList = parseCsvImple.parse(fruitsFromFile);
        System.out.println(transactionDtoList.toString());
    }
}
