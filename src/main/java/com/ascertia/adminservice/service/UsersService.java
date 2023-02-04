package com.ascertia.adminservice.service;

import com.ascertia.adminservice.dto.UsersDTO;
import com.ascertia.adminservice.entities.Users;
import com.ascertia.adminservice.exceptions.ApplicationException;
import com.ascertia.adminservice.mapper.UsersMapper;
import com.ascertia.adminservice.repository.UsersRepository;
import com.ascertia.adminservice.validater.Validater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersMapper usersMapper;

    @Autowired
    Validater validater;

    public void saveUser(UsersDTO usersDTO) {
        log.info("In UserService.saveUser()");
        validater.checkUserAlreadyExists(usersDTO);
        Users user = usersMapper.DtotoEntity(usersDTO);
        user.setUuid(UUID.randomUUID().toString());
        log.info("In UserService.saveUser() going to save user in to the database");
        usersRepository.save(user);
    }

    public void updateUser(UsersDTO usersDTO) {
        log.info("In UserService.updateUser()");
        Users user = usersMapper.DtotoEntity(usersDTO);
        log.info("In UserService.updateUser()  going to update user in to the database");
        usersRepository.save(user);

    }

    public List<UsersDTO> getAllUsers() {
        log.info("In UserService.getAllUsers()");
        List<Users> users = usersRepository.findAll();
        return Optional.of(users).stream().flatMap(Collection::stream).map(users1 -> usersMapper.EntitytoDto(users1)).collect(Collectors.toList());

    }

    public List<UsersDTO> searchUser(UsersDTO usersDTO) {
        log.info("In UserService.searchUser()");
        Users user = usersMapper.DtotoEntity(usersDTO);
        log.info("In UserService.searchUser()  going to search user using criteria provided");
        List<Users> users = usersRepository.findAll(Example.of(user));
        return Optional.of(users).stream().flatMap(Collection::stream).map(users1 -> usersMapper.EntitytoDto(users1)).collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        log.info("In UserService.deleteUser()  going to delete user by id");
        Optional<Users> user = usersRepository.findById(id);
        if (user.isEmpty()) {
            throw new ApplicationException("1001", "Id not found in our system");

        }
        usersRepository.deleteById(id);
    }
}


