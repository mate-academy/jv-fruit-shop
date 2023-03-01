package createfileforproducts;

import errors.InvalidFileExtension;
import java.io.File;
import java.io.IOException;

public class CreateNewFileForProductsImpl implements CreateNewFileForProducts {

    @Override
    public File createFile(String name) {
        if (!name.endsWith(".csv")) {
            throw new InvalidFileExtension("Invalid file extension, extension must be 'csv'.");
        }
        String pathForNewFile = "/Users/alexeyukrainets/Desktop/mate/jv-fruit-shop/src"
                + "/main/java/core/basesyntax/RearFileWithProducts/Files/" + name;
        File file = new File(pathForNewFile);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
        return file;
    }
}
