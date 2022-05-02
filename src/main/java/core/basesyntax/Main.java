package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileReading;
import core.basesyntax.service.FileWriting;
import core.basesyntax.service.FruitBuilder;
import core.basesyntax.service.OperationSupplier;
import core.basesyntax.service.impl.FileReadingImpl;
import core.basesyntax.service.impl.FileWritingImpl;
import core.basesyntax.service.impl.FruitBuilderImpl;
import core.basesyntax.service.impl.OperationSupplierImpl;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private static final OperationSupplier operationSupplier = new OperationSupplierImpl();
    private static final Path PATH_OF_INPUT_FILE = Path.of("src/main/resources/input.csv");
    private static final Path PATH_OF_OUTPUT_FILE = Path.of("src/main/resources/report.csv");

    public static void main(String[] args) {
        FileReading fileReading = new FileReadingImpl();
        List<String> stringsFromFile = fileReading.readFromFile(PATH_OF_INPUT_FILE);

        FruitBuilder fruitBuilder = new FruitBuilderImpl();
        List<Fruit> fruitList = fruitBuilder.fruitBuilder(stringsFromFile);

        for (Fruit fruit: fruitList) {
            operationSupplier.getOperation(fruit).getCalculate(fruit);
        }

        FileWriting fileWriting = new FileWritingImpl();
        fileWriting.writeToFile(PATH_OF_OUTPUT_FILE);
    }
}
