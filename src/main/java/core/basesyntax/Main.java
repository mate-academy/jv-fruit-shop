package core.basesyntax;

import core.basesyntax.dataconverter.DataConverter;
import core.basesyntax.dataconverter.DataConverterImpl;
import core.basesyntax.filereader.FileReader;
import core.basesyntax.filereader.FileReaderImpl;
import core.basesyntax.filewriter.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.reportgenerator.ReportGenerator;
import core.basesyntax.reportgenerator.ReportGeneratorImpl;
import core.basesyntax.shopservice.ShopService;
import core.basesyntax.shopservice.ShopServiceImpl;
import core.basesyntax.storage.Storage;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Читаем CSV-файл
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read("reportToRead.csv");

        // 2. Конвертируем строки в объекты FruitTransaction
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        // 3. Обрабатываем транзакции
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        // 4. Генерируем отчёт
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        // 5. Записываем отчёт в CSV
        FileWriterImpl fileWriter = new FileWriterImpl();
        fileWriter.write(report, "finalReport.csv");

        // 6. Выводим текущее состояние склада
        System.out.println("Склад после обработки:");
        System.out.println(Storage.getAllFruits());
    }
}
