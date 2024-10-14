package util;

import java.util.List;

public abstract class FileUtil<T>{

    public abstract List<T> readFile(String filePath);

    public void writeFile(String filePath, List<T> items){};
}
