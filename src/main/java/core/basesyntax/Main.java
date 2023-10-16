package core.basesyntax;

import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.impl.FileWriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileWriterService writerService = new FileWriterServiceImpl();
        String content = "banana";
        String filePath = "src/test/resources/FileWriter.csv";
        writerService.write(content, filePath);
    }
}
