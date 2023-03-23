package core.basesyntax.service;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.filereader.FileParser;
import core.basesyntax.service.filereader.FileReader;
import core.basesyntax.service.filewriter.FileWriter;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private final TransactionDao transactionDao;
    private final FileReader fileReader;
    private final FileParser fileParser;
    private final FileWriter fileWriter;

    public ReportServiceImpl(TransactionDao transactionDao,
                             FileReader readFromFile, FileParser parseDataFromFile,
                             FileWriter writeToFile) {
        this.transactionDao = transactionDao;
        this.fileReader = readFromFile;
        this.fileParser = parseDataFromFile;
        this.fileWriter = writeToFile;
    }
    @Override
    public void createReport(String inputFileName, String reportFileName) {
        List<String> dataFromFile = fileReader.dataFromFile(inputFileName);
        List<FruitTransaction> parsedDataFromFile =
                fileParser.parsedFruitTransactions(dataFromFile);
        transactionDao.addAll(parsedDataFromFile);
        fileWriter.writeToFile(reportFileName);
    }
}
