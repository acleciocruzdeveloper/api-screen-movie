package io.nosql.app.screen_movie.services;

import io.nosql.app.screen_movie.domain.Usuarios;
import io.nosql.app.screen_movie.dto.UsuariosDTO;
import io.nosql.app.screen_movie.repositories.IUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUsersRepository iUsersRepository;

    private final PasswordEncoder passwordEncoder;

    public List<Usuarios> findAllUser() {
        return iUsersRepository.findAll();
    }

    public Usuarios findById(String id) {
        return iUsersRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario not found!"));
    }

    public UsuariosDTO cadastrar(UsuariosDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Usuarios usuarios = Usuarios.converterUserDomain(user);
        usuarios = iUsersRepository.save(usuarios);
        return UsuariosDTO.converterToUserModel(usuarios);
    }

    public void deleteUser(String id) {
        iUsersRepository.deleteById(id);
    }

    public UsuariosDTO findByUsername(String email) {
        Usuarios usuarios = iUsersRepository
                .findByEmail(email).orElseThrow(
                        () -> new RuntimeException("usuario nao encontrado"));

        return UsuariosDTO.converterToUserModel(usuarios);
    }
}
