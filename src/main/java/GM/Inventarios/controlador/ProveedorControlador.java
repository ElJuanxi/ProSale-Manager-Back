package GM.Inventarios.controlador;
import GM.Inventarios.modelo.Proveedor;
import GM.Inventarios.servicio.ProveedorServicio;


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
public class ProveedorControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProveedorControlador.class);


    @Autowired
    private ProveedorServicio proveedorServicio;

    //http://localhost:8080/inventario-app/proveedores
    @GetMapping("/proveedores")

    public List<Proveedor> obtenerProveedores(){
        List<Proveedor> proveedores = this.proveedorServicio.listarProveedores();
        logger.info("Proveedores Obtenidos: ");
        proveedores.forEach((proveedor -> logger.info(proveedor.toString())));
        return proveedores;
    }

    @PostMapping("/proveedores")
    public Proveedor agregarProveedor(@RequestBody Proveedor proveedor){
        logger.info("Proveedor a agregar: " + proveedor);
        System.out.println("aqui se agrego uno");
        return this.proveedorServicio.guardarProveedor(proveedor);
    }

    @PutMapping("/proveedores/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(
            @PathVariable int id,
            @RequestBody Proveedor proveedorRecibido){

        Proveedor proveedor = this.proveedorServicio.buscarProveedorPorId(id);
        proveedor.setNombreProveedor(proveedorRecibido.getNombreProveedor());
        proveedor.setCelular(proveedorRecibido.getCelular());
        proveedor.setDireccion(proveedorRecibido.getDireccion());
        proveedor.setNit(proveedorRecibido.getNit());
        proveedor.setTelefono(proveedorRecibido.getTelefono());
        this.proveedorServicio.guardarProveedor(proveedor);

        return ResponseEntity.ok(proveedor);
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProveedor(@PathVariable int id){
        Proveedor proveedor = proveedorServicio.buscarProveedorPorId((id));
        this.proveedorServicio.eliminarProveedorPorId(proveedor.getIdProveedor());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }



}
