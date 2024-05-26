package GM.Inventarios.servicio;


import GM.Inventarios.modelo.Proveedor;
import GM.Inventarios.repositorio.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicio implements IProveedorServicio {

    @Autowired
    private ProveedorRepositorio proveedorRepositorio;

    @Override
    public List<Proveedor> listarProveedores(){
        return this.proveedorRepositorio.findAll();
    }

    @Override
    public Proveedor buscarProveedorPorId(Integer idProveedor) {
        return this.proveedorRepositorio.findById(idProveedor).orElse(null);
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor){
        return this.proveedorRepositorio.save(proveedor);
    }

    @Override
    public void eliminarProveedorPorId(Integer idProveedor){
        this.proveedorRepositorio.deleteById(idProveedor);
    }

}
