package core.basesyntax.impl;

import core.basesyntax.model.Fruits;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CsvFileReaderImplTest {
    public static final String CORRECT_FILE = "success.csv";
    public static final String CORRECT_CONTENT = "type,fruit,quantity\n"
            + "b,banana,20\n"
            + "b,apple,100";
    public static final List<TransactionDto> successTestList = new ArrayList<>();
    public static final String INCORRECT_FILE_NEGATIVE_NUMBER = "incorrect_file.csv";
    public static final String INCORRECT_CONTENT_NEGATIVE_NUMBER = "type,fruit,quantity\n"
            + "b,banana,-20\n"
            + "b,apple,100";
    public static final String INCORRECT_FILE_WRONG_LENGTH = "incorrect_file_wrong_length.csv";
    public static final String INCORRECT_CONTENT_WRONG_LENGTH = "type,fruit,quantity\n"
            + "b,banana,20,40\n";

    @BeforeAll
    static void beforeAll() {
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

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(CORRECT_FILE))) {
            bufferedWriter.write(CORRECT_CONTENT);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(INCORRECT_FILE_NEGATIVE_NUMBER))) {
            bufferedWriter.write(INCORRECT_CONTENT_NEGATIVE_NUMBER);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(INCORRECT_FILE_WRONG_LENGTH))) {
            bufferedWriter.write(INCORRECT_CONTENT_WRONG_LENGTH);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }
    }

    @Test
    void testReaderForCorrectFile() {
        FileReader testReader = new CsvFileReaderImpl(CORRECT_FILE);
        List<TransactionDto> testTransactions = testReader.readFromFile();
        assertEquals(testTransactions, successTestList);
    }

    @Test
    void testReaderForNegativeNumber() {
        FileReader testReader = new CsvFileReaderImpl(INCORRECT_FILE_NEGATIVE_NUMBER);
        assertThrows(RuntimeException.class, testReader::readFromFile);
    }

    @Test
    void testReaderForWrongLength() {
        FileReader testReader = new CsvFileReaderImpl(INCORRECT_FILE_WRONG_LENGTH);
        assertThrows(RuntimeException.class, testReader::readFromFile);
    }

    @AfterAll
    static void afterAll() {
        File testFile = new File(CORRECT_FILE);
        testFile.delete();

        testFile = new File(INCORRECT_FILE_NEGATIVE_NUMBER);
        testFile.delete();

        testFile = new File(INCORRECT_FILE_WRONG_LENGTH);
        testFile.delete();
    }
}
