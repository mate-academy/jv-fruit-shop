package core.basesyntax.services;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class DataFileReaderTest{
    private static final String FILE_PATH = "src/test/resources/testFile.csv";
    private static final String EMPTY_FILE_PATH = "src/test/resources/emptyTestFile.csv";
    private static final String NON_EXISTED_FILE_PATH = "src/test/resources/111.csv";
    private static DataFileReader fileReader;
    private static List<FruitDto> expected;

    @BeforeClass
    public static void beforeClass(){
        fileReader = new DataFileReader();
    }

    @Before
    public void beforeEach(){
        expected = new ArrayList<>();
    }

    @Test
    public void readFromValidFile(){
        expected.add(new FruitDto("s","banana",100,"2020-10-17"));
        expected.add(new FruitDto("b","banana",13,"2020-10-15"));
        expected.add(new FruitDto("b","orange",30,"2020-10-15"));

        List<FruitDto> actual = fileReader.readDataFromFile(FILE_PATH);

        Assert.assertEquals(expected.get(0), actual.get(0));
        Assert.assertEquals(expected.get(1), actual.get(1));
        Assert.assertEquals(expected.get(2), actual.get(2));
    }

    @Test
    public void readFromEmptyFile(){
        List<FruitDto> actual = fileReader.readDataFromFile(EMPTY_FILE_PATH);

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test(expected = RuntimeException.class)
    public void readFromNonExistedFile(){
        DataFileReader fileReader = new DataFileReader();
        fileReader.readDataFromFile(NON_EXISTED_FILE_PATH);
    }
}
