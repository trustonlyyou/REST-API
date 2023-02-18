package me.whiteship.restapi.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class EventDto {
    // Entity 에 어노테이션이 너무 많아서 햇갈릴 수 있다. -> 분산을 위해서 입력 값을 받는 DTO 를 다로 뺐다.
    // 단점은 중복이 생긴다.

    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional) 이게 없으면 온라인 모임
    private int basePrice; // (optional)
    private int maxPrice; // (optional)
    private int limitOfEnrollment;
}
