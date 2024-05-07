package GM.Inventarios.servicio;

import GM.Inventarios.modelo.Usuario;
import GM.Inventarios.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<Usuario> listarUsuarios() {
        return this.usuarioRepositorio.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer idUser) {
        return this.usuarioRepositorio.findById(idUser).orElse(null);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return this.usuarioRepositorio.save(usuario);
    }

    @Override
    public void eliminarUsuarioPorId(Integer idUser) {
        this.usuarioRepositorio.deleteById(idUser);
    }
}
