package utils;

import javax.swing.*;
import java.util.Objects;

public class ResourceFileUtils {


    public ImageIcon getImageIconResourceByPath(String filePath) {
        return new ImageIcon(Objects.requireNonNull(this.getClass().getResource(filePath)));
    }

}
