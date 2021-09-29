package apap.tutorial.emsidi.repository;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CabangDb extends JpaRepository<CabangModel, Long> {
    Optional<CabangModel> findByNoCabang(Long noCabang);
    List<CabangModel> findAllByOrderByNamaCabangAsc();
}
