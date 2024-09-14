package domain;

import java.time.LocalDateTime;

public class DateProviderImpl implements DateProvider{

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
