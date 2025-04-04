package org.telran.mth.mthsummary1;

import lombok.extern.slf4j.Slf4j;
import org.telran.mth.mthsummary1.model.Participant;
import org.telran.mth.mthsummary1.model.Runner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class Race {

    private final int circleLength;

    private Map<Long, Participant> resultTable;

    private final List<Participant> participants;

    public Race(int circleLength, List<Participant> participants) {
        this.circleLength = circleLength;
        this.participants = participants;
    }

    public void start() {
        resultTable = new HashMap<>();
        List<Thread> threads = new ArrayList<>();
        for (Participant participant : participants) {
            Runner runner = new Runner(participant, circleLength, resultTable);
            threads.add(new Thread(runner));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        log.info("Race start!");
        Monitor monitor = new Monitor(resultTable, participants.size());
        Thread thread = new Thread(monitor);
        thread.start();
    }
}
