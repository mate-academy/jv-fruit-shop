package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        DataConverter dataConverter = new DataConverter();
        FruitDB fruitDB = new FruitDB();
        DataOperationStrategy operationStrategy = new DefaultDataOperationStrategy();
        DataProcessor dataProcessor = new DataProcessor(fruitDB, operationStrategy);
        ReportGenerator reportGenerator = new ReportGenerator(fruitDB);
        FileWriter fileWriter = new FileWriter();

        FruitShop fruitShop = new FruitShop(
                fileReader, dataConverter, dataProcessor, reportGenerator, fileWriter
        );

        fruitShop.run("input.csv", "output.csv");
    }
}
