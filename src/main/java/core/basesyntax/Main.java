package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.io.MyReader;
import core.basesyntax.io.MyWriter;
import core.basesyntax.io.ioimpl.MyFileReader;
import core.basesyntax.io.ioimpl.MyFileWriter;
import core.basesyntax.model.Record;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.RecordParser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.serviceimpl.RecordParserImpl;
import core.basesyntax.service.serviceimpl.ReportGeneratorImpl;
import core.basesyntax.strategy.TransactionSupplier;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/output.csv";

        MyReader reader = new MyFileReader();
        List<String> input = reader.read(inputFilePath);
        RecordParser parser = new RecordParserImpl();
        List<Record> records = parser.parseRecords(input);
        Storage storage = new StorageImpl();
        for (Record record : records) {
            Transaction transaction = TransactionSupplier.get(record);
            transaction.apply(storage);
        }
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generate(storage);
        MyWriter writer = new MyFileWriter();
        writer.write(outputFilePath, report);
    }
}
