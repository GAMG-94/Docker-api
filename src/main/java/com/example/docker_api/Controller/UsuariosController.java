package com.example.docker_api.Controller;

import com.example.docker_api.Entity.Usuarios;
import com.example.docker_api.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/todos")
    public List<Usuarios> getAll() {
        return usuariosService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Usuarios> getById(@PathVariable("id") Long id) {
        return usuariosService.getById(id);
    }

    @PostMapping("/nuevo")
    public Usuarios usuarios(@RequestBody Usuarios usuarios) {
        return usuariosService.nuevoUsuario(usuarios);
    }

    @PutMapping("/{id}")
    public Usuarios usuarios(@RequestBody Usuarios usuarios, @PathVariable("id") Long id) {
        return usuariosService.actualizarUsuario(usuarios, id);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable("id") Long id) {
        usuariosService.borrar(id);
    }

}
