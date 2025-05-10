package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionConverter;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionConverterImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String inputFilePass = "src/main/resources/FileWithInputData.csv";
        final String newFilePass = "src/main/resources/FileWithRestOfFruits.csv";
        Reader reader = new ReaderImpl();
        TransactionConverter convertFileToList = new TransactionConverterImpl();
        TransactionService transactionService = new TransactionServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        Writer writer = new WriterImpl();
        List<String> data = reader.read(inputFilePass);
        List<FruitTransaction> fruitTransactions = convertFileToList.convert(data);
        transactionService.distribute(fruitTransactions);
        String report = reportService.storageToString();
        writer.write(report,newFilePass);
    }
}
