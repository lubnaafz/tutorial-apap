package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;

import java.util.List;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);
    ///////////////////////////////////////
    void updatePegawai(PegawaiModel pegawai);
    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
    List<PegawaiModel> getPegawaiList();
    void deletePegawai(PegawaiModel pegawai);
    boolean isEmpty(String namaPegawai);
}
