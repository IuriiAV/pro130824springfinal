package org.telran.mth.mthsummary1.model;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
public class Runner implements Runnable {

    private final Participant participant;

    private final int circleLength;

    private final Map<Long, Participant> participantMap;

    public Runner(Participant participant, int circleLength, Map<Long, Participant> participantMap) {
        this.participant = participant;
        this.circleLength = circleLength;
        this.participantMap = participantMap;
    }

    @Override
    public void run() {
        log.info("{} started!", participant.getName());
        for (int i = 0; i < circleLength; i += participant.getStep()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        participant.setResult(LocalDateTime.now());
        participantMap.put(participant.getId(), participant);
        log.info("{} finished!", participant.getName());
    }
}
