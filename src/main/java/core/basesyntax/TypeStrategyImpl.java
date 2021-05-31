package core.basesyntax;

public class TypeStrategyImpl implements TypeStrategy {

    @Override
    public TypeHandler getTypeHandler(FruitDto fruitDto) {
        if (fruitDto.getType().equals("b")) {
            return new CreateReportForTypeB();
        } else if (fruitDto.getType().equals("p")) {
            return new CreateReportForTypeP();
        } else if (fruitDto.getType().equals("r")) {
            return new CreateReportForTypeR();
        }
        return new CreateReportForTypeS();
    }
}
