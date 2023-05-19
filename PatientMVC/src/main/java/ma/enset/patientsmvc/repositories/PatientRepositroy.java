package ma.enset.patientsmvc.repositories;

import ma.enset.patientsmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepositroy extends JpaRepository<Patient, Long> {
    //Pageable method
    public Page<Patient> findByNomContains(String keyword, Pageable pageable);
}
