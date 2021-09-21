package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import services.operations.strategy.OperationsStrategy;
import services.stockservice.StockService;
import services.stockservice.StockServiceImpl;
import storage.Stock;

public class ReportingImpl implements Reporting {
    private static final String START_MESSAGE = "fruit,quantity";
    private OperationsStrategy strategyOperations;

    public ReportingImpl(OperationsStrategy strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public List<String> createReport(List<TransactionDto> storage) {
        StockService stockService = new StockServiceImpl(strategyOperations);
        Stock storageReport = stockService.getStock(storage);
        List<String> listReport = new ArrayList<>();
        listReport.add(START_MESSAGE);
        for (Map.Entry<String, Integer> entry : storageReport.getStockStorage().entrySet()) {
            listReport.add(entry.getKey() + "," + entry.getValue());
        }
        return listReport;
    }
}
