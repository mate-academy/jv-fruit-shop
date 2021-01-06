package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriter;
import org.junit.Test;

public class CsvFileWriterImplTest {
    private static CsvFileWriter fileWriter = new CsvFileWriterImpl();

    @Test(expected = RuntimeException.class)
    public void wrongPath() {
        String filePath = "*";
        fileWriter.writeData(filePath);
    }
}
