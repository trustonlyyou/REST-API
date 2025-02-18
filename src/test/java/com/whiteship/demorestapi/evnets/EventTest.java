package com.whiteship.demorestapi.evnets;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Inflean Spring REST API")
                .description("REST API development with spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        // Given
        String name = "Event";
        String description = "Spring";

        // When
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);

        // Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
//    @ParameterizedTest
//    @CsvSource({
//            "0, 0, true",
//            "100, 0, false",
//            "0, 100, false"
//    })
    @Parameters(method = "parameterForTestFee")
    public void testFree(int basePrice, int maxPrice, boolean isFree) {
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);
    }

    private Object[] parameterForTestFee() {
        return new Object[]{
                new Object[]{0, 0, true},
                new Object[]{100, 0, false},
                new Object[]{0, 100, false},
                new Object[]{200, 100, false},
        };
    }

    @Test
    public void testOffline() throws Exception {
        //given
        Event event = Event.builder()
                .location("강남역 네이버 D2 스타텁 팩토리")
                .build();
        //when
        event.update();
        //then
        assertThat(event.isOffline()).isTrue();

        //given
        event = Event.builder()
                .build();
        //when
        event.update();
        //then
        assertThat(event.isOffline()).isFalse();
    }
}