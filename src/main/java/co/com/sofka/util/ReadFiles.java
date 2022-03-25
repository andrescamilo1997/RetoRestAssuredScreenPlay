package co.com.sofka.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFiles {
    private static final Logger LOGGER= Logger.getLogger(ReadFiles.class);
    public static String readFile(String filePath) {
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            while ((line = br.readLine()) != null)
                stringBuilder.append(line + "\n");
        } catch (IOException ioException) {
            LOGGER.info("\n\n****Hay problemas con la ruta especificada para la lectura de archivos****");
            LOGGER.info(ioException.getMessage() + "\r\n");
            LOGGER.info(ioException);
        }

        return stringBuilder.toString();
    }
}
