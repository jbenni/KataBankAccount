package domain.exception;

public class WithdrawNotAllowedException extends RuntimeException {

    public WithdrawNotAllowedException(String message) {
        super(message);
    }
}
