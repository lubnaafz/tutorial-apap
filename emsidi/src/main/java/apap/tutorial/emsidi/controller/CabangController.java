package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class CabangController {

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Autowired
    private MenuService menuService;

    public ArrayList<MenuModel> listMenuTemp = new ArrayList<MenuModel>();

    @GetMapping("/cabang/add")
    public String addCabangForm(
            Model model
    ){
        listMenuTemp.add(new MenuModel());

        model.addAttribute("listMenuTemp", listMenuTemp);
        model.addAttribute("listMenu", menuService.getListMenu());;
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }

    @GetMapping("/cabang/viewall")
    public String listCabang(Model model){
        List<CabangModel> listCabang = cabangService.getCabangList();
        if(listCabang.size() != 0) {
            model.addAttribute("listCabang", listCabang);
            return "viewall-cabang";
        }
        return "cabang-not-found";
    }

    @GetMapping("/cabang/view")
    public String viewDetailCabangAsc(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenu", cabang.getListMenu());
        model.addAttribute("listPegawai", listPegawai);

        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "update-cabang";
    }
//////////////////////////////////////////////////////////////////////////

    @GetMapping("/cabang/viewallasc")
    public String listCabangAsc(Model model){
        List<CabangModel> listCabang = cabangService.getCabangAsc();

        if(listCabang.size() != 0) {
            model.addAttribute("listCabang", listCabang);
            return "viewall-cabang";
        }
        return "cabang-not-found";
    }

    @GetMapping("/cabang/delete/{noCabang}")
    public String deletePegawai(
            @PathVariable Long noCabang,
            Model model
    ){
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        int jumlahPegawai = cabang.getListPegawai().size();
        if (jumlahPegawai == 0 && cabangService.isCabangClose(noCabang)){
            cabangService.deleteCabang(cabang);
            model.addAttribute("noCabang", cabang.getNoCabang());
            return "delete-cabang";
        }
        return "error";
    }
/////////////////////////////////////////////////////////////////
    @PostMapping(value="/cabang/add", params = {"addRow"})
    public String addRow(
            final BindingResult bindingResult,
            Model model
    ){
        listMenuTemp.add(new MenuModel());

        model.addAttribute("listMenuTemp", listMenuTemp);
        model.addAttribute("listMenu", menuService.getListMenu());
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping(value="/cabang/add", params={"deleteRow"})
    public String deleteRow(
            final BindingResult bindingResult,
            final HttpServletRequest req,
            Model model
    ){
        int indexRow = Integer.valueOf(req.getParameter("deleteRow"));
        listMenuTemp.remove(indexRow);

        model.addAttribute("listMenuTemp", listMenuTemp);
        model.addAttribute("listMenu", menuService.getListMenu());
        model.addAttribute("cabang", new CabangModel());
        return "form-add-cabang";
    }

    @PostMapping(value="/cabang/add/{noCabang}", params={"save"})
    public String cabangAddAllSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ){
        ArrayList<MenuModel> listMenuTemp = new ArrayList<MenuModel>();
        for(MenuModel menu : listMenuTemp){
            listMenuTemp.add(menu);
        }
        cabang.setListMenu(listMenuTemp);

        model.addAttribute("cabang",new CabangModel());
        return "add-cabang";
    }
}
