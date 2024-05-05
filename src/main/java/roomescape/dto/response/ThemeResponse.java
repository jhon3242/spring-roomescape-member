package roomescape.dto.response;

import roomescape.domain.Name;
import roomescape.domain.Theme;

public record ThemeResponse(Long id, String name, String description, String thumbnail) {

    public static ThemeResponse from(Theme theme) {
        return new ThemeResponse(
                theme.getId(),
                theme.getName().getName(),
                theme.getDescription(),
                theme.getThumbnail()
        );
    }

    public Theme toTheme() {
        return new Theme(id, new Name(name), description, thumbnail);
    }
}
