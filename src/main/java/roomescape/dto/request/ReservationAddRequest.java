package roomescape.dto.request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import roomescape.domain.Name;
import roomescape.domain.Reservation;
import roomescape.domain.ReservationTime;

public record ReservationAddRequest(Name name, LocalDate date, Long timeId, Long themeId) {

    public ReservationAddRequest {
        validate(name, date, timeId, themeId);
    }

    private void validate(Name name, LocalDate date, Long timeId, Long themeId) {
        if (name == null || date == null || timeId == null || themeId == null) {
            throw new IllegalArgumentException("잘못된 요청입니다. 모든 데이터를 입력해주세요");
        }
    }

    public String getStringDate() {
        return date().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
