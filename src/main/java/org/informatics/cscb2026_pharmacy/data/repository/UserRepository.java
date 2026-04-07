package org.informatics.cscb2026_pharmacy.data.repository;

import org.informatics.cscb2026_pharmacy.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
