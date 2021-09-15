package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.service.KebunSafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import apap.tutorial.kebunsafari.model.KebunSafariModel;

import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
            @RequestParam (value="id", required = true) String idKebunSafari,
            @RequestParam (value="nama", required = true) String namaKebunSafari,
            @RequestParam (value="alamat", required = true) String alamat,
            @RequestParam (value="noTelepon", required = true) String noTelepon,
            Model model
    ){
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        kebunSafariService.addKebunSafari(kebunSafari);

        model.addAttribute("kebunSafari", kebunSafari);

        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        model.addAttribute("listKebunSafari", listKebunSafari);

        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(@RequestParam(value="id", required = true) String idKebunSafari, Model model){
        if(idKebunSafari.equalsIgnoreCase("") || kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            return "error-page";
        }else {
            KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

            model.addAttribute("kebunSafari", kebunSafari);

            return "detail-kebun-safari";
        }
    }

    @GetMapping(value="kebun-safari/view/{idKebunSafari}")
    public String getKebunSafariByIdPath(@PathVariable(value = "idKebunSafari") String idKebunSafari, Model model){

        if(idKebunSafari.equalsIgnoreCase("") || kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            return "error-page";
        }else {
            KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

            model.addAttribute("kebunSafari", kebunSafari);

            return "detail-kebun-safari";
        }
    }

    @RequestMapping("/kebun-safari/update/{idKebunSafari}")
    public String updateKebunSafari(
            @PathVariable(value = "idKebunSafari") String idKebunSafari,
            @RequestParam (value="noTelepon", required = true) String noTelepon, Model model
    ){
        if(idKebunSafari.equalsIgnoreCase("") || kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            return "error-page";
        }else{
            KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

            kebunSafariService.updateKebunSafari(kebunSafari, noTelepon);

            model.addAttribute("kebunSafari", kebunSafari);

            return "update-kebun-safari";
        }
    }

    @RequestMapping("/kebun-safari/delete/{idKebunSafari}")
    public String deleteKebunSafari(
            @PathVariable(value = "idKebunSafari") String idKebunSafari, Model model
    ){

        if(idKebunSafari.equalsIgnoreCase("") || kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari) == null){
            return "error-page";
        }else{
            KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

            kebunSafariService.deleteKebunSafari(kebunSafari);

            model.addAttribute("kebunSafari", kebunSafari);

            return "delete-kebun-safari";
        }

    }

}
