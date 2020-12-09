#과제 0. JUnit 5 학습하기 샘플 코드
* 간단한 문자열 사칙연산 프로그램을 이용해 테스트 케이스를 학습해본다.

## 코드살펴보기
* [ComputationalInformation](./ComputationalInformation.java)
* [Operator](./Operator.java)
* [StringCalculator](./StringCalculator.java)
* [TestCase](../../../../../../../test/java/me/catsbi/study/step4/calculator/StringCalculatorTest.java)

## 프로젝트 구조
```aidl
├── main
|  ├── java
|  |  └── me
|  |     └── catsbi
|  |        └── study
|  |           └── step4
|  |              ├── calculator
|  |                 ├── ComputationalInformation.java //계산 정보 DTO
|  |                 ├── Operator.java //사칙연산 함수 타입 ENUM
|  |                 ├── README.md
|  |                 └── StringCalculator.java //사칙연산 클래스 
└── test
   └── java
      └── me
         └── catsbi
            └── study
               └── step4
                  └── calculator
                     └── StringCalculatorTest.java //사칙연산 클래스 테스트 케이스
```
