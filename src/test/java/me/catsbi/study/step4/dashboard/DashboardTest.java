package me.catsbi.study.step4.dashboard;

import me.catsbi.study.step4.dashboard.domain.Dashboard;
import me.catsbi.study.step4.dashboard.domain.ParticipationStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import me.catsbi.study.step4.dashboard.view.ParticipationResultView;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class DashboardTest {
    private Dashboard dashboard;
    private ParticipationResultView resultView;

    @BeforeEach
    void setup() throws IOException {
        dashboard = new Dashboard();
        resultView = new ParticipationResultView();
    }


    @DisplayName("이슈 사이즈 테스트")
    @Test
    void getSize() throws IOException {
        int size= dashboard.getIssueListSize();
        assertThat(size).isEqualTo(1);
    }

    @DisplayName("이슈 별 참가자 조회 테스트")
    @Test
    void getParticipants() throws IOException {
        ParticipationStatus participants = dashboard.getParticipants();
        resultView.drawParticipationStatusAll(participants);
    }

}
