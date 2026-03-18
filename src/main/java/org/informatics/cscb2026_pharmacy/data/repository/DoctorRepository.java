package org.informatics.cscb2026_pharmacy.data.repository;

import org.informatics.cscb2026_pharmacy.data.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
