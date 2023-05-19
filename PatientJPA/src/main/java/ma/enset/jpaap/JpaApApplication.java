package ma.enset.jpaap;

import ma.enset.jpaap.entities.Patient;
import ma.enset.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);

    }


    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 100; i++) {
            patientRepository.save(new Patient(null,"zakaria",  new Date(),true,(int) (Math.random()*100)));
        }

        List<Patient> patients = patientRepository.findAll();
        patients.forEach(patient -> {
            System.out.println(patient);
        });
        System.out.println("============================================");
        Patient patient = patientRepository.findById (1L).orElseThrow(()->new RuntimeException("Patient Not Found"));

    }
}
