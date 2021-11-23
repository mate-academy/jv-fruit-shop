package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.service.RecordParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.activity.Activity;
import core.basesyntax.service.io.MyReader;
import core.basesyntax.service.io.MyWriter;
import core.basesyntax.service.io.ioimpl.MyFileReader;
import core.basesyntax.service.io.ioimpl.MyFileWriter;
import core.basesyntax.service.serviceimpl.RecordParserImpl;
import core.basesyntax.service.serviceimpl.ReportGeneratorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/output.csv";

        MyReader reader = new MyFileReader();
        List<String> input = reader.read(inputFilePath);
        RecordParser parser = new RecordParserImpl();
        List<Activity> activities = parser.parseRecords(input);
        Storage storage = new StorageImpl();
        for (Activity activity : activities) {
            activity.execute(storage);
        }
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generate(storage);
        MyWriter writer = new MyFileWriter();
        writer.write(outputFilePath, report);
    }
}
