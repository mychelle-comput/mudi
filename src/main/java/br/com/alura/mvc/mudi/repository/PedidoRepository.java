package br.com.alura.mvc.mudi.repository;


import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long>{

    List<Pedido> findByStatus(StatusPedido status);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username") String username);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username and p.status = :status")
    List<Pedido> findByStatusUsuario(StatusPedido status, @Param("username") String username);
}
