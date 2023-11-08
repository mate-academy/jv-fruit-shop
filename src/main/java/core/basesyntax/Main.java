package core.basesyntax;

<<<<<<< HEAD
import core.basesyntax.dao.OperationManager;
import core.basesyntax.dao.OperationManagerImpl;
import core.basesyntax.db.FruitDB;
=======
import core.basesyntax.dao.report.ReportCreator;
import core.basesyntax.dao.report.ReportCreatorImpl;
import core.basesyntax.dao.transaction.Transaction;
import core.basesyntax.dao.transaction.TransactionImpl;
>>>>>>> hw-second-solution
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;

public class Main {
<<<<<<< HEAD
    private static final String READ_FILE_NAME = "file.csv";
    private static final String WRITE_FILE_NAME = "report_file.csv";

    public static void main(String[] args) {
        FruitDB fruitDB = new FruitDB();
        FileReader fileReader = new FileReaderImpl();
        OperationManager operationManager = new OperationManagerImpl();

        FileWriter fileWriter = new FileWriterImpl();

        operationManager
                .addInfoToDB(
                        fileReader.readFromFile(READ_FILE_NAME), fruitDB);
        fileWriter
                .writeToFile(fruitDB.getAllFruits(), WRITE_FILE_NAME);
=======
    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriterImpl();
        FileReader fileReader = new FileReaderImpl();
        Transaction transaction = new TransactionImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();

        transaction.getTransactionList(fileReader.readFile("file.csv"));
        fileWriter.writeReport(reportCreator.updateStorage(), "report_file.csv");
>>>>>>> hw-second-solution
    }
}
