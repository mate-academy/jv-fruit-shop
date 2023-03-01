package core.basesyntax.rearfilewithproducts;

import fruittransaction.Products;
import java.io.File;
import java.util.List;

public interface ReadFileWithProducts {
    List<Products> readFile(File file);
}
