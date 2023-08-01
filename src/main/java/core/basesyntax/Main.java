package core.basesyntax;

import core.basesyntax.service.DataConvertingToObjectsService;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.impl.CsvDataConvertingToObjectsService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.service.FileReaderService;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/main/resources/input.csv");
        FileReaderService fileReaderService = new CsvFileReaderService(file);
        DataConvertingToObjectsService dataConverting = new CsvDataConvertingToObjectsService(fileReaderService);
        DataProcessingService dataProcessing;
    }
}
