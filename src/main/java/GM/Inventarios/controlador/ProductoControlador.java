package GM.Inventarios.controlador;
import GM.Inventarios.modelo.Producto;
import GM.Inventarios.servicio.ProductoServicio;

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
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100", "https://prosale-manager.netlify.app", "https://0c66-191-156-151-144.ngrok-free.app"})
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);


    @Autowired
    private ProductoServicio productoServicio;

    //http://localhost:8080/inventario-app/productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos Obtenidos: ");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto){
        logger.info("Producto a agregar: " + producto);
        System.out.println("aqui se agrego algo");
        return this.productoServicio.guardarProducto(producto);
    }


    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoRecibido){


        Producto producto = this.productoServicio.buscarProductoPorId(id);
        producto.setNombreProducto(productoRecibido.getNombreProducto());
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setProveedor(productoRecibido.getProveedor());
        producto.setPrecioprov(productoRecibido.getPrecioprov());
        producto.setStock(productoRecibido.getStock());
        this.productoServicio.guardarProducto(producto);

        System.out.println("llega");
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarProducto(@PathVariable int id){
        Producto producto = productoServicio.buscarProductoPorId((id));
        this.productoServicio.eliminarProductoPorId(producto.getIdProducto());
        Map<String,Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }


}


