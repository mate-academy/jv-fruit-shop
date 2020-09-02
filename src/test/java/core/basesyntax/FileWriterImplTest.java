package core.basesyntax;

import core.basesyntax.exeptions.NotValidDataException;
import core.basesyntax.operations.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FileWriterImplTest {
    private static final String READ_FILE_NAME = "src/test/resources/txt2.csv";
    public final static String WRITE_FILE_NAME = "file1.txt";
    private static FileWriterImpl newFile = new FileWriterImpl();
    private static FileReaderImpl readingFromFileOperation = new FileReaderImpl();
    private static OperationWithFruits operation = new OperationWithFruits();
    private static DataValidator dataValidator = new DataValidator();
    private static Parser parser = new Parser();

    @Test
    public void text_Writer_Test_OK() throws NotValidDataException, IOException {
        List<String> fruitsFromFile = readingFromFileOperation.readFromFile(READ_FILE_NAME);
        dataValidator.dataValidation(fruitsFromFile);
        List<Transaction> transaction = parser.parser(fruitsFromFile);
        newFile.writeNewFile(operation.operationWithFruits(transaction));

        File file = new File(WRITE_FILE_NAME);
        List<String> textFromFile = new ArrayList<>();
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            textFromFile.add(sc.nextLine().toLowerCase());
        }
        Assert.assertEquals(4, textFromFile.size());
    }
}
