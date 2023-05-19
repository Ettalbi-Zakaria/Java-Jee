package ma.enset.patientsmvc.web;

import jakarta.servlet.http.HttpServlet;
import lombok.AllArgsConstructor;
import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepositroy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor // Dependency injection using constructor
public class PatientController {
    private PatientRepositroy patientRepositroy;

    @GetMapping(path = "/index")
        public String PatientsList(Model model, @RequestParam(name = "page",defaultValue = "0") int page , @RequestParam(name = "size",defaultValue = "5") int size,  @RequestParam(name = "keyword",defaultValue = "") String keyword) {
        /*
                Page<Patient> patientsList =  patientRepositroy.findAll(PageRequest.of(page,size));
         */
        Page<Patient> patientsList =  patientRepositroy.findByNomContains(keyword, PageRequest.of(page,size));

        model.addAttribute("patientsList",patientsList.getContent());
        model.addAttribute("totalPages",new int[patientsList.getTotalPages()]);
        model.addAttribute("currentPage",page);
        model.addAttribute("keyword",keyword);
        return "patients";
    }

    @GetMapping(path = "/delete")
    public String delete(@RequestParam(name = "id") Long  id, @RequestParam(name = "page",defaultValue = "0") int page,@RequestParam(name = "keyword",defaultValue = "") String keyword){
        patientRepositroy.deleteById(id);
        return "redirect:/index?page="+page+"&keyword="+keyword+"";
    }


    @GetMapping(path = "/")
    public String Default(){
    return "redirect:/index";
    }

    @GetMapping("/patientslistjson")
    @ResponseBody
    public List<Patient> PatientsListJson(){
        return patientRepositroy.findAll();
    }


}
