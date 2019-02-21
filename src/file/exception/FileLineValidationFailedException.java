/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.exception;

/**
 *
 * @author celtic
 */
public class FileLineValidationFailedException extends RuntimeException
{
    @Override
    public synchronized Throwable fillInStackTrace()
    {
        return super.fillInStackTrace();
    }

    public FileLineValidationFailedException(String message)
    {
        super(message);
    }
}
   
