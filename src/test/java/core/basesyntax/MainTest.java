package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainTest {

    private static FileService fileService;

    @BeforeClass
    public static void setup() {
        fileService = new FileServiceImpl();
    }

    @Test
    public void correctResult() {
        executeEquals("src/test/java/core/basesyntax/files/input/onlyBanana",
                "src/test/java/core/basesyntax/files/expected/expectedOnlyBanana");
    }

    @Test
    public void incorrectResult() {
        Main.main(new String[]{"src/test/java/core/basesyntax/files/input/onlyBanana"});
        List<String> expected = fileService.read("src/test/java/core/basesyntax/files/expected/expectedIncorrectOnlyBanana");
        List<String> actual = fileService.read("balance_storage_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss")));
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void incorrectData() {
        executeEquals("src/test/java/core/basesyntax/files/input/incorrectData",
                "src/test/java/core/basesyntax/files/expected/expectedIncorrectData");
    }

    @Test
    public void emptyFile() {
        executeEquals("src/test/java/core/basesyntax/files/input/empty",
                "src/test/java/core/basesyntax/files/expected/expectedEmpty");
    }

    @Test
    public void manyData() {
        executeEquals("src/test/java/core/basesyntax/files/input/manyData",
                "src/test/java/core/basesyntax/files/expected/expectedManyData");
    }

    @Test
    public void onlySupply() {
        executeEquals("src/test/java/core/basesyntax/files/input/onlyReturn",
                "src/test/java/core/basesyntax/files/expected/expectedOnlyReturn");
    }

    @Test
    public void onlyBuy() {
        executeEquals("src/test/java/core/basesyntax/files/input/onlySupply",
                "src/test/java/core/basesyntax/files/expected/expectedOnlyReturn");
    }

    @Test
    public void onlyReturn() {
        try {
            Main.main(new String[]{"src/test/java/core/basesyntax/files/input/onlyBuy"});
        } catch (InvalidParameterException ignored) {
            return;
        }
        Assert.fail();
    }

    private void executeEquals(String firstFilePath, String secondFilePath) {
        Main.main(new String[]{firstFilePath});
        List<String> expected = fileService.read(secondFilePath);
        List<String> actual = fileService.read("balance_storage_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss")));
        Assert.assertEquals(expected, actual);
    }
}