package me.catsbi.study.step4.dashboard;

import me.catsbi.study.step4.dashboard.domain.Dashboard;
import me.catsbi.study.step4.dashboard.domain.ParticipationStatus;
import me.catsbi.study.step4.dashboard.view.ParticipationResultView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Dashboard dashboard = new Dashboard();
        ParticipationResultView resultView = new ParticipationResultView();

        ParticipationStatus participants = dashboard.getParticipants();
        resultView.drawParticipationStatusAll(participants);
    }
}
