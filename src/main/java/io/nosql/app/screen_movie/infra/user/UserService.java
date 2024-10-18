package io.nosql.app.screen_movie.infra.user;

import io.nosql.app.screen_movie.domain.Usuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUsersRepository iUsersRepository;

    public List<Usuarios> findAllUser() {
        return iUsersRepository.findAll();
    }

    public Usuarios findById(String id) {
        return iUsersRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public Usuarios cadastrar(Usuarios user) {
        return iUsersRepository.save(user);
    }

    public void deleteUser(String id) {
        iUsersRepository.deleteById(id);
    }
}
