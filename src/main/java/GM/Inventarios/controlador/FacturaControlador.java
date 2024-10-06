package GM.Inventarios.controlador;


import GM.Inventarios.modelo.Factura;
import GM.Inventarios.servicio.FacturaServicio;
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
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100", "https://prosale-manager.netlify.app"})


public class FacturaControlador {
    private static final Logger logger = LoggerFactory.getLogger(FacturaControlador.class);

    @Autowired
    private FacturaServicio facturaServicio;

    //http://localhost:8080/inventario-app/facturas
    @GetMapping("/facturas")

    public List<Factura> obtenerFacturas() {
        List<Factura> facturas = this.facturaServicio.listarFacturas();
        logger.info("Facturas Realizadas: ");
        facturas.forEach((factura -> logger.info(factura.toString())));
        return facturas;
    }


    @GetMapping("/facturas/{id}/detalle")
    public ResponseEntity<Factura> obtenerFacturaConDetalles(@PathVariable Integer id) {
        Factura factura = this.facturaServicio.obtenerFacturaConDetalles(id);
        return ResponseEntity.ok(factura);
    }


    @PostMapping("/facturas")
    public Factura agregarFactura(@RequestBody Factura factura) {
        logger.info("Factura a agregar: "+ factura);
        System.out.println("aqui se agrego una");
        return this.facturaServicio.guardarFactura(factura);
    }

    @PutMapping("/facturas/{id}")
    public ResponseEntity<Factura> actualizarFactura(
            @PathVariable int id,
            @RequestBody Factura facturaRecibida){

        Factura factura = this.facturaServicio.buscarFacturaPorId(id);
        factura.setFecha(facturaRecibida.getFecha());
        factura.setTotal(facturaRecibida.getTotal());
        factura.setUsuario(facturaRecibida.getUsuario());


        return ResponseEntity.ok(factura);
    }

    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarFactura(@PathVariable int id) {
        Factura factura = facturaServicio.buscarFacturaPorId((id));
        this.facturaServicio.eliminarFacturaPorId(factura.getIdFactura());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}
