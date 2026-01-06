package com.upiiz.ligas_deportivas.config;

import com.upiiz.ligas_deportivas.entities.Liga;
import com.upiiz.ligas_deportivas.entities.Usuario;
import com.upiiz.ligas_deportivas.repositories.LigaRepository;
import com.upiiz.ligas_deportivas.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final LigaRepository ligaRepository;

    public DataLoader(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, LigaRepository ligaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.ligaRepository = ligaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!usuarioRepository.existsByUsername("gael")) {
            Usuario admin = new Usuario();
            admin.setUsername("gael");
            admin.setPassword(passwordEncoder.encode("gael123"));
            admin.setRoles(List.of("ADMIN", "USER"));
            usuarioRepository.save(admin);
        }

        if (ligaRepository.count() == 0) {
            Liga l = new Liga("Liga Zacatecana", "Mexico", "2023-2026");
            ligaRepository.save(l);
        }
    }
}
