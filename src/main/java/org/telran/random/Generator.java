package org.telran.random;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generator {

    public static void main(String[] args) {
        List<String> students = Arrays.asList(
                "Roman",
                "Konstantin",
                "Sergey",
                "Yulia",
                "Anton",
                "Vlada",
                "Maxim"
        );
        for (int i = 0; i < 7; i++) {
            Collections.shuffle(students);
        }

        for(int i =0 ; i < 4; i++) {
            System.out.println("Team 1 - " + students.get(i));
        }
        for(int i =4 ; i < 7; i++) {
            System.out.println("Team 2 - " + students.get(i));
        }
    }
}
