package domain;

import java.time.LocalDateTime;

public class FakeDateProvider extends DateProviderImpl{

    private LocalDateTime date = LocalDateTime.of(2024, 9, 14, 12, 0);

    @Override
    public LocalDateTime now() {
        return this.date;
    }
}
