package by.ksenia.array.exception;

public class ArrayValidationException extends Exception{

    ArrayValidationException(){
        super();
    }

    ArrayValidationException(String message){
        super(message);
    }

    ArrayValidationException(String message, Throwable cause){
        super(message, cause);
    }

    ArrayValidationException(Throwable cause){
        super(cause);
    }
}
