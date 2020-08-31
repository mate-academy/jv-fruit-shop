package core.basesyntax;

import java.util.List;

public class FruitShop {
    public static void main(String[] args) {
        String readFromFilePath = "src/test/mainTest";
        String writeToFileName = "src/test/mainTestWriter";

        Storage storage = new Storage();

        FileReaderService fileReaderServiceImpl = new FileReaderServiceImpl();
        FileWriterService fileWriterServiceImpl = new FileWriterServiceImpl();

        DataParser dataParser = new DataParser();
        OperationStrategy operationStrategy = new OperationStrategy();
        List<List<String>> data = fileReaderServiceImpl.readFile(readFromFilePath, ",");
        for (List<String> row : data) {
            operationStrategy.fulfillAllOrders(row, storage, dataParser.mapToFruit(row));
        }
        TypesOfFruitsInStorage typesOfFruitsInStorage = new TypesOfFruitsInStorage();

        ReportService reportService = new ReportService();

        fileWriterServiceImpl.writeToFile(reportService.toGetReport(storage,
                typesOfFruitsInStorage.getTypesOfFruits(storage)), writeToFileName);
    }
}
