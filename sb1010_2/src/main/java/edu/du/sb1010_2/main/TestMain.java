package edu.du.sb1010_2.main;

import edu.du.sb1010_2.chap07.Calculator;
import edu.du.sb1010_2.chap07.ImpeCalculator;
import edu.du.sb1010_2.chap07.RecCalculator;

public class TestMain {
    public static void main(String[] args) {
        Calculator recCalculator = new RecCalculator();
        System.out.println(recCalculator.factorial(20));
        Calculator impeCalculator = new ImpeCalculator();
        System.out.println(impeCalculator.factorial(20));


    }
}
