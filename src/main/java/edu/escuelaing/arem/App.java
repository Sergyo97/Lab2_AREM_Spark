package edu.escuelaing.arem;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Class of an App
 * @author Sergio Ruiz
 * 
 */
public class App 
{
    private static LinkedList lK;
    
    /**
     * Encapsulates the application's main entry point.
     * 
     * @param args
     * @throws FileNotFoundException
     */
    public static void main( String[] args ) throws FileNotFoundException {
        
        String path = "resources/cases/case1.txt";
        Scanner sc = new Scanner(new File(path));
        lK = new LinkedList();

        while (sc.hasNext()) {
            lK.append(Double.parseDouble(sc.nextLine()));
        }

        System.out.println(mean(lK));
        System.out.println(standardDev(lK));

        sc.close();
        
    }
    
    /**
     * Method that calculates LinkedList's mean
     * @return ans Mean value
     */
    public static Double mean(LinkedList lK) {
        
        Double values = 0.0;
        Double add = 0.0;
        Node current = lK.getHead();
        
        while (current != null) {
            values += 1;
            add += current.getData();
            current = current.getNext();
        }
        
        Double ans = add/values;
        return ans;
    }
    
    /**
     * Method that calculates LinkedList's standard deviation
     * @return Standard deviation value
     */
    public static String standardDev(LinkedList lK){
        double mean = mean(lK);
        double add = 0;
        double values = -1;
        Node current = lK.getHead();
        DecimalFormat decimalF = new DecimalFormat("#.##");
        decimalF.setRoundingMode(RoundingMode.CEILING);
        
        while (current != null){
            values += 1;
            add += (current.getData()-mean)*(current.getData()-mean);
            current = current.getNext();
        }
        
        return decimalF.format(Math.sqrt(add/values));
    }
}