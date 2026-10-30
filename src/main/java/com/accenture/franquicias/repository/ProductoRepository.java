package com.accenture.franquicias.repository;
import com.accenture.franquicias.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductoRepository extends JpaRepository<Producto,Long> { java.util.List<Producto> findBySucursalId(Long id); }
