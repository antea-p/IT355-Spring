package ac.rs.metropolitan.anteaprimorac5157.controller;

import ac.rs.metropolitan.anteaprimorac5157.entity.Restoran;
import ac.rs.metropolitan.anteaprimorac5157.service.RestoranService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/restoran")
public class RestoranController {

    private final RestoranService restoranService;

    @Autowired
    public RestoranController(RestoranService restoranService) {
        this.restoranService = restoranService;
    }

    @GetMapping
    public String listRestorani(Model model) {
        model.addAttribute("restorani", restoranService.list());
        return "restoran/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("restoran", new Restoran());
        return "restoran/create";
    }

    @PostMapping("/save")
    public String saveRestoran(@Valid @ModelAttribute Restoran restoran, BindingResult result) {
        if (result.hasErrors()) {
            // Provjera vrijednosti ID-a kako bi se utvrdilo je li korisnik kreirao ili ažurirao restoran
            if (restoran.getId() == null) {
                return "restoran/create";
            } else {
                return "restoran/edit";
            }
        }

        extractJelaList(restoran);

        restoranService.save(restoran);
        return "redirect:/restoran";
    }

    private void extractJelaList(Restoran restoran) {
        if (restoran.getId() != null) {
            Optional<Restoran> existingRestoran = restoranService.get(restoran.getId());
            if (existingRestoran.isPresent()) {
                Restoran existing = existingRestoran.get();
                restoran.setJela(existing.getJela());
            }
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Restoran restoran = restoranService.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid restoran Id:" + id));
        model.addAttribute("restoran", restoran);
        return "restoran/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestoran(@PathVariable Long id) {
        restoranService.delete(id);
        return "redirect:/restoran";
    }

    @GetMapping("/show/{id}")
    public String showRestoran(@PathVariable("id") Long id, Model model) {
        Restoran restoran = restoranService.get(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid restoran Id: " + id));
        model.addAttribute("restoran", restoran);
        return "restoran/show";
    }

}