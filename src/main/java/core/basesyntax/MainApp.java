package core.basesyntax;

import core.basesyntax.filereader.FileReaderService;
import core.basesyntax.filereader.LocalFileReaderService;
import core.basesyntax.filewriter.FileWriterService;
import core.basesyntax.filewriter.LocalFileWriterService;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Storage storage = new Storage();
        FileReaderService readerService = new LocalFileReaderService();
        List<List<String>> toDoList = readerService.readFile(args[0]);
        FruitStoreService fruitStoreService = new FruitStoreService();
        fruitStoreService.processData(toDoList);
        FileWriterService fileWriterServise = new LocalFileWriterService();
        fileWriterServise.writeFile(storage.getAllFruits(), args[1]);
    }
}
