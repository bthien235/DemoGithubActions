package fit.btt.buithanhthien;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final StudentProfileRepository studentProfileRepository;

    public HomeController(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @GetMapping("/")
    public String home(@RequestParam(name = "saved", required = false) String saved, Model model) {
        StudentProfile profile = studentProfileRepository.findTopByOrderByIdAsc().orElseGet(StudentProfile::new);
        model.addAttribute("profile", profile);
        model.addAttribute("saved", saved != null);
        return "index";
    }

    @PostMapping("/profile")
    public String saveProfile(@ModelAttribute("profile") StudentProfile formProfile) {
        Optional<StudentProfile> existingProfile = studentProfileRepository.findTopByOrderByIdAsc();
        StudentProfile profile = existingProfile.orElseGet(StudentProfile::new);

        profile.setFullName(formProfile.getFullName());
        profile.setStudentCode(formProfile.getStudentCode());
        profile.setClassName(formProfile.getClassName());
        profile.setEmail(formProfile.getEmail());
        profile.setBio(formProfile.getBio());

        studentProfileRepository.save(profile);
        return "redirect:/?saved=1";
    }
}
