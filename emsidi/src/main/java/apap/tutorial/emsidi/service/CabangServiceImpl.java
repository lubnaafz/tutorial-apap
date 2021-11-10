package apap.tutorial.emsidi.service;


import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.CabangDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


@Service
@Transactional
public class CabangServiceImpl implements CabangService {

    @Autowired
    CabangDb cabangDb;

    @Override
    public void addCabang(CabangModel cabang) {
        cabangDb.save(cabang);
    }

    @Override
    public void updateCabang(CabangModel cabang) {
        cabangDb.save(cabang);
    }

    @Override
    public List<CabangModel> getCabangList() {
        return cabangDb.findAll();
    }

    @Override
    public CabangModel getCabangByNoCabang(Long noCabang) {
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        if (cabang.isPresent()) {
            return  cabang.get();
        }
        return null;
    }

    /////////////////////////////////
    @Override
    public List<CabangModel> getCabangAsc() {
        return cabangDb.findAllByOrderByNamaCabangAsc();
    }

    @Override
    public void deleteCabang(CabangModel cabang){cabangDb.delete(cabang);}

    @Override
    public boolean isCabangClose(Long noCabang){
        Optional<CabangModel> cabang = cabangDb.findByNoCabang(noCabang);
        LocalTime waktuTutup = cabang.get().getWaktuTutup();
        LocalTime now = LocalTime.now();
        Boolean isClose = now.isAfter( waktuTutup );
        return isClose;
    }


}
