package nl.hu.iac.service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Philip on 3/16/2017.
 */
public class MeanServiceImpl {
    private List<int[]> means = new ArrayList<>();

    public Mean getMean(int[] numbers) {
        means.add(numbers);
        double sum = 0;
        for(int i=0;i<numbers.length;i++) {

            sum += numbers[i];
        }
        Mean mean = new Mean(sum / numbers.length);
        return mean;
    }

    public List<int[]> getArrays() { return means; }

    public int[] getArrayByIndex(int i) {
        return means.get(i);
    }
}
