package org.telran.mth.mthsummary1;

import lombok.extern.slf4j.Slf4j;
import org.telran.mth.mthsummary1.model.Participant;

import java.util.Collection;
import java.util.Map;

@Slf4j
public class Monitor implements Runnable{

    private final Map<Long, Participant> participantMap;

    private final int participantQuantity;

    public Monitor(Map<Long, Participant> participantMap, int participantQuantity) {
        this.participantMap = participantMap;
        this.participantQuantity = participantQuantity;
    }

    @Override
    public void run() {
        log.info("Monitor start!");
        while (participantMap.size() < participantQuantity) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Collection<Participant> values = participantMap.values();
        values.stream()
                .sorted()
                .forEach(participant -> {
                    System.out.println(participant.getName() + " -> " + participant.getResult());
                });
    }
}
