package core.basesyntax;

import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.ParserImpl;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Parser parser = new ParserImpl();
        System.out.println(parser.parse(List.of(
                "type,fruit,quantity",
                "b,banana,20",
                "b,apple,100",
                "s,banana,100",
                "p,banana,13",
                "r,apple,10",
                "p,apple,20",
                "p,banana,5",
                "s,banana,50")));
    }
}
