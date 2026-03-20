package com.jasonferraz.jason_ferraz_os.controller;

import com.jasonferraz.jason_ferraz_os.model.OrdemServico;
import com.jasonferraz.jason_ferraz_os.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/os")
@CrossOrigin("*") 
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository repository;

    @GetMapping
    public List<OrdemServico> listar() {
        return repository.findAll();
    }

    @PostMapping
    public OrdemServico criar(@RequestBody OrdemServico os) {
        if (os.getStatus() == null) os.setStatus("ABERTA");
        return repository.save(os);
    }

    // Escuta o botão Finalizar (PUT)
    @PutMapping("/{id}/finalizar")
    public OrdemServico finalizar(@PathVariable Long id) {
        OrdemServico os = repository.findById(id).orElseThrow();
        os.setStatus("FINALIZADA");
        return repository.save(os);
    }

    // Escuta o botão Excluir (DELETE)
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}