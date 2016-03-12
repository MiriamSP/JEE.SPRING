package restApi.exceptions;

public class DivisionZeroException extends Exception {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Error no se puede dividir por cero";

    public static final int CODE = 666;
    
    public DivisionZeroException() {
        this("");
    }
    
    public DivisionZeroException(String detail) {
        super(DESCRIPTION + ". " + detail + ". CODE: " + CODE);
    }    
}