package controller;

import entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.CategorieRepository;

import java.util.Optional;

@RestController
@RequestMapping(path="/categorie")
public class CategorieController {

    @Autowired
    CategorieRepository categorieRepository ;

    @RequestMapping(path="/getCategorie/{name}")
    public Categorie getCategorieByName(String name) {

        Optional<Categorie> bouffe = categorieRepository.findByNameLike(name);
        return bouffe.orElse(null);
    }

    @RequestMapping(path="/deleteCategorie/{name}")
    public boolean deleteCategorieByName(String name){
        boolean categorieExist = categorieRepository.findByNameLike(name).isPresent();
        if (categorieExist) {
            categorieRepository.deleteByNameLike(name);
            return true;
        }
        else {
            return false;
        }
    }

    @RequestMapping(path="/createCategorie")
    public boolean createCategorie(@RequestBody Categorie categorie){
        boolean categorieExist = categorieRepository.findByNameLike(categorie.getName()).isPresent();
        if (categorieExist) {
            return false;
        }
        else {
            categorieRepository.save(categorie);
            return true;
        }
    }



}
