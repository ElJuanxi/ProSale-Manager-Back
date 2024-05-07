package GM.Inventarios.servicio;

import GM.Inventarios.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    public List<Usuario> listarUsuarios();

    public Usuario buscarUsuarioPorId(Integer idUser);
    public Usuario guardarUsuario(Usuario usuario);
    public void eliminarUsuarioPorId(Integer idUser);
}
