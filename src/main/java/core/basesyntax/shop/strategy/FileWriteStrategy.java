package core.basesyntax.shop.strategy;

import core.basesyntax.shop.service.Writer;
import core.basesyntax.shop.service.impl.WriterToCsvFile;

public interface FileWriteStrategy {
    static Writer chooseWriteFileFormat(String filename) {
        String extension = filename.replaceAll("(.+\\.(\\w+))",
                "$2").toLowerCase();
        switch (extension) {
            case "csv":
                return new WriterToCsvFile();
            default:
                throw new RuntimeException("Invalid file type");
        }
    }
}
