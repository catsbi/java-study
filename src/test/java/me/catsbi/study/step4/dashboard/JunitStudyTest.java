package me.catsbi.study.step4.dashboard;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;

@DisplayName("JUnit5 Test Study case")
public class JunitStudyTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class Display_Name_Generation_Test_Class {
        @Test
        void integer_summary_test() {

        }
        @DisplayName("DisplayName 애노테이션 테스트")
        @ParameterizedTest(name = "{0} 번째 테스트")
        @ValueSource(ints = {1,2,3,4})
        void 디스플레이_애노테이션_테스트(int input) {

        }
    }

    @Nested
    @DisplayNameGeneration(IndicativeSentences.class)
    class Display_Name_Generation_Test_Class_IndicativeSentences {
        @Test
        void integer_summary_test() {

        }
        @DisplayName("DisplayName 애노테이션 테스트")
        @ParameterizedTest(name = "{0} 번째 테스트")
        @ValueSource(ints = {1,2,3,4})
        void 디스플레이_애노테이션_테스트(int input) {

        }
    }

    static class IndicativeSentences extends DisplayNameGenerator.ReplaceUnderscores {
        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return super.generateDisplayNameForNestedClass(nestedClass) + "...";
        }

        @Override
        public java.lang.String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            String string = testClass.getSimpleName() + ' ' + testMethod.getName();
            return string.replace('_',' ') + "...";
        }
    }


}
