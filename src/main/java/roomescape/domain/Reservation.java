package roomescape.domain;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reservation {

    private final Long id;
    private final Member member;
    private final LocalDate date; // TODO 도메인화 고려
    private final ReservationTime time;
    private final Theme theme;

    public Reservation(Long id, Member member, LocalDate date, ReservationTime time, Theme theme) {
        this.id = id;
        this.member = member;
        this.date = date;
        this.time = time;
        this.theme = theme;
    }

    public Reservation(Member member, LocalDate date, ReservationTime time, Theme theme) {
        this(null, member, date, time, theme);
    }

    public boolean isSameDate(String date) {
        if (date == null) {
            return false;
        }
        LocalDate parse = LocalDate.parse(date);
        return this.date.equals(parse);
    }

    public boolean isSameTheme(Long themeId) {
        if (themeId == null) {
            return false;
        }
        return this.theme.getId().equals(themeId);
    }

    public Long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDate(DateTimeFormatter formatter) {
        return date.format(formatter);
    }

    public ReservationTime getTime() {
        return time;
    }

    public Theme getTheme() {
        return theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
