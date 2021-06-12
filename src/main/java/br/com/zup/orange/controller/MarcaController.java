package br.com.zup.orange.controller;

import br.com.zup.orange.domain.Marca;
import br.com.zup.orange.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("marcas")
public class MarcaController {

    private MarcaService marcaService;

    @Autowired
    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public Marca[] getMarca() {
        return marcaService.getMarca();
    }
}
