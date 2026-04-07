package org.informatics.cscb2026_pharmacy.service.impl;

import lombok.RequiredArgsConstructor;
import org.informatics.cscb2026_pharmacy.data.repository.UserRepository;
import org.informatics.cscb2026_pharmacy.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
