package GM.Inventarios.servicio;

import GM.Inventarios.modelo.Proveedor;

import java.util.List;

public interface IProveedorServicio {

    public List<Proveedor> listarProveedores();

    public Proveedor buscarProveedorPorId(Integer idProveedor);

    public Proveedor guardarProveedor(Proveedor proveedor);

    public void eliminarProveedorPorId(Integer idProducto);
}
