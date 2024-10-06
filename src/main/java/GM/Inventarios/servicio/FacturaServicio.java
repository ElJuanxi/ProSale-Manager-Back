package GM.Inventarios.servicio;

import GM.Inventarios.modelo.Factura;
import GM.Inventarios.repositorio.FacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServicio implements IFactura{

    @Autowired
    private FacturaRepositorio facturaRepositorio;


    @Override
    public List<Factura> listarFacturas() {
        return facturaRepositorio.findAll();
    }

    @Override
    public Factura buscarFacturaPorId(Integer idFactura) {
        return facturaRepositorio.findById(idFactura).orElse(null);
    }

    @Override
    public Factura guardarFactura(Factura factura) {
        return this.facturaRepositorio.save(factura);
    }

    @Override
    public void eliminarFacturaPorId(Integer idFactura) {
        facturaRepositorio.deleteById(idFactura);
    }

    public Factura obtenerFacturaConDetalles(Integer idFactura){
        return facturaRepositorio.findFacturaConDetalle(idFactura);
    }

}
