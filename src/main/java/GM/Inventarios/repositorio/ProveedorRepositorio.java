package GM.Inventarios.repositorio;

import GM.Inventarios.modelo.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositorio extends JpaRepository<Proveedor, Integer> {
}
