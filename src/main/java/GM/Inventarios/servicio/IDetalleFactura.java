package GM.Inventarios.servicio;

import GM.Inventarios.modelo.DetalleFactura;

import java.util.List;

public interface IDetalleFactura {

    public List<DetalleFactura> listarDetallesFactura();


    public DetalleFactura buscarDetalleFacturaPorId(Integer idDetalle);

    public DetalleFactura guardarDetalleFactura(DetalleFactura detalleFactura);

    public void eliminarDetalleFacturaPorId(Integer idDetalle);
}
