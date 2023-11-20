package core.basesyntax;

import core.basesyntax.service.impl.CsvReadServiceImpl;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FruitOperationStrategy;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    private static final String INPUT_FILE_NAME = "fruits.csv";
    private static final String REPORT_FILE_NAME = "report.csv";
    private static final String INPUT_FILE_CONTENT = """
                    type,fruit,quantity
                    b,banana,20
                    b,apple,100
                    b,orange,10
                    s,banana,100
                    p,banana,13
                    r,apple,10
                    p,apple,20
                    p,banana,5
                    s,blueberry,59
                    p,banana,20
                    r,apple,10
                    p,blueberry,50
                    p,banana,5
                    s,pineapple,50""";

    public static void main(String[] args) {
        CsvReadServiceImpl readerService = new CsvReadServiceImpl();
        DataParserServiceImpl parserService = new DataParserServiceImpl();
        FruitOperationStrategy strategy = new FruitOperationStrategy();
        ReportServiceImpl reportService = new ReportServiceImpl();

        File file = new File(INPUT_FILE_NAME);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(INPUT_FILE_CONTENT);
        } catch (IOException e) {
            throw new RuntimeException("Can't write a file");
        }

        parserService.parse(readerService.read(INPUT_FILE_NAME))
                .forEach(t -> strategy.getOperationService(t).processOperation(t));

        reportService.createReport();

        System.out.println(readerService.read(REPORT_FILE_NAME));
    }
}
