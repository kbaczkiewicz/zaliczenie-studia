package file.exception;

public class InvalidIndexException extends RuntimeException
{
    @Override
    public synchronized Throwable fillInStackTrace()
    {
        return super.fillInStackTrace();
    }

    public InvalidIndexException(String message)
    {
        super(message);
    }
}
