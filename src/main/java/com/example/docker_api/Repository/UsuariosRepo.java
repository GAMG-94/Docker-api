package com.example.docker_api.Repository;

import com.example.docker_api.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepo extends JpaRepository<Usuarios, Long> {
}
