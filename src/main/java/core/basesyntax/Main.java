package core.basesyntax;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.DataConvertService;
import core.basesyntax.service.DataProcessService;
import core.basesyntax.service.ReadFromCsvFileService;
import core.basesyntax.service.WriteToCsvFileService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.DataConvertServiceImpl;
import core.basesyntax.service.impl.DataProcessServiceImpl;
import core.basesyntax.service.impl.ReadFromCsvFileServiceImpl;
import core.basesyntax.service.impl.WriteToCsvFileServiceImpl;

public class Main {
    private static final String FIRST_TEST_CSV = "fruits1.csv";
    private static final String SECOND_TEST_CSV = "fruits2.csv";
    private static final String THIRD_TEST_CSV = "fruits3.csv";

    public static void main(String[] args) {
        ReadFromCsvFileService reader = new ReadFromCsvFileServiceImpl();
        DataConvertService convertor = new DataConvertServiceImpl();
        DataProcessService processor = new DataProcessServiceImpl();
        CreateReportService reportCreator = new CreateReportServiceImpl();
        WriteToCsvFileService writer = new WriteToCsvFileServiceImpl();

        processor.processFruits(convertor.convert(reader.readFile(SECOND_TEST_CSV)));
        writer.write(reportCreator.createReport());
    }
}
