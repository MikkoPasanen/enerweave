package enerweave.backend.repository;

import enerweave.backend.entity.HEMS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HEMSRepository extends JpaRepository<HEMS, Long> {
    // This method fetches all HEMS entities that support at least one of the hardware models specified in the input list.
    // *
    // * It uses a custom JPQL (Java Persistence Query Language) query to:
    // * 1. Join the HEMS entities with their associated Hardware entities (via the `supportedHardwares` relationship).
    // * 2. Filter the results to include only those HEMS entities whose supported Hardware models match any of the hardware models provided in the `models` list.
    @Query("SELECT h FROM HEMS h JOIN h.supportedHardwares hw WHERE hw.model IN :models")
    List<HEMS> findHEMSBySupportedHardwareModels(@Param("models") List<String> models);
}
