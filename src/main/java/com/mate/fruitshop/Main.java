package com.mate.fruitshop;

import com.mate.fruitshop.model.Transaction;
import com.mate.fruitshop.service.CsvReaderService;
import com.mate.fruitshop.service.ReportCreatorService;
import com.mate.fruitshop.service.ReportWriter;
import com.mate.fruitshop.service.TransactionParserService;
import com.mate.fruitshop.service.TransactionsProcessingService;
import com.mate.fruitshop.service.impl.CsvReaderServiceImpl;
import com.mate.fruitshop.service.impl.ReportCreatorServiceImpl;
import com.mate.fruitshop.service.impl.ReportWriterImpl;
import com.mate.fruitshop.service.impl.TransactionParserServiceImpl;
import com.mate.fruitshop.service.impl.TransactionsProcessingServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvReaderService csvReader = new CsvReaderServiceImpl();
        TransactionParserService transactionReader = new TransactionParserServiceImpl();
        TransactionsProcessingService transactionsProcessor =
                new TransactionsProcessingServiceImpl();
        ReportCreatorService reportCreator = new ReportCreatorServiceImpl();
        ReportWriter writer = new ReportWriterImpl();

        List<String> csvLines = csvReader.read("data/inputData.csv");
        List<Transaction> transactions = transactionReader.read(csvLines);
        transactionsProcessor.process(transactions);
        String report = reportCreator.createReport();
        writer.writeReportToFile(report, "data/report.csv");
    }
}
