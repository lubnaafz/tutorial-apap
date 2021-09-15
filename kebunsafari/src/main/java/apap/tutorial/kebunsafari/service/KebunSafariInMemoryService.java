package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService{
    private List<KebunSafariModel> listKebunSafari;

    public KebunSafariInMemoryService(){
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList() {
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari){

        for(KebunSafariModel kebunSafariModel : getKebunSafariList()) {
            if(kebunSafariModel.getIdKebunSafari().compareTo(idKebunSafari) == 0){
                return kebunSafariModel;
            }
        }
        return null;
    }

    @Override
    public void updateKebunSafari(KebunSafariModel kebunSafari, String noTelepon){
        kebunSafari.setNoTelepon(noTelepon);
    }

    @Override
    public void deleteKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.remove(kebunSafari);
    }

}
