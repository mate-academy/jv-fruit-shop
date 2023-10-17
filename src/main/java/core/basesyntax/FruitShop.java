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
import core.basesyntax.service.impl.StorageItemDtoToCsvParserService;
import core.basesyntax.service.impl.VirtualStorageService;
import core.basesyntax.strategy.VirtualStorageOperationStrategy;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.StorageOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FruitShop {
    public static void main(String[] args) {
        final String inputFileName = "./sample_data/in/operations.csv";
        final String outputFileName = "./sample_data/out/remainders.csv";
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

        StorageService storageService = new VirtualStorageService(getVirtualStorageStrategy());
        storageService.update(storageOperationList);

        System.out.println("Done!\n");
        System.out.println("Getting remainders...");

        List<StorageItemDto> storageItemList = storageService.getRemainders();

        List<String> headers = new ArrayList<>();
        headers.add("fruit");
        headers.add("quantity");

        ParserService<String> dtoParserService =
                new StorageItemDtoToCsvParserService(storageItemList, headers);
        List<String> csvStorafeItemList = dtoParserService.parse();

        System.out.println("Done!\n");
        System.out.println("Writing data to file...");

        WriterService writerService = new CsvFileWriterService(outputFileName, csvStorafeItemList);
        writerService.write();

        storageService.clearStorage();

        System.out.println("\nDone! Stay fresh!");
    }

    public static VirtualStorageOperationStrategy getVirtualStorageStrategy() {
        HashMap<Operation, StorageOperationHandler> operationHandlers = new HashMap<>();

        operationHandlers.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlers.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperationHandler());

        return new VirtualStorageOperationStrategy(operationHandlers);
    }
}
