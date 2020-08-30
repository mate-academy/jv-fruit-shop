package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.ReaderFromFile;
import core.basesyntax.service.WriterToFile;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileService fileService = new ReaderFromFile();
        List<List<String>> file = fileService.readFile("src/main/resources/info.csv");
        OrderParserLogic parserLogic = new OrderParserLogic();
        for (List<String> list : file) {
            parserLogic.parseToStorage(list);
        }
        Report report = new Report();
        WriterToFile writeToFile = new WriterToFile();
        writeToFile.print(report.getReport(),"src/main/resources/output.csv");
    }
}
