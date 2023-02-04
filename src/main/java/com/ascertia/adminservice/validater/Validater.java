package com.ascertia.adminservice.validater;

import com.ascertia.adminservice.dto.UsersDTO;
import com.ascertia.adminservice.entities.Users;
import com.ascertia.adminservice.exceptions.ApplicationException;
import com.ascertia.adminservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Validater {
    @Autowired
    private UsersRepository usersRepository;

    public void checkUserAlreadyExists(UsersDTO usersDTO) {
        Optional<Users> checkEmail=usersRepository.findByEmail(usersDTO.getEmail());
        if(checkEmail.isPresent())
            throw new ApplicationException("1002", "Email already registerd in our system");
        Optional<Users> checkMobile=usersRepository.findByMobile(usersDTO.getMobile());
        if(checkMobile.isPresent())
            throw new ApplicationException("1003", "Mobile already registerd in our system");
    }
}
