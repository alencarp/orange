package br.com.zup.orange.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UsuarioNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Usuário não encontrado.";
    }
}
