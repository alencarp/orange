package br.com.zup.orange.exception;

public class ModeloNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Modelo não encontrado.";
    }
}
