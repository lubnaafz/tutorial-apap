package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

public interface CabangService {
    void addCabang(CabangModel cabang);
    void updateCabang(CabangModel cabang);
    List<CabangModel> getCabangList();
    CabangModel getCabangByNoCabang(Long noCabang);
    /////////////////////////
    List<CabangModel> getCabangAsc();
    void deleteCabang(CabangModel cabang);
    boolean isCabangClose(Long noCabang);

}
