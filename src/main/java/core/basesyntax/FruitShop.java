package core.basesyntax;

public class FruitShop {
    public static void main(String[] args) {
        String readFromFilePath = "src/test/mainTest";
        String writeToFileName = "src/test/mainTestWriter";
        String separator = ",";

        Storage storage = new Storage();

        FileReaderService fileReaderServiceImpl = new FileReaderServiceImpl();

        FileWriterService fileWriterServiceImpl = new FileWriterServiceImpl();

        OperationStrategy operationStrategy = new OperationStrategy();
        operationStrategy.fulfillAllOrders(fileReaderServiceImpl
                .readFile(readFromFilePath, ","), storage);

        TypesOfFruitsInStorage typesOfFruitsInStorage = new TypesOfFruitsInStorage();

        ReportService reportService = new ReportService();

        fileWriterServiceImpl.writeFile(reportService.toGetReport(storage,
                typesOfFruitsInStorage.getTypesOfFruits(storage)), separator, writeToFileName);
    }
}
