package core.basesyntax;

import core.basesyntax.db.dto.StorageItemDTO;
import core.basesyntax.db.dto.StorageOperationDTO;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.*;

import java.util.ArrayList;
import java.util.List;

public class FruitShop {
    public static void main(String[] args) {
        String inputFileName = "./sample_data/in/operations.csv";
        String outputFileName = "./sample_data/out/remainders.csv";
        boolean headersPresent = true;

        System.out.println("Hello, Fruits!");
        System.out.println("Start reading data from file...\n");

        ReaderService csvFileReaderService = new CsvFileReaderService(inputFileName);
        List<String> csvFileData = csvFileReaderService.read();

        System.out.println("Done!\n");
        System.out.println("Start parsing data...\n");

        ParserService<StorageOperationDTO> csvParserService =
                new CsvToStorageOperationDtoParserService(csvFileData, headersPresent);
        List<StorageOperationDTO> storageOperationList = csvParserService.parse();

        System.out.println("Done!\n");
        System.out.println("Processing data to virtual storage...\n");

        StorageService storageService = new VirtualStorageService();
        storageService.update(storageOperationList);

        System.out.println("Done!\n");
        System.out.println("Getting remainders...\n");

        List<StorageItemDTO> storageItemList = storageService.getRemainders();

        List<String> headers = new ArrayList<>();
        headers.add("fruit");
        headers.add("quantity");

        ParserService<String> dtoParserService = new StorageItemDtoToCsvParserService(storageItemList, headers);
        List<String> csvStorafeItemList = dtoParserService.parse();

        System.out.println("Done!\n");
        System.out.println("Writing data to file...\n");

        WriterService writerService = new CsvFileWriterService(outputFileName, csvStorafeItemList);
        writerService.write();

        storageService.clearStorage();

        System.out.println("\nDone! Stay fresh!");
    }
}
