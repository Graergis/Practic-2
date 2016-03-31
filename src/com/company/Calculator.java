package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {

    public static StringBuffer EXAMPLE = new StringBuffer();
    public static double RESULT;

    public static void main(String[] args) {
        boolean bool2 = false;
        StringBuffer bracket = new StringBuffer();
        while (true) {
            EXAMPLE.delete(0, EXAMPLE.length());
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String line2 = scanner.nextLine();
            for (int i = 0; i < line2.length(); i++) {
                char c1 = line2.charAt(i);
                if (c1 == '('){
                    bool2 = true;
                } else if (c1 == ')'){
                    bool2 = false;
                    Rasschet rass = new Rasschet(bracket);
                    bracket.delete(0, bracket.length());
                } else if (bool2){
                    bracket.append(c1);
                } else if (c1 != ' ') {
                    EXAMPLE.append(c1);
                }
            }
            Rasschet rass2 = new Rasschet(EXAMPLE);
            RESULT = new BigDecimal(RESULT).setScale(2, RoundingMode.HALF_UP).doubleValue();
            System.out.println("Результат = " + RESULT);
        }
    }
}