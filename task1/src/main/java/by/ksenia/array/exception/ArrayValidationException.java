package by.ksenia.array.exception;

public class ArrayValidationException extends Exception{

   public ArrayValidationException(){
        super();
    }

   public ArrayValidationException(String message){
        super(message);
    }

   public ArrayValidationException(String message, Throwable cause){
        super(message, cause);
    }

   public ArrayValidationException(Throwable cause){
        super(cause);
    }
}
