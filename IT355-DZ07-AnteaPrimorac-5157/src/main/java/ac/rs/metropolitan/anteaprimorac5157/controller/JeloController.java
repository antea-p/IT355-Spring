package ac.rs.metropolitan.anteaprimorac5157.controller;

import ac.rs.metropolitan.anteaprimorac5157.entity.Jelo;
import ac.rs.metropolitan.anteaprimorac5157.repository.RestoranRepository;
import ac.rs.metropolitan.anteaprimorac5157.service.JeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jelo")
public class JeloController {

    private final JeloService jeloService;
    private final RestoranRepository restoranRepository;

    @Autowired
    public JeloController(JeloService jeloService, RestoranRepository restoranRepository) {
        this.jeloService = jeloService;
        this.restoranRepository = restoranRepository;
    }

    @GetMapping
    public String listJelo(@RequestParam(name = "naziv", required = false) String naziv, Model model) {
        if (naziv != null && !naziv.isEmpty()) {
            model.addAttribute("jela", jeloService.filterByNaziv(naziv));
        } else {
            model.addAttribute("jela", jeloService.list());
        }
        return "jelo/list";
    }

    @GetMapping("/new")
    public String showNewJeloForm(Model model) {
        model.addAttribute("jelo", new Jelo());
        model.addAttribute("restorani", restoranRepository.findAll());
        return "jelo/create";
    }

    @PostMapping("/save")
    public String saveJelo(@Valid @ModelAttribute("jelo") Jelo jelo, BindingResult result, Model model) {
    model.addAttribute("restorani", restoranRepository.findAll()); // Always populate the list of restaurants for the form
    if (result.hasErrors()) {
        // Provjera vrijednosti ID-a kako bi se utvrdilo je li korisnik kreirao ili ažurirao jelo
        if (jelo.getId() == null) {
            return "jelo/create";
        } else {
            return "jelo/edit";
        }
    }
        jeloService.save(jelo);
        return "redirect:/jelo";
    }

    @GetMapping("/edit/{id}")
    public String showEditJeloForm(@PathVariable Long id, Model model) {
        model.addAttribute("jelo", jeloService.get(id));
        model.addAttribute("restorani", restoranRepository.findAll());
        return "jelo/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteJelo(@PathVariable Long id) {
        jeloService.delete(id);
        return "redirect:/jelo";
    }

    @GetMapping("/show/{id}")
    public String showJeloDetails(@PathVariable Long id, Model model) {
        model.addAttribute("jelo", jeloService.get(id));
        return "jelo/show";
    }
}
