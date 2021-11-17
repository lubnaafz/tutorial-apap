package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;

@Controller
public class PegawaiController {
    @Qualifier("pegawaiServiceImpl")
    @Autowired
    PegawaiService pegawaiService;

    @Qualifier("cabangServiceImpl")
    @Autowired
    CabangService cabangService;

    @GetMapping("/pegawai/add/{noCabang}")
    public String addPegawaiForm(
            @PathVariable Long noCabang,
            Model model){
        PegawaiModel pegawai = new PegawaiModel();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        pegawai.setCabang(cabang);
        model.addAttribute("noCabang", noCabang);
        model.addAttribute("pegawai", pegawai);
        return "form-add-pegawai";
    }

    @PostMapping("/pegawai/add")
    public String addPegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ){
        String umur = "1";
        pegawai.setUmur(umur);
        pegawaiService.addPegawai(pegawai);
        model.addAttribute("noCabang", pegawai.getCabang().getNoCabang());
        model.addAttribute("namaPegawai", pegawai.getNamaPegawai());
        return "add-pegawai";
    }
///////////////////////////////////////////////////

    @GetMapping("/pegawai/update/{noPegawai}")
    public String updatePegawaiForm(
            @PathVariable Long noPegawai,
            Model model
    ){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();
        LocalTime now = LocalTime.now();

        if(now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())) {
            model.addAttribute("pegawai", pegawai);
            return "form-update-pegawai";
        }
        return "error";
    }

    @PostMapping("/pegawai/update")
    public String updatePegawaiSubmit(
            @ModelAttribute PegawaiModel pegawai,
            Model model
    ){
        String umur = "1";
        pegawai.setUmur(umur);
        pegawaiService.updatePegawai(pegawai);
        model.addAttribute("noPegawai", pegawai.getNoPegawai());
        return "update-pegawai";
    }

    @GetMapping("/pegawai/delete/{noPegawai}")
    public String deletePegawai(
            @PathVariable Long noPegawai,
            Model model
    ){
        PegawaiModel pegawai = pegawaiService.getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();
        LocalTime now = LocalTime.now();

        if(now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())) {
            pegawaiService.deletePegawai(pegawai);
            model.addAttribute("noPegawai", pegawai.getNoPegawai());
            return "delete-pegawai";
        }
        return "error";
    }

    @PostMapping("/pegawai/delete")
    public String deletePegawaiSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        LocalTime now = LocalTime.now();
        if (now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
            for (PegawaiModel pegawai: cabang.getListPegawai()) {
                pegawaiService.deletePegawai(pegawai);
            }
            model.addAttribute("noCabang", cabang.getNoCabang());
            return "delete-pegawai";
        }
        return "error";
    }

}
