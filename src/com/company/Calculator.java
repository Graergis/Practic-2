package com.company;

import java.util.Scanner;

public class Calculator {

    public static String LINE;

    public static void main(String[] args) {
        boolean bool2 = false;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            String line2 = scanner.nextLine();
            String ss = "";
            LINE = "";
            for (int i = 0; i < line2.length(); i++) {
                char c1 = line2.charAt(i);
                if (c1 == '('){
                    bool2 = true;
                } else if (c1 == ')'){
                    bool2 = false;
                    Rasschet rass = new Rasschet(ss);
                    ss = "";
                } else if (bool2){
                    ss += c1;
                } else if (c1 != ' ') {
                    LINE += c1;
                }
            }
            Rasschet rass2 = new Rasschet(LINE);
        }
    }
}