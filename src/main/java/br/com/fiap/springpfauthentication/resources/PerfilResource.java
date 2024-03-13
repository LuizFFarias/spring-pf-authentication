package br.com.fiap.springpfauthentication.resources;

import br.com.fiap.springpfauthentication.entity.Perfil;
import br.com.fiap.springpfauthentication.repository.PerfilRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class PerfilResource {

    @Autowired
    private PerfilRepository perfilRepo;

    @GetMapping
    public List<Perfil> findAll(){
        return perfilRepo.findAll();
    }


    @GetMapping(value = "/{id}")
    public Perfil findById(@PathVariable Long id) {
        return perfilRepo.findById( id ).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Perfil save(@RequestBody Perfil perfil) {
        return perfilRepo.save( perfil );
    }

    @Transactional
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        Perfil perfil = perfilRepo.findById( id ).get();
        perfilRepo.delete( perfil );
    }
}
