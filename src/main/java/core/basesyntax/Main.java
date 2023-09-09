package core.basesyntax;

import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        ReadService readService = new ReadServiceImpl();
        WriteService writeService = new WriteServiceImpl();
        
        fruitTransactionService.createNewFruitTransaction(
                readService.readFile(Path.of("src/main/java/resources/inputFile.csv")));
        writeService.writeToFile(Path.of("src/main/java/resources/reportFile.csv"));
    }
}
