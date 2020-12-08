package me.catsbi.study.step4.dashboard.view;

import me.catsbi.study.step4.dashboard.domain.Participants;
import me.catsbi.study.step4.dashboard.domain.ParticipationStatus;

import java.util.stream.IntStream;

public class ParticipationResultView {
    public static final String CHECK_SYMBOL = "%3.3s|";
    public static final String NAME_SYMBOL = "%20s|";
    public static final String RATE_SYMBOL = "%6s";
    public static final String NO_MARK = "";

    private static final StringBuilder sb = new StringBuilder();

    public void drawParticipationStatusAll(ParticipationStatus status) {
        drawHeader(status.getIssueSize());

        clearStringBuilder();
        status.forEachByParticipants(participants -> drawParticipationStatus(participants, status.getIssueSize()));
        System.out.println(sb.toString());
    }

    private void drawHeader(int issueSize) {
        clearStringBuilder();
        appendSymbol(NAME_SYMBOL, "name");
        IntStream.range(0, issueSize).forEach(index->{
            appendSymbol(CHECK_SYMBOL, String.valueOf(index));
        });
        appendSymbol(RATE_SYMBOL, "rate");
        System.out.println(sb.toString());
    }

    private void drawParticipationStatus(Participants participants, int issueSize) {
        appendSymbol(NAME_SYMBOL, participants.getName());
        IntStream.range(0, issueSize)
                .forEach(index-> appendSymbol(CHECK_SYMBOL, participants.getStatusSymbol(index)));
        appendSymbol(RATE_SYMBOL, String.valueOf(participants.getParticipateRate()));
        sb.append(System.lineSeparator());
    }

    private void appendSymbol(String symbol, String str) {
        sb.append(String.format(symbol, str));
    }

    private void clearStringBuilder() {
        sb.delete(0, sb.length());
    }
}
