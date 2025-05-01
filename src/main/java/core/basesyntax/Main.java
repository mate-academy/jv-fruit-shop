package core.basesyntax;

import java.io.IOException;
import service.DataConverter;
import service.FileReader;
import service.ReportGenerator;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";
    private static final String OUTPUT_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) throws IOException {
        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        ShopService shopService = new ShopServiceImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        FileWriterImpl fileWriterService = new FileWriterImpl(fileReader, dataConverter,
                shopService, reportGenerator);
        fileWriterService.write(INPUT_FILE, OUTPUT_FILE);
        String report = reportGenerator.getReport();
        System.out.println(report);
    }
}
