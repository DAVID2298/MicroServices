package it.contrader.anagraficaservice.customException;

public class UserIdNotFoundException extends Exception{

    public UserIdNotFoundException(String message){
        super(message);
    }
}
