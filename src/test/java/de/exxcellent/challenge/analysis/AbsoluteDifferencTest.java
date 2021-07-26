package de.exxcellent.challenge.analysis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbsoluteDifferencTest {


    public static final String FIRST_FIELD = "A";
    public static final String SECOND_FIELD = "B";

    private AbsoluteDifference comparator;

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }

    @BeforeEach
    void setUp(){
         comparator = new AbsoluteDifference(FIRST_FIELD, SECOND_FIELD);
    }


    private static Stream<Arguments> arguments() {
        return  Stream.of(
                Arguments.of("1", "3", "1", "2", 1),
                Arguments.of("1", "1", "2", "2", 0),
                Arguments.of("1", "2", "1", "3", -1),
                Arguments.of("3", "1", "1", "2", 1),
                Arguments.of("1", "2", "3", "1", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void compare_arguments_returnsInteger(String firstInputMin,
                                          String firstInputMax,
                                          String secondInputMin,
                                          String secondInputMax,
                                          int expected) {
        Map<String, String> firstSet = createMap(firstInputMin, firstInputMax);
        Map<String, String> secondSet = createMap(secondInputMin, secondInputMax);

        assertEquals(expected, comparator.compare(firstSet, secondSet));
    }


    Map<String, String>createMap(String firstVal, String secondVal) {
        Map<String, String> set = new HashMap<>();
        set.put(FIRST_FIELD, firstVal);
        set.put(SECOND_FIELD, secondVal);
        return set;
    }
}
