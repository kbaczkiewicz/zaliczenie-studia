/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.sortpattern;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author celtic
 */
public class DescendingSortPattern implements SortPatternInterface {
    @Override
    public void sort(List<List<String>> contents, int field) {
        for (int i = 0; i < contents.size(); i++) {
            int maxIndex = i;
            for (int j = i; j < contents.size(); j++) {
                String comparedValue = contents.get(j).get(field);
                String minValue = contents.get(maxIndex).get(field);
                if (0 < comparedValue.compareTo(minValue)) {
                    maxIndex = j;
                }
            }
            
            Collections.swap(contents, maxIndex, i);
        }
    }
    
}
