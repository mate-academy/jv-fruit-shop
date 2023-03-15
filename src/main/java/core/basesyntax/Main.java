package core.basesyntax;

import core.basesyntax.database.StorageOfFruits;
import core.basesyntax.service.CreateFruitTransactionList;
import core.basesyntax.service.CreateResultService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.impl.CreateFruitTransactionListImpl;
import core.basesyntax.service.impl.CreateResultServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.strategy.impl.ChooseStrategyHandlerImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE = "src/main/resources/output.txt";

    public static void main(String[] args) {
        ReadFromFileImpl readFromFile = new ReadFromFileImpl();
        List<String> list = readFromFile.getListOfDataFromFile(INPUT_FILE);
        CreateFruitTransactionList cft = new CreateFruitTransactionListImpl();
        FruitService fruitService = new FruitServiceImpl(new ChooseStrategyHandlerImpl());
        fruitService.chooseStrategy(cft.create(list));
        CreateResultService createResultService = new CreateResultServiceImpl();
        String resultToCsv = createResultService.create(StorageOfFruits.getFruits());
        WriteToFile writeTofile = new WriteToFileImpl();
        writeTofile.write(resultToCsv, OUTPUT_FILE);

    }
}
