package exception;

public class OverDraftLimitExceededException extends Exception {
    
	private static final long serialVersionUID = 1L;

	public OverDraftLimitExceededException(String message) {
        super(message);
    }
}