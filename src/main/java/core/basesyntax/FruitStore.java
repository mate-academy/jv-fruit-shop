package core.basesyntax;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.exeptions.NotValidDataException;
import java.io.IOException;
import java.util.List;

public class FruitStore {
    private static FileWriter newFile = new FileWriter();
    private static ReadFromFile readingFromFileOperation = new ReadFromFile();
    private static OperationWithFruits operation = new OperationWithFruits();
    private static DataValidator dataValidator = new DataValidator();
    private static Parser parser = new Parser();

    public static void main(String[] args) throws NotValidDataException,
            NotEnoughFruitsException, IOException {
        String file1 = "txt2";
        List<String> fruitsFromFile = readingFromFileOperation.readFromFile(file1);
        dataValidator.dataValidation(fruitsFromFile);
        List<Transaction> transaction = parser.parser(fruitsFromFile);
        newFile.writeNewFile(operation.operationWithFruits(transaction));
    }
}
