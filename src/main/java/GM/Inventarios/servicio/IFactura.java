package GM.Inventarios.servicio;

import GM.Inventarios.modelo.Factura;

import java.util.List;

public interface IFactura {
    public List<Factura> listarFacturas();

    public Factura buscarFacturaPorId(Integer idFactura);

    public Factura guardarFactura(Factura factura);

    public void eliminarFacturaPorId(Integer idFactura);
}
