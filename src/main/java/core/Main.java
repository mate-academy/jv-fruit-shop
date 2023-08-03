package core;

import core.db.Storage;
import core.model.FruitTransaction;
import core.service.impl.ReaderFromFileImp;
import core.service.impl.ReportServiceImpl;
import core.service.impl.TransactionParserImpl;

import java.util.List;

public class Main {


    public static void main(String[] args) {
        /*String, String[], List<String> fileContent = fileReaderImpl.read(filePath);
        List<FruitTransaction> transactionList = transactionParser.parse(fileContent);
        fruitTransactionService.applyTransaction(transactionList);
        String report = reportServiceImpl.generate();
        writer.write(report, filePath);*/


        Storage.storage.put("ananas", 10);
        Storage.storage.put("banan", 100);

        ReportServiceImpl reportService = new ReportServiceImpl();
        System.out.println(reportService.createReport());
    }

}
