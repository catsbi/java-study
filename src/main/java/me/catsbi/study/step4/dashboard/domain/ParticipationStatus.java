package me.catsbi.study.step4.dashboard.domain;

import me.catsbi.study.step4.dashboard.domain.dto.ParticipateIssueDTO;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class ParticipationStatus {
    private final int issueSize;
    private final Map<String, Participants> participantsList;

    public ParticipationStatus(Map<String, Participants> map, int issueSize) {
        this.participantsList = map;
        this.issueSize = issueSize;
    }

    public static ParticipationStatus of(int issueSize) {
        return new ParticipationStatus(new HashMap<>(), issueSize);
    }

    public int getIssueSize() {
        return issueSize;
    }

    public void append(List<GHIssue> issues) {
        issues.forEach(this::append);
    }

    private void append(GHIssue issue) {
        try{
            issue.getComments()
                    .forEach(appendConsumer(issue));
        }catch(IOException error){
            System.out.println(error.getMessage());
        }
    }

    private Consumer<GHIssueComment> appendConsumer(GHIssue issue) {
        return comment -> {
            ParticipateIssueDTO issueDTO = new ParticipateIssueDTO(comment.getUserName(),
                    issue.getNumber());
            append(issueDTO);
        };
    }

    public void append(ParticipateIssueDTO dto) {
        Participants participants = get(dto.getName());
        participants.checkingParticipate(dto.getIssueNo(), issueSize);
    }

    private Participants get(String name) {
        Participants participants = participantsList.get(name);
        if (Objects.isNull(participants)) {
            Participants of = Participants.of(name);
            participantsList.put(name, of);
        }

        return participantsList.get(name);
    }

    public void forEachByParticipants(Consumer<Participants> action) {
        participantsList.values()
                .forEach(action);
    }
}
