package GM.Inventarios.controlador;

import GM.Inventarios.modelo.DetalleFactura;
import GM.Inventarios.servicio.DetalleServicio;
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
public class DetalleControlador {
    private static final Logger logger = LoggerFactory.getLogger(DetalleControlador.class);

    @Autowired
    private DetalleServicio detalleServicio;

    //http://localhost:8080/inventario-app/detalle

    @GetMapping("/detalles")

    public List<DetalleFactura> obtenerDetalles(){
        List<DetalleFactura> detalleFacturas = this.detalleServicio.listarDetallesFactura();
        logger.info("Detalles Obtenidos: ");
        detalleFacturas.forEach((detalleFactura -> logger.info(detalleFactura.toString())));
        return detalleFacturas;

    }

    @PostMapping("/detalles")
    public DetalleFactura agregarDetalle(@RequestBody DetalleFactura detalleFactura){
        logger.info("Detalle a agregar: " + detalleFactura);
        System.out.println("Se agrego un detalle");
        return this.detalleServicio.guardarDetalleFactura(detalleFactura);

    }

    @PutMapping("/detalles/{id}")
    public ResponseEntity<DetalleFactura> actualizarDetalle(
            @PathVariable int id,
            @RequestBody DetalleFactura detalleRecibido){
        DetalleFactura detalleFactura = this.detalleServicio.buscarDetalleFacturaPorId(id);
        detalleFactura.setFactura(detalleRecibido.getFactura());
        detalleFactura.setProducto(detalleRecibido.getProducto());
        detalleFactura.setCantidad(detalleRecibido.getCantidad());
        this.detalleServicio.guardarDetalleFactura(detalleFactura);

        return ResponseEntity.ok(detalleRecibido);
    }

    @DeleteMapping("/detalles/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarDetalle(@PathVariable int id){
        DetalleFactura detalleFactura = detalleServicio.buscarDetalleFacturaPorId((id));
        this.detalleServicio.eliminarDetalleFacturaPorId(detalleFactura.getIdDetalle());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado",Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
