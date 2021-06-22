package br.com.zup.orange.exception;

public class MarcaNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Marca não encontrada.";
    }
}