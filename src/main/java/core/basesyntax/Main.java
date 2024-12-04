package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.DataConverter;
import service.DataReader;
import service.FileWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.CsvDataReaderImpl;
import service.impl.CsvFileWriterImpl;
import service.impl.DataConverterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;

public class Main {
    public static void main(String[] args) {
        //Declare Map object "handlers" for determine operation
        Map<Operations, OperationStrategy> handlers = new HashMap<>();
        handlers.put(Operations.BALANCE, new Balance());
        handlers.put(Operations.PURCHASE, new Purchase());
        handlers.put(Operations.RETURN, new Return());
        handlers.put(Operations.SUPPLY, new Supply());

        //Read the data from source
        DataReader dataReader = new CsvDataReaderImpl();
        List<String> inputReport = dataReader.getDataFromFile("src/main/resources/balance.csv");

        //Convert received data from reader to particular format
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransfer> transfers = dataConverter.convertToTransfer(inputReport);

        //Process and store the data to DB
        ShopService shopService = new ShopServiceImpl(handlers);
        shopService.process(transfers);

        //Generate a report
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> transitionalReport = reportGenerator.getReport();

        //Write report to file CSV format
        FileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.writeToFile(transitionalReport, "report");
    }
}
