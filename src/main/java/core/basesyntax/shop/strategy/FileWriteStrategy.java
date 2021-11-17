package core.basesyntax.shop.strategy;

import core.basesyntax.shop.WriteToFile;
import core.basesyntax.shop.impl.WriteToCsvFile;

public class FileWriteStrategy {
    public static WriteToFile chooseWriteFileFormat(String filename) {
        String extension = filename.replaceAll("(.+\\.(\\w+))",
                "$2").toLowerCase();
        switch (extension) {
            case "csv":
                return new WriteToCsvFile();
            default:
                throw new RuntimeException("Invalid file type");
        }
    }
}
