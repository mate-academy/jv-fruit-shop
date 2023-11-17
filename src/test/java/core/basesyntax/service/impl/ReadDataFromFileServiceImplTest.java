package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReadDataFromFileServiceImplTest {
    private static final String PATH_BALANCE = "src/main/resources/balanceFruits.csv";
    private static final String PATH_WRONG = "src/main/resources/balanceFruits1.csv";
    private static ReadDataFromFileServiceImpl readDataFromFileService;

    @BeforeAll
    static void beforeAll() {
        readDataFromFileService = new ReadDataFromFileServiceImpl();
    }

    @BeforeEach
    void setUp() {

    }

    @Test
    void readFromFile_ReadInfo_Ok() {
        List<String> listStr = readDataFromFileService.readFromFile(PATH_BALANCE);
        assertNotEquals(listStr.size(), 0);

    }

    @Test
    void readFromFile_ReadInfoFileNotExist_NotOk() {
        assertThrows(RuntimeException.class,
                () -> readDataFromFileService.readFromFile(PATH_WRONG));
    }
}



