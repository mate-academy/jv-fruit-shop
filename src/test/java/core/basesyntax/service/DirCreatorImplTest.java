package core.basesyntax.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DirCreatorImplTest {
    private static DirCreator create;

    @BeforeClass
    public static void beforeClass() {
        create = new DirCreatorImpl();
    }

    @Test
    public void incorrectPathTest() {
        String path = "src/main/resource/dir";
        Assert.assertFalse(create.createDir(path));
    }
}
