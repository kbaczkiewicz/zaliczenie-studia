package file;

import file.search.AbstractSearchPattern;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class File {

    private Map<String, Integer> header;

    private List<List<String>> contents;

    private List<List<String>> searchResults;

    private java.io.File file;

    private int fieldsCount;

    public File(java.io.File file, String[] header, List<List<String>> contents) {
        this.file = file;
        this.contents = contents;
        this.createHeader(header);
        this.fieldsCount = this.header.size();
        this.searchResults = new ArrayList<List<String>>();

    }

    public List<String> getAt(int index) {
        return this.contents.get(index);
    }

    public List<String> getSearchedAt(int index) {
        return this.searchResults.get(index);
    }

    public void updateLine(int index, List<String> newContent) {
        this.contents.set(index, newContent);
    }

    public void findInField(
            AbstractSearchPattern pattern,
            String search,
            int field
    ) {
        this.searchResults = pattern.search(this.contents, search, field);
    }

    public void addLine(List<String> line) {
        this.contents.add(line);
    }

    public String getFilePath() {
        return this.file.getAbsolutePath();
    }

    public int getLinesCount() {
        return this.contents.size();
    }

    public int getSearchResultsCount() {
        return this.searchResults.size();
    }

    public List<List<String>> getContents() {
        return this.contents;
    }

    public List<List<String>> getSearchResults() {
        return this.searchResults;
    }

    public Map<String, Integer> getHeader() {
        return this.header;
    }

    public java.io.File getFile() {
        return this.file;
    }

    public int getFieldsCount() {
        return fieldsCount;
    }

    public void setFieldsCount(int fieldsCount) {
        this.fieldsCount = fieldsCount;
    }

    public void deleteLine(int index) {
        this.contents.remove(index);
    }

    private void createHeader(String[] header) {
        this.header = new LinkedHashMap<>();

        for (int i = 0; i < header.length; i++) {
            this.header.put(header[i], i);
        }
    }
}
