package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import services.operations.strategy.OperationsStrategy;
import services.readfromfile.ReadingFromFile;
import services.readfromfile.ReadingFromFileImpl;
import services.stockservice.StockService;
import services.stockservice.StockServiceImpl;
import storage.Stock;
import storage.StorageTransactions;

public class ReportingImpl implements Reporting {
    private OperationsStrategy strategyOperations;

    public ReportingImpl(OperationsStrategy strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public List<String> createReport(String filePath) {
        ReadingFromFile readingFromFile = new ReadingFromFileImpl();
        StorageTransactions storage = readingFromFile.readingFromFile(filePath);
        StockService stockService = new StockServiceImpl(strategyOperations);
        Stock storageReport = stockService.getStock(storage);
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : storageReport.getStockStorage().entrySet()) {
            listReport.add(entry.getKey() + "," + entry.getValue());
        }
        return listReport;
    }
}
