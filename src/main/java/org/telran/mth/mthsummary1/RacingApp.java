package org.telran.mth.mthsummary1;

import org.telran.mth.mthsummary1.model.Dog;
import org.telran.mth.mthsummary1.model.Participant;
import org.telran.mth.mthsummary1.model.Pony;
import org.telran.mth.mthsummary1.model.Turtle;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingApp {

    public static void main(String[] args) {
        int CIRCLE_LENGTH = 300;
        List<Participant> participants = Arrays.asList(
                new Pony(1L, "Pony"),
                new Turtle(2L, "Turtle"),
                new Dog(3L, "Dog")
        );
        Random random = new Random();
        for (Participant participant : participants) {
            participant.setStep(random.nextInt(1, 5));
        }
        new Race(CIRCLE_LENGTH, participants).start();
    }
}
