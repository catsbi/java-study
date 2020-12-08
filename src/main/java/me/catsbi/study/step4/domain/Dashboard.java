package me.catsbi.study.step4.domain;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

public class Dashboard {
    private final String token = "토큰값 작성";
    private final GitHub gitHub;
    private final GHRepository repo;


    public Dashboard() throws IOException {
        this.gitHub = init();
        this.repo = getRepo();
    }

    private GHRepository getRepo() throws IOException {
        return gitHub.getRepository("whiteship/live-study");
    }

    private GitHub init() throws IOException {
         return new GitHubBuilder().withOAuthToken(token).build();
    }


    public int getIssueListSize() throws IOException {
        List<GHIssue> issues = getIssues();
        return issues.size();
    }

    private List<GHIssue> getIssues() throws IOException {
        return repo.listIssues(GHIssueState.ALL).toList();
    }

    public ParticipationStatus getParticipants() throws IOException {
        List<GHIssue> issues = getIssues();
        ParticipationStatus participationStatus = ParticipationStatus.of(issues.size());
        participationStatus.append(issues);

        return participationStatus;
    }
}
