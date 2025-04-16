package petistaan.example.demo.exception;

public class DuplicateOwnerIdException extends Exception{
    public DuplicateOwnerIdException(String message) {
        super(message);
    }
}
