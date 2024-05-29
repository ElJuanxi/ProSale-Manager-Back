package GM.Inventarios.controlador;

import GM.Inventarios.modelo.Usuario;
import GM.Inventarios.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http://localhost:8080/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100", "https://prosale-manager.netlify.app", "https://f17c-190-60-223-122.ngrok-free.app"})
public class UsuarioControlador {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioControlador.class);

    @Autowired
    private UsuarioServicio usuarioServicio;

    //http://localhost:8080/inventario-app/usuarios

    @GetMapping("/usuarios")
    public List<Usuario> obtenerUsuarios(){
        List<Usuario> usuarios = this.usuarioServicio.listarUsuarios();
        logger.info("Usuarios Obtenidos: ");
        usuarios.forEach((usuario -> logger.info(usuario.toString())));
        return usuarios;
    }

    @PostMapping("/usuarios")
    public Usuario agregarUsuarios(@RequestBody Usuario usuario){
        logger.info("Producto a agregar: " + usuario);
        return this.usuarioServicio.guardarUsuario(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(
            @PathVariable int id,
            @RequestBody Usuario usuarioRecibido){


        Usuario usuario = this.usuarioServicio.buscarUsuarioPorId(id);
        usuario.setName(usuarioRecibido.getName());
        usuario.setUsername(usuarioRecibido.getUsername());
        usuario.setLastname(usuarioRecibido.getLastname());
        usuario.setRol(usuarioRecibido.getRol());
        usuario.setTelefono(usuarioRecibido.getTelefono());
        usuario.setStatus(usuarioRecibido.getStatus());
        this.usuarioServicio.guardarUsuario(usuario);

        System.out.println("llega");    
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarUsuario(@PathVariable int id){
        Usuario usuario = usuarioServicio.buscarUsuarioPorId(((id)));
        this.usuarioServicio.eliminarUsuarioPorId(usuario.getIdUser());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}
