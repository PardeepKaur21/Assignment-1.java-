package gui_swing_events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Excel {
   
    private ArrayList<Double> numbers = new ArrayList<>();
 public Excel(ArrayList<Double> numbers) {
        this.numbers = numbers;
    }
public Excel(String numString) {
        String[] strNumArray = numString.split(" ");
        List<String> strNumList = Arrays.asList(strNumArray);
         ArrayList<String> strNumArrayList = new ArrayList<>(strNumList);
          strNumArrayList.forEach(strNum -> numbers.add(Double.valueOf(strNum)));
         for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        } 
    }
    public double findTotal() {
        double total = 0;
        for (Double num : numbers) {
            total += num;
        }
        return total;
    }

     public double findAvg() {
        double total = findTotal();
        return total / numbers.size();
    }
    public double findMax() {
        double max = numbers.get(0);
        for (Double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public double findMin() {
        double min = numbers.get(0);
        for (Double num : numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
