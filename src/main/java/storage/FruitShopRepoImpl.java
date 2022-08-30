package storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import model.FruitDto;

public class FruitShopRepoImpl implements FruitShopRepo {
    private final FileReaderService fileReaderServiceImpl;
    private final FileWriterService fileWriterServiceImpl;

    public FruitShopRepoImpl(FileReaderService fileReaderServiceImpl,
                             FileWriterService fileWriterServiceImpl) {
        this.fileReaderServiceImpl = fileReaderServiceImpl;
        this.fileWriterServiceImpl = fileWriterServiceImpl;
    }

    @Override
    public List<FruitDto> getFruitsFromFile() {
        List<String> infoFromFile = fileReaderServiceImpl.getInfoFromFile();
        List<FruitDto> fruitDtoList = new ArrayList<>();
        for (String info : infoFromFile) {
            String[] elementOfParsedInfoFromFile = info.split(",");
            fruitDtoList.add(new FruitDto(elementOfParsedInfoFromFile[0],
                    elementOfParsedInfoFromFile[1],
                    Integer.parseInt(elementOfParsedInfoFromFile[2])));
        }
        return fruitDtoList;
    }

    @Override
    public void writeData(List<FruitDto> fruitDtoList) {
        List<String> fruitDataToWrite = fruitDtoList.stream()
                .map(i -> i.getFruitName() + "," + i.getValue())
                .collect(Collectors.toList());

        fileWriterServiceImpl.writeToFile(fruitDataToWrite);
    }
}
