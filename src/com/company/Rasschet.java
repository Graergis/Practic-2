package com.company;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rasschet {

    public Rasschet(StringBuffer line) {
        boolean bool = false;
        LinkedList<Double> number = new LinkedList<>();
        LinkedList<Character> charac = new LinkedList<>();
        double res = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);
        int start = 0;
        while (matcher.find(start)) {
            String value = line.substring(matcher.start(), matcher.end());
            double result = Integer.parseInt(value);
            start = matcher.end();
            number.add(result);
        }
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);if (c == '+') {
                charac.add(c);
            } else if (c == '-') {
                charac.add(c);
            } else if (c == '*') {
                charac.add(c);
            } else if (c == '/') {
                charac.add(c);
            }
        }
        for (int i = 0; i < line.length(); i++) {
            if (charac.size() > i) {
                if (charac.get(i) == '*' || charac.get(i) == '/') {
                    double r = number.remove(i);
                    double l = number.remove(i);
                    if (charac.get(i) == '*') {
                        charac.remove(i);
                        res = r * l;
                        number.add(i, res);
                        if (i > 0) {
                            bool = true;
                        }
                    } else if (charac.get(i) == '/') {
                        charac.remove(i);
                        res = r / l;
                        number.add(i, res);
                        if (i >= 0) {
                            bool = true;
                        }
                    }
                    if (bool & number.size() > 1) {
                        i--;
                        bool = false;
                    }
                }
            }
        }
        for (int j = 0; j < line.length(); j++) {
            if (charac.size() > j) {
                if (charac.get(j) == '-' || charac.get(j) == '+') {
                    double r2 = number.remove(j);
                    double l2 = number.remove(j);
                    if (charac.get(j) == '-') {
                        charac.remove(j);
                        res = r2 - l2;
                        number.add(j, res);
                        if (j >= 0) {
                            bool = true;
                        }
                    } else if (charac.get(j) == '+') {
                        charac.remove(j);
                        res = r2 + l2;
                        number.add(j, res);
                        if (j >= 0) {
                            bool = true;
                        }
                    }
                    if (bool & number.size() > 1) {
                        j--;
                        bool = false;
                    }
                }
            }
        }
        number.clear();
        charac.clear();
        Calculator.EXAMPLE.append(res);
        Calculator.RESULT = res;
    }
}