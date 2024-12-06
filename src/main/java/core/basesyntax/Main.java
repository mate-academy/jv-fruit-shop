package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.DataConverter;
import service.DataReader;
import service.DataWriter;
import service.ReportGenerator;
import service.ShopService;
import service.impl.CsvDataReaderImpl;
import service.impl.CsvDataWriterImpl;
import service.impl.DataConverterImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;

public class Main {
    public static void main(String[] args) {
        //Declare Map object "handlers" for determine operation
        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceHandler());
        handlers.put(Operation.PURCHASE, new PurchaseHandler());
        handlers.put(Operation.RETURN, new ReturnHandler());
        handlers.put(Operation.SUPPLY, new SupplyHandler());

        //Read the data from source
        DataReader dataReader = new CsvDataReaderImpl();
        final List<String> inputReport
                = dataReader.getDataFromFile("src/main/resources/balance.csv");

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
        DataWriter fileWriter = new CsvDataWriterImpl();
        fileWriter.writeToFile(transitionalReport, "report");
    }
}
