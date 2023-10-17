package core.basesyntax;

import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.impl.CsvFileWriterService;
import core.basesyntax.service.impl.CsvToStorageOperationDtoParserService;
import core.basesyntax.service.impl.ReportGenerationService;
import core.basesyntax.service.impl.VirtualStorageService;
import core.basesyntax.strategy.SimpleOperationStrategy;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.StorageOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        final String inputFileName = "./src/main/resources/operations.csv";
        final String outputFileName = "./src/main/resources/remainders.csv";
        final List<String> reportHeaders = List.of("fruit", "quantity");
        final Map<Operation, StorageOperationHandler> virtualStorageOperationStrategy = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler()
        );
        boolean headersPresent = true;

        System.out.println("Hello, Fruits!\n");
        System.out.println("Start reading data from file...");

        ReaderService csvFileReaderService = new CsvFileReaderService(inputFileName);
        List<String> csvFileData = csvFileReaderService.read();

        System.out.println("Done!\n");
        System.out.println("Start parsing data...");

        ParserService<StorageOperationDto> csvParserService =
                new CsvToStorageOperationDtoParserService(csvFileData, headersPresent);
        List<StorageOperationDto> storageOperationList = csvParserService.parse();

        System.out.println("Done!\n");
        System.out.println("Processing data to virtual storage...");

        StorageService storageService = new VirtualStorageService(
                new SimpleOperationStrategy(virtualStorageOperationStrategy));
        storageService.apply(storageOperationList);

        System.out.println("Done!\n");
        System.out.println("Getting remainders...");

        List<StorageItemDto> storageItemList = storageService.getRemainders();

        ParserService<String> dtoParserService =
                new ReportGenerationService(storageItemList, reportHeaders);
        List<String> csvStorafeItemList = dtoParserService.parse();

        System.out.println("Done!\n");
        System.out.println("Writing data to file...");

        WriterService writerService = new CsvFileWriterService(outputFileName, csvStorafeItemList);
        writerService.write();

        storageService.clearStorage();

        System.out.println("\nDone! Stay fresh!");
    }
}
