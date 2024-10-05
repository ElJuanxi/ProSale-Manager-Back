package GM.Inventarios.servicio;

import GM.Inventarios.modelo.DetalleFactura;
import GM.Inventarios.repositorio.DetalleFacturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetalleServicio implements IDetalleFactura{

    @Autowired
    private DetalleFacturaRepositorio detalleFacturaRepositorio;


    @Override
    public List<DetalleFactura> listarDetallesFactura() {
        return this.detalleFacturaRepositorio.findAll();
    }

    @Override
    public DetalleFactura buscarDetalleFacturaPorId(Integer idDetalle) {
        return this.detalleFacturaRepositorio.findById(idDetalle).orElse(null);
    }

    @Override
    public DetalleFactura guardarDetalleFactura(DetalleFactura detalleFactura) {
        return this.detalleFacturaRepositorio.save(detalleFactura);
    }

    @Override
    public void eliminarDetalleFacturaPorId(Integer idDetalle) {
        this.detalleFacturaRepositorio.deleteById(idDetalle);
    }
}
