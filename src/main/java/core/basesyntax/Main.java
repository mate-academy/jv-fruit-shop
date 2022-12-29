package core.basesyntax;

import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/file.csv");
        File toFileName = new File("src/main/resources/report.csv");
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        ProcessServiceImpl processService = new ProcessServiceImpl();
        WriteServiceImpl writeService = new WriteServiceImpl();
        String lines = readerService.readFromFile(file);
        String report = processService.getReport(lines);
        writeService.writeReport(toFileName, report);
    }
}
