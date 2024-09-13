package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    void should_have_balance_0_when_create_account() {
        // Given When
        Account account = new Account();
        var expectedBalance = 0.0;

        // Then
        assertThat(account.getBalance()).isEqualTo(expectedBalance);
    }
}
