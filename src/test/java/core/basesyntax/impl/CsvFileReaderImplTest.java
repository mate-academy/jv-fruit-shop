package core.basesyntax.impl;

import static org.junit.Assert.assertEquals;

import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CsvFileReaderImplTest {
    public static final String CORRECT_FILE = "success_reading.csv";
    public static final String CORRECT_CONTENT = "type,fruit,quantity\n"
            + "b,banana,20\n"
            + "b,apple,100\n";
    public static final List<TransactionDto> successTestList = new ArrayList<>();
    public static final String INCORRECT_FILE_NEGATIVE_NUMBER = "incorrect_file_reading.csv";
    public static final String INCORRECT_CONTENT_NEGATIVE_NUMBER = "type,fruit,quantity\n"
            + "b,banana,-20\n"
            + "b,apple,100\n";
    public static final String INCORRECT_FILE_WRONG_LENGTH
            = "incorrect_file_wrong_length_reading.csv";
    public static final String INCORRECT_CONTENT_WRONG_LENGTH
            = "type,fruit,quantity\n"
            + "b,banana,20,40\n";

    @BeforeClass
    public static void beforeClass() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setOperation(Operation.fromString("b"));
        transactionDto.setFruit(new Fruits("banana"));
        transactionDto.setQuantity(20);
        TransactionDto transactionDto2 = new TransactionDto();
        transactionDto2.setOperation(Operation.fromString("b"));
        transactionDto2.setFruit(new Fruits("apple"));
        transactionDto2.setQuantity(100);
        successTestList.add(transactionDto);
        successTestList.add(transactionDto2);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io
                .FileWriter(CORRECT_FILE))) {
            bufferedWriter.write(CORRECT_CONTENT);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io
                .FileWriter(INCORRECT_FILE_NEGATIVE_NUMBER))) {
            bufferedWriter.write(INCORRECT_CONTENT_NEGATIVE_NUMBER);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io
                .FileWriter(INCORRECT_FILE_WRONG_LENGTH))) {
            bufferedWriter.write(INCORRECT_CONTENT_WRONG_LENGTH);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }
    }

    @Test
    public void testReaderForCorrectFile() {
        FileReader testReader = new CsvFileReaderImpl(CORRECT_FILE);
        List<TransactionDto> testTransactions = testReader.readFromFile();
        assertEquals(testTransactions, successTestList);
    }

    @Test(expected = RuntimeException.class)
    public void testReaderForNegativeNumber() {
        FileReader testReader = new CsvFileReaderImpl(INCORRECT_FILE_NEGATIVE_NUMBER);
        testReader.readFromFile();
    }

    @Test(expected = RuntimeException.class)
    public void testReaderForWrongLength() {
        FileReader testReader = new CsvFileReaderImpl(INCORRECT_FILE_WRONG_LENGTH);
        testReader.readFromFile();
    }

    @AfterClass
    public static void afterClass() {
        File testFile = new File(CORRECT_FILE);
        testFile.delete();

        testFile = new File(INCORRECT_FILE_NEGATIVE_NUMBER);
        testFile.delete();

        testFile = new File(INCORRECT_FILE_WRONG_LENGTH);
        testFile.delete();
    }
}
