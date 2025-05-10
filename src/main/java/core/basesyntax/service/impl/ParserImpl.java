package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.Instruction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int INSTRUCTIONS_SIZE = 3;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<Instruction> parse(List<String> lines) {
        List<Instruction> instructions = new ArrayList<>();
        String[] instructionsParameters;
        for (String line : lines) {
            instructionsParameters = line.split(",");
            if (instructionsParameters.length != INSTRUCTIONS_SIZE) {
                throw new RuntimeException("Can't parse information from "
                        + Arrays.toString(instructionsParameters));
            }
            Instruction instruction = new Instruction(
                    FruitOperation.getFromCode(instructionsParameters[INDEX_OF_OPERATION]),
                    instructionsParameters[INDEX_OF_FRUIT_NAME],
                    Integer.parseInt(instructionsParameters[INDEX_OF_QUANTITY])
            );
            instructions.add(instruction);
        }
        return instructions;
    }
}
