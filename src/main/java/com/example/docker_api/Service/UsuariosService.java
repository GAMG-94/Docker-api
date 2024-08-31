package com.example.docker_api.Service;

import com.example.docker_api.Entity.Usuarios;
import com.example.docker_api.Repository.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepo usuariosRepo;

    public List<Usuarios> getAll() {
        return usuariosRepo.findAll();
    }

    public Optional<Usuarios> getById(Long id) {
        return usuariosRepo.findById(id);
    }

    public Usuarios nuevoUsuario(Usuarios usuarios) {
        return usuariosRepo.save(usuarios);
    }

    public Usuarios actualizarUsuario(Usuarios usuarios, Long id) {
        Usuarios actualizado = usuariosRepo.findById(id).orElse(null);

        actualizado.setName(usuarios.getName());
        actualizado.setEmail(usuarios.getEmail());
        return usuariosRepo.save(actualizado);
    }

    public void borrar(Long id) {
        usuariosRepo.deleteById(id);
    }
}
