package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.service.IO.IOImpl.MyFileReader;
import core.basesyntax.service.IO.IOImpl.MyFileWriter;
import core.basesyntax.service.IO.MyReader;
import core.basesyntax.service.IO.MyWriter;
import core.basesyntax.service.Impl.RecordParserImpl;
import core.basesyntax.service.Impl.ReportGeneratorImpl;
import core.basesyntax.service.RecordParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.activity.Activity;

import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Activity> activities;
        List<String> input;
        Storage storage = new StorageImpl();
        MyReader reader = new MyFileReader();
        MyWriter writer = new MyFileWriter();
        RecordParser parser = new RecordParserImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report;
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/output.csv";

        input = reader.read(inputFilePath);
        activities = parser.parseRecords(input);
        for (Activity activity : activities) {
            activity.execute(storage);
        }
        report = reportGenerator.generate(storage);
        writer.write(outputFilePath, report);
    }
}
