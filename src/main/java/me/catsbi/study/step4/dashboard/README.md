#과제 1. live-study 대시보드 만들기

* 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
* 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
* Github 자바 라이브러리를 사용하면 편리합니다.
* 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.

##사용 가이드
1. Dashboard의 token 변수에 자기자신의 접속 token값을 넣어준다.
2. 접속할 주소(REPOSITORY_PATH)를 넣어준다.
3. 실행하면 출력된다.

## 프로젝트 구조
```
 dashboard
   ├── domain
   |  ├── Dashboard.java                //GitHub와 연결및 이슈/참가자 정보를 구하는 도메인 객체
   |  ├── dto
   |  |  └── ParticipateIssueDTO.java   //참가자 현황 추가에 사용되는 DTO
   |  ├── Participants.java             //참가자의 이슈별 참여 현황 일급 콜렉션
   |  └── ParticipationStatus.java      //이슈별 참가 현황 관리 일급 콜렉션
   ├── Main.java
   ├── README.md
   └── view
      └── ParticipationResultView.java  //참가현황 결과 출력 View
```
