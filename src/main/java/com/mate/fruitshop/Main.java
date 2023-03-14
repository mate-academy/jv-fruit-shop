package com.mate.fruitshop;

import com.mate.fruitshop.dao.impl.FruitStorageDaoImpl;
import com.mate.fruitshop.model.Transaction;
import com.mate.fruitshop.service.impl.CsvReaderServiceImpl;
import com.mate.fruitshop.service.impl.CsvWriterImpl;
import com.mate.fruitshop.service.impl.ReportCreatorServiceImpl;
import com.mate.fruitshop.service.impl.TransactionParserServiceImpl;
import com.mate.fruitshop.service.impl.TransactionsProcessingServiceImpl;
import java.util.List;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/resources/inputData.csv";
    public static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        List<String> csvLines = new CsvReaderServiceImpl().read(INPUT_FILE_NAME);
        List<Transaction> transactions = new TransactionParserServiceImpl().parse(csvLines);
        new TransactionsProcessingServiceImpl().process(transactions);
        String report = new ReportCreatorServiceImpl()
                .createReport(new FruitStorageDaoImpl().getAll());
        new CsvWriterImpl().writeToCsv(report, REPORT_FILE_NAME);
    }
}
