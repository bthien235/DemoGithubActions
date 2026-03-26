package fit.btt.buithanhthien;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final StudentProfileRepository studentProfileRepository;

    public DataInitializer(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public void run(String... args) {
        if (studentProfileRepository.count() > 0) {
            return;
        }

        StudentProfile profile = new StudentProfile();
        profile.setFullName("Bùi Thanh Thiện");
        profile.setStudentCode("2280603028");
        profile.setClassName("22DTHH2");
        profile.setEmail("thien.2280603028@example.com");
        profile.setBio("Sinh viên thực hành Spring Boot, Docker và MySQL với giao diện đơn sắc, hiện đại.");
        studentProfileRepository.save(profile);
    }
}
