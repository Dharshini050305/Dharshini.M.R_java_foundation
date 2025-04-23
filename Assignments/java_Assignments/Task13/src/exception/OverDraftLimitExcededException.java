package exception;

public class OverDraftLimitExcededException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public OverDraftLimitExcededException(String message) {
	        super(message);
	    }
	}
