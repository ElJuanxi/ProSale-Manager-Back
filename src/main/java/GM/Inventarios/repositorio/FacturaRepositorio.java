package GM.Inventarios.repositorio;

import GM.Inventarios.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
}
