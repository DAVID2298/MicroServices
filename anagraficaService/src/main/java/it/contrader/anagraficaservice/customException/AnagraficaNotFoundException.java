package it.contrader.anagraficaservice.customException;

public class AnagraficaNotFoundException extends Exception{

    public AnagraficaNotFoundException(String message){
        super(message);
    }
}
