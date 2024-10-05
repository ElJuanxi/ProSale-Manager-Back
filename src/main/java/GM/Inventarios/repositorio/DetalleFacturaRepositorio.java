package GM.Inventarios.repositorio;

import GM.Inventarios.modelo.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Integer> {
}
