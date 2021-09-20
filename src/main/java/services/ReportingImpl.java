package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.TransactionDto;
import services.operations.strategy.StrategyOperations;
import services.readfromfile.ReadingFromFile;
import services.readfromfile.ReadingFromFileImpl;
import storage.StorageReport;
import storage.StorageTransactions;

public class ReportingImpl implements Reporting {
    private StrategyOperations strategyOperations;

    public ReportingImpl(StrategyOperations strategyOperations) {
        this.strategyOperations = strategyOperations;
    }

    @Override
    public List<String> createReport(String filePath) {
        ReadingFromFile readingFromFile = new ReadingFromFileImpl();
        StorageTransactions storage = readingFromFile.readingFromFile(filePath);
        StorageReport storageReport = new StorageReport(new HashMap<>());
        for (TransactionDto transaction : storage.getStorage()) {
            if (!storageReport.getStorageReport().containsKey(transaction.getFruit())) {
                storageReport.getStorageReport()
                        .put(transaction.getFruit(), transaction.getAmount());
            }
            storageReport.getStorageReport().put(transaction.getFruit(),
                    strategyOperations.getOperation(
                            transaction.getOperationType()).getNewAmount(
                                    transaction, storageReport.getStorageReport()
                                    .get(transaction.getFruit())));
        }
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : storageReport.getStorageReport().entrySet()) {
            listReport.add(entry.getKey() + "," + entry.getValue());
        }
        return listReport;
    }
}
