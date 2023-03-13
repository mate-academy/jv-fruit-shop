package core.basesyntax;

import core.basesyntax.exeptions.NotEnoughFruitsException;
import core.basesyntax.exeptions.NotValidDataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OperationWithFruitsTest {

    private static final String FIRST_FILE_NAME = "D:\\MateHW\\jv-fruit-shop\\txt1";
    private static final String SECOND_FILE_NAME = "D:\\MateHW\\jv-fruit-shop\\txt2";
    private static final String THIRD_FILE_NAME = "D:\\MateHW\\jv-fruit-shop\\txt3";
    private static final String FOURS_FILE_NAME = "D:\\MateHW\\jv-fruit-shop\\txt4";
    private static final String FIRTH_FILE_NAME = "D:\\MateHW\\jv-fruit-shop\\txt5";
    private static final String SIXTH_FILE_NAME = "D:\\MateHW\\jv-fruit-shop\\txt7";
    public final static String FIRST_INPUT_DATA = "type,fruit,quantity,date";
    public final static List<String> CORRECT_OPERATION = List.of("s,banana,70,2020-10-17", "r,banana,10,2020-10-17",
            "s,apple,0,2020-10-17", "s,orange,10,2020-10-17");
    public final static List<String> CORRECT_OPERATION2 = List.of("s,banana,50,2020-10-12", "s,banana,0,2020-10-15",
            "s,apple,75,2020-10-25", "r,apple,40,2020-10-23");
    public final static List<String> INCORRECT_INPUT_DATA = List.of("k,banana,100,2020-10-17", "r,apple,1,2020-10-17");
    public final static List<String> INCORRECT_INPUT_DATA2 = List.of("s,banana,xxx,2020-10-17", "r,apple,1,2020-10-17");
    public final static List<String> INCORRECT_INPUT_DATA3 = List.of("s,banana,100,2020-10-17", "r,apple,1,2020-25-25");
    public final static List<String> INCORRECT_INPUT_DATA4 = List.of("s,banana,100,2020-10-17", "r,apple,1,2020-25-25");
    public final static List<String> INCORRECT_INPUT_DATA5 = List.of("s,banana,100,2020-10-17", "r,apple,1,2020.10.25");
    public final static List<String> INCORRECT_INPUT_DATA_EMPTY = new ArrayList<>();
    public final static List<String> CORRECT_OPERATION_SUPPLY = List.of("s,apple,30,2020-10-15", "s,lemon,100,2020-10-17",
            "s,peach,10,2020-10-17");
    public final static List<String> CORRECT_OPERATION_RETURN = List.of("r,banana,100,2020-10-17", "r,kiwi,30,2020-10-25");


    public static OperationWithFruits operation = new OperationWithFruits();

    @Test
    public void Text_Reader_Test_OK() {
        ReadFromFile reader = new ReadFromFile();
        String actual = reader.readFromFile(FIRST_FILE_NAME).get(0);
        Assert.assertEquals(FIRST_INPUT_DATA, actual);
    }

    @Test(expected = RuntimeException.class)
    public void Text_Reader_Test_Fail() {
        ReadFromFile reader = new ReadFromFile();
        reader.readFromFile("incorrect file name").get(0);
    }

    @Test(expected = NotValidDataException.class)
    public void Data_Validation_Test_Fail() throws NotValidDataException {
        FruitTypes range = new FruitTypes();
        DataValidation data = new DataValidation();
        List<String> rangeOfShop = range.getFruitTypes();
        data.dataValidation(INCORRECT_INPUT_DATA, rangeOfShop);
    }

    @Test(expected = NotValidDataException.class)
    public void Data_Validation_Test2_Fail() throws NotValidDataException {
        FruitTypes range = new FruitTypes();
        DataValidation data = new DataValidation();
        List<String> rangeOfShop = range.getFruitTypes();
        data.dataValidation(INCORRECT_INPUT_DATA2, rangeOfShop);
    }

    @Test(expected = NotValidDataException.class)
    public void Data_Validation_Test3_Fail() throws NotValidDataException {
        FruitTypes range = new FruitTypes();
        DataValidation data = new DataValidation();
        List<String> rangeOfShop = range.getFruitTypes();
        data.dataValidation(INCORRECT_INPUT_DATA3, rangeOfShop);
    }

    @Test(expected = NotValidDataException.class)
    public void Data_Validation_Test_Empty_Fail() throws NotValidDataException {
        FruitTypes range = new FruitTypes();
        DataValidation data = new DataValidation();
        List<String> rangeOfShop = range.getFruitTypes();
        data.dataValidation(INCORRECT_INPUT_DATA_EMPTY, rangeOfShop);
    }
    @Test(expected = NotValidDataException.class)
    public void Data_Validation_Test4_Fail() throws NotValidDataException {
        FruitTypes range = new FruitTypes();
        DataValidation data = new DataValidation();
        List<String> rangeOfShop = range.getFruitTypes();
        data.dataValidation( INCORRECT_INPUT_DATA4, rangeOfShop);
    }

    @Test(expected = NotValidDataException.class)
    public void Data_Validation_Test5_Fail() throws NotValidDataException {
        FruitTypes range = new FruitTypes();
        DataValidation data = new DataValidation();
        List<String> rangeOfShop = range.getFruitTypes();
        data.dataValidation( INCORRECT_INPUT_DATA5, rangeOfShop);
    }

    @Test
    public void Text_Buying_Test_OK() throws Exception {
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFile = reader.readFromFile(THIRD_FILE_NAME);
        List <String> actual = operation.operationWithFruits(fruitsFromFile);
        Assert.assertEquals(CORRECT_OPERATION, actual);
    }

    @Test
    public void Text_Buying_Test2_OK() throws Exception {
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFile = reader.readFromFile(SIXTH_FILE_NAME);
        List <String> actual = operation.operationWithFruits(fruitsFromFile);
        Assert.assertEquals(CORRECT_OPERATION2, actual);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void Text_Buying_Test2_FAIL() throws Exception {
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFile = reader.readFromFile(FOURS_FILE_NAME);
        operation.operationWithFruits(fruitsFromFile);
    }

    @Test(expected = NotEnoughFruitsException.class)
    public void Text_Buying_Test3_FAIL() throws Exception {
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFile = reader.readFromFile(FIRTH_FILE_NAME);
        operation.operationWithFruits(fruitsFromFile);
    }
    @Test
    public void Text_Supply_Test_OK() {
        ReadFromFile reader = new ReadFromFile();
        Supply supply = new Supply();
        List<String> fruitsFromFile = reader.readFromFile(SECOND_FILE_NAME);
        List <String> actual = supply.fruitsAddaLL(fruitsFromFile);
        Assert.assertEquals(CORRECT_OPERATION_SUPPLY, actual);
    }

    @Test
    public void Text_Return_Test_OK() {
        Return returnOperation = new Return();
        ReadFromFile reader = new ReadFromFile();
        List<String> fruitsFromFile = reader.readFromFile(SECOND_FILE_NAME);
        List <String> actual = returnOperation.fruitsAddaLL(fruitsFromFile);
        Assert.assertEquals(CORRECT_OPERATION_RETURN, actual);
    }
}

