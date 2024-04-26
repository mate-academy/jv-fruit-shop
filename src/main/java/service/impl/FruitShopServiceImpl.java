package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.FruitOperationTypeParser;
import service.FruitShopService;
import service.FruitTransactionParser;
import service.Reader;
import service.ReportService;
import service.TransactionProcessor;
import service.Writer;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String RESOURCES_PATH = "src/main/resources/";
    private final Reader reader = new FileReaderImpl();
    private final TransactionProcessor transactionProcessor = new TransactionProcessorImpl();

    private final FruitOperationTypeParser fruitOperationTypeParser
            = new FruitOperationTypeParserImpl();
    private final FruitTransactionParser fruitTransactionParser
            = new FruitTransactionParserImpl(fruitOperationTypeParser);

    private final FruitDao fruitDao = new FruitDaoImpl();
    private final ReportService reportService = new ReportServiceImpl(fruitDao);

    private final Writer writer = new FileWriter();

    @Override
    public void processData(String readFromFileName, String writeToFileName) {
        List<String> data = reader.readFile(RESOURCES_PATH + readFromFileName);
        List<FruitTransaction> fruits
                = fruitTransactionParser.parseTransaction(data);
        transactionProcessor.processTransactions(fruits);
        String content = reportService.getReport();
        writer.writeToFile(RESOURCES_PATH + writeToFileName, content);
    }
}
