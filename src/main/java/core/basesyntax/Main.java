package core.basesyntax;

import service.impl.ReaderServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        new ReaderServiceImpl().readFromFile("src/main/resources/file.txt");
        new WriterServiceImpl().writeToFile("src/main/resources/report.txt");
    }
}
