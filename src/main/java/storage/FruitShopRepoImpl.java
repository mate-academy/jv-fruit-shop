package storage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitDto;
import service.OperationType;

public class FruitShopRepoImpl implements FruitShopRepo {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_COUNT_INDEX = 2;
    private final FileReaderService fileReaderServiceImpl;
    private final FileWriterService fileWriterServiceImpl;

    public FruitShopRepoImpl(FileReaderService fileReaderServiceImpl,
                             FileWriterService fileWriterServiceImpl) {
        this.fileReaderServiceImpl = fileReaderServiceImpl;
        this.fileWriterServiceImpl = fileWriterServiceImpl;
    }

    @Override
    public List<FruitDto> getFruitsFromFile(File file) {
        List<String> infoFromFile = fileReaderServiceImpl.getInfoFromFile(file);
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String info : infoFromFile) {
            String[] elementOfParsedInfoFromFile = info.split(",");
            fruitDtoList.add(new FruitDto(
                    OperationType.findOperationType(
                            elementOfParsedInfoFromFile[OPERATION_TYPE_INDEX]),
                    elementOfParsedInfoFromFile[FRUIT_NAME_INDEX],
                    Integer.parseInt(elementOfParsedInfoFromFile[FRUIT_COUNT_INDEX])));
        }
        return fruitDtoList;
    }

    @Override
    public File writeData(List<FruitDto> fruitDtoList) {
        List<String> fruitDataToWrite = fruitDtoList.stream()
                .map(i -> i.getFruitName() + "," + i.getValue())
                .collect(Collectors.toList());

        return fileWriterServiceImpl.writeToFile(fruitDataToWrite);
    }
}
