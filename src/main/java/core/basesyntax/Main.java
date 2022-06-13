package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.StrategyChooser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.StrategyChooserImpl;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static final String inputPath = "src/main/resources/input.csv";
    private static final String resultPath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        // getting file with data
        File input = new File(inputPath);

        //prepare service to get data
        FileReaderService fileReaded = new FileReaderImpl();

        //getting data
        List<String[]> csvEntries = fileReaded.readInput(input);

        //prepare service to aggregate data
        StrategyChooser strategyChooser = new StrategyChooserImpl();

        //get iterator to aggregate data lines
        Iterator<String[]> iterator = csvEntries.iterator();
        String[] passHead = iterator.next();

        //aggregating lines to storage
        while (iterator.hasNext()) {
            String[] line = iterator.next();
            strategyChooser.getStrategy(line).execute(line[1], Integer.parseInt(line[2]));
        }

        //preparing data to transfer to file
        ReportWriter reportWriter = new ReportWriter();
        reportWriter.writeHead();
        for (String key : Storage.fruits.keySet()) {
            reportWriter.writeLine(key, Storage.fruits.get(key));
        }

        //preparing service for writing report file
        File output = new File(resultPath);
        FileWriterService fileWriter = new FileWriterImpl();
        fileWriter.writeTheResult(output, reportWriter.getReport());
    }
}
