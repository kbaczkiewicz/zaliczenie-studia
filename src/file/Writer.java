package file;

import file.exception.FileLineValidationFailedException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    private File file;

    public Writer(File file) {
        this.file = file;
    }

    public void addLine(List<String> fields) throws IOException {
        this.validateLine(fields);
        this.file.addLine(fields);
        this.writeToFile(this.buildLine(fields) + "\n");
    }

    public void editLine(List<String> newContent, int position) throws IOException {
        this.validateLine(newContent);
        this.file.updateLine(position, newContent);
        this.refreshFile();
    }

    public void refreshFile() throws IOException {
        this.wipeOutFile();
        this.writeToFile(this.buildLine(new ArrayList<>(this.file.getHeader().keySet())) + "\n");
        for (List<String> line : this.file.getContents()) {
            this.writeToFile(this.buildLine(line) + "\n");
        }

    }
    
    public void removeLine(int index) throws IOException {
        this.file.deleteLine(index);
        this.refreshFile();
    }

    private void wipeOutFile() throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(this.file.getFile(), "rw");
        raf.setLength(0);
    }

    private String buildLine(List<String> fields) {
        StringBuilder builder = new StringBuilder();

        for (String field : fields) {
            builder.append(field);
            builder.append(";");
        }

        return builder.toString();
    }

    private void writeToFile(String line) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.file.getFilePath(), true));
        writer.write(line);
        writer.close();
    }

    private void validateLine(List<String> fields) {
        if (fields.size() != this.file.getHeader().size()) {
            throw new FileLineValidationFailedException("Line fields count doesn't match header fields count");
        }
    }
}
