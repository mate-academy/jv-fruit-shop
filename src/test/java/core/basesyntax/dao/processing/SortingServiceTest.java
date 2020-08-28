package core.basesyntax.dao.processing;

import core.basesyntax.products.Fruit;
import core.basesyntax.storage.ListStorage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SortingServiceTest {
    private static final Fruit FIRST_FRUIT =
            new Fruit("banana",111, LocalDate.of(2015, 2, 24));
    private static final Fruit SECOND_FRUIT =
            new Fruit("apple",111, LocalDate.of(2015, 1, 14));
    private static final Fruit THIRD_FRUIT =
            new Fruit("banana",53, LocalDate.of(2016, 12, 3));
    private static final String FIRST_STRING = "fruit,quantity";
    private static final String SECOND_STRING = "banana,164";
    private static final String THIRD_STRING = "apple,111";
    private final int first = 0;
    private final int second = 1;
    private final int third = 2;

    private List<Fruit> listStorage = ListStorage.listStorage;

    @Before
    public void setUp(){
        listStorage.clear();
        listStorage.add(FIRST_FRUIT);
        listStorage.add(SECOND_FRUIT);
        listStorage.add(THIRD_FRUIT);
    }

    @Test
    public void sortingByName() {
        SortingService sortService = new SortingService();
        List<String> testListSorted = new ArrayList<>();
        testListSorted = sortService.sortDataBeforeWrite();
        Assert.assertEquals("Fail in sorting",FIRST_STRING,testListSorted.get(first));
        Assert.assertEquals("Fail in sorting",SECOND_STRING,testListSorted.get(second));
        Assert.assertEquals("Fail in sorting",THIRD_STRING,testListSorted.get(third));
    }
}