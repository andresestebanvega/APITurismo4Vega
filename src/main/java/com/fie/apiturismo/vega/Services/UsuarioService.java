package com.fie.apiturismo.vega.Services;

import com.fie.apiturismo.vega.Entities.UsuarioEntity;
import com.fie.apiturismo.vega.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioEntity validarCredenciales(String email, String contrasena) {
        return usuarioRepository.findByEmail(email)
                .filter(u -> u.getContrasena().equals(contrasena))
                .orElse(null);
    }
}

