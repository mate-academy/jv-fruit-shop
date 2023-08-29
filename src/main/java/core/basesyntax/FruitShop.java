package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ConverterService;
import core.basesyntax.serviceimpl.*;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ProcessData;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;

import java.util.List;

public class FruitShop {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        readerService.read("fileName.csv");
        ConverterService converterService = new ConverterServiceImpl();
        converterService.convert(Storage.stringList);
        ProcessData processData = new ProcessDataimpl();
        processData.processData(Storage.fruits);
        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportService();
        writerService.writeToFile("result.csv", reportService.createReport());


    }

}
