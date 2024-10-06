package GM.Inventarios.repositorio;

import GM.Inventarios.modelo.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
    @Query("SELECT f FROM Factura f JOIN FETCH f.detalles WHERE f.idFactura = :idFactura")
    Factura findFacturaConDetalle(@Param("idFactura")Integer idFactura);
}
