package org.telran.mth.mthsummary1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public abstract class Participant implements Comparable<Participant> {

    private final Long id;

    private final String name;

    @Setter
    private int step;

    @Setter
    private LocalDateTime result;

    public Participant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Participant o) {
        return this.result.compareTo(o.result);
    }
}
