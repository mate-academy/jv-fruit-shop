package core.basesyntax.service;

import core.basesyntax.converter.DataConverter;
import core.basesyntax.file.reader.FileReader;
import core.basesyntax.file.writer.FileWriter;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final DataConverter dataConverter;
    private final OperationStrategy operationStrategy;
    private final ReportGenerator reportGenerator;

    public FruitShopServiceImpl(FileReader fileReader,
                                FileWriter fileWriter,
                                DataConverter dataConverter,
                                OperationStrategy operationStrategy,
                                ReportGenerator reportGenerator) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.dataConverter = dataConverter;
        this.operationStrategy = operationStrategy;
        this.reportGenerator = reportGenerator;
    }

    @Override
    public void processTransactions(String inputFilePath, String outputFilePath) {
        List<String> inputData = fileReader.read(inputFilePath);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputData);

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.apply(transaction);
        }

        String report = reportGenerator.getReport();
        fileWriter.write(report, outputFilePath);
    }
}
