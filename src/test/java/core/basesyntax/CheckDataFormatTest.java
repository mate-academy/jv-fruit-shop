package core.basesyntax;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.*;

public class CheckDataFormatTest {
    private static final String[] PROPER_FILE_HEADER = new String[]{"type", "fruit", "quantity", "date"};
    private static List<List<String>> dataFromProperFile;
    private static LocalFileReader newReader;

    @Before
    public void setUp() {
        newReader = new LocalFileReader();
        dataFromProperFile = new ArrayList<>();
        dataFromProperFile.add(Arrays.asList(PROPER_FILE_HEADER));
    }

    private static final String[] WRONG_OPERATION_TYPE = new String[]{"raw", "orange", "147", "2020-10-21"};
    private static final String[] WRONG_QUANTITY = new String[]{"s", "apple", "mistake", "2020-10-20"};
    private static final String[] WRONG_DATE = new String[]{"s", "apple", "29", "2020-10"};
    private static final String[] INCOMPLETE_DATA = new String[]{"s", "apple", "29", };
    private static final String[] APPROPRIATE_DATA = new String[]{"b", "apple", "14", "2020-10-21"};

    @Test
    public void getExceptionWhenWrongHeader() {
        dataFromProperFile.remove(0);
        try {
            newReader.checkDataFormat(APPROPRIATE_DATA, dataFromProperFile);
        } catch (IllegalFormatFlagsException message) {
            return;
        }
        Assert.fail("IllegalFormatFlagsException should be thrown");
    }

    @Test
    public void getExceptionWhenOperationIncompatible() {
        try {
            newReader.checkDataFormat(WRONG_OPERATION_TYPE, dataFromProperFile);
        } catch (IllegalFormatException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenQuantityIncompatible() {
        try {
            newReader.checkDataFormat(WRONG_QUANTITY, dataFromProperFile);
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenDateIncompatible() {
        try {
            newReader.checkDataFormat(WRONG_DATE, dataFromProperFile);
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void getExceptionWhenDataIncomplete() {
        try {
            newReader.checkDataFormat(INCOMPLETE_DATA, dataFromProperFile);
        } catch (IllegalArgumentException message) {
            return;
        }
        Assert.fail("IllegalArgumentException should be thrown");
    }

    @Test
    public void checkForAppropriateData() {
        boolean actualResult = newReader.checkDataFormat(APPROPRIATE_DATA, dataFromProperFile);
        Assert.assertTrue(actualResult);
    }
}
