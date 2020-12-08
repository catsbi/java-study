package me.catsbi.study.step4.domain.dto;

public class ParticipateIssueDTO {
    private final String name;
    private final int issueNo;

    public ParticipateIssueDTO(String name, int issueNo) {
        this.name = name;
        this.issueNo = issueNo;
    }

    public String getName() {
        return name;
    }

    public int getIssueNo() {
        return issueNo;
    }
}
