package br.com.elogroup.techdev.config;

import br.com.elogroup.techdev.model.Usuario;
import br.com.elogroup.techdev.service.UsuarioService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
@Configuration
public class BaseDadosInicial {

    @Bean
    public boolean carregarDados(UsuarioService usuarioService,
                                 PasswordEncoder passwordEncoder) throws ParseException {

        List<Usuario> usuarios = new ArrayList<>();
        Usuario root = new Usuario("root", passwordEncoder.encode("spiderman"), true,
                Collections.singletonList("ADMIN"));
        usuarios.add(root);

        for(int i = 0; i < 10; i++) {
            final String login = String.format("usuario%d", i);
            final String senha = passwordEncoder.encode(String.format("senha%d", i));
            Usuario usuario = new Usuario(login, senha, true, Collections.singletonList("USER"));
            usuarios.add(usuario);
        }
        usuarioService.salvar(usuarios);
        return true;
    }
}
