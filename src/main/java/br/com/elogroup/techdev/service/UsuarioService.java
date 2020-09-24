package br.com.elogroup.techdev.service;

import br.com.elogroup.techdev.model.Usuario;
import br.com.elogroup.techdev.repository.UsuarioRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Log4j2
@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void salvar(final List<Usuario> usuarios) {
        this.repository.saveAll(usuarios);
    }
   
}
