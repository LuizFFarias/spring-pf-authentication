package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.entity.Pessoa;
import br.com.fiap.springpfauthentication.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }


    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
