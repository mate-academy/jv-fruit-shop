package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.WriteToFile;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<List<String>> file = fileService.readFile("src/main/resources/info.csv");
        OrderParserLogic parserLogic = new OrderParserLogic();
        for (List<String> list : file) {
            parserLogic.parse(list);
        }
        WriteToFile writeToFile = new WriteToFile();
        writeToFile.print("src/main/resources/output");
    }
}
