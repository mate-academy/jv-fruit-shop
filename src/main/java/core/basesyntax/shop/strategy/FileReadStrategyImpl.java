package core.basesyntax.shop.strategy;

import core.basesyntax.shop.service.Reader;
import core.basesyntax.shop.service.impl.ReaderFromCsvFile;

public class FileReadStrategyImpl {
    public static Reader chooseReadFileFormat(String filename) {
        String extension = filename.replaceAll("(.+\\.(\\w+))","$2").toLowerCase();
        switch (extension) {
            case "csv":
                return new ReaderFromCsvFile();
            default:
                throw new RuntimeException("Invalid file type");
        }
    }
}
