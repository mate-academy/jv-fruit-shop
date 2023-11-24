package core.basesyntax;

import core.basesyntax.servise.FileService;
import core.basesyntax.servise.FileServiceImpl;
/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static final FileServiceImpl fileService = new FileServiceImpl();

    // HINT: In the `public static void main(String[] args)` it is better to create instances of your classes,
    // and call their methods, but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        fileService.makeReport("");
    }
}
