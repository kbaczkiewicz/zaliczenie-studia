package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileFactory
{
    public File loadFile(String path) throws IOException
    {
        java.io.File file = new java.io.File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));

        return this.createFromFile(file, reader);
    }

    private File createFromFile(java.io.File file, BufferedReader reader) throws IOException
    {
        List<String> lines = new ArrayList<>();
        String[] header = reader.readLine().split(";");

        String tmp = "";
        while (null != tmp) {
            tmp = reader.readLine();
            if (null != tmp) {
                lines.add(tmp);
            }
        }

        List<List<String>> contents = new ArrayList<>();

        for (String line: lines) {
            List<String> fields = new ArrayList<>(Arrays.asList(line.split(";")));
            contents.add(fields);

        }

        return new File(file, header, contents);
    }
}
