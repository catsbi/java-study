package me.catsbi.study.step4.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Participants {
    public static final String CHECKED = "O";
    public static final String UNCHECKED = "";
    private final String name;
    private final Map<Integer, Boolean> status;
    private float participateRate;

    public Participants(String name, Map<Integer, Boolean> status) {
        this.name = name;
        this.status = status;
        this.participateRate = 0f;
    }

    public static Participants of(String name) {
        return new Participants(name, new HashMap<>());
    }

    public void checkingParticipate(int issueNo, int issueSize) {
        status.put(issueNo, true);
        updateRate(issueSize);
    }

    private void updateRate(int issueSize) {
        participateRate = size() / (float)issueSize * 100f;
        participateRate = Math.round(participateRate * 100)/100f;
    }

    public int size() {
        return status.size();
    }

    public String getName() {
        return name;
    }

    public boolean getStatus(int issueNo) {
        return Optional.ofNullable(status.get(issueNo))
                .orElse(false);
    }

    public float getParticipateRate() {
        return participateRate;
    }

    public String getStatusSymbol(int index) {
        if (getStatus(index)) {
            return CHECKED;
        }
        return UNCHECKED;
    }
}
