package com.ascertia.adminservice.mapper;

import com.ascertia.adminservice.dto.UsersDTO;
import com.ascertia.adminservice.entities.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UsersMapper {

    public Users DtotoEntity(UsersDTO usersDTO) {
        log.info("In UsersMapper.DtotoEntity()");
        return Users.builder().id(usersDTO.getId()).name(usersDTO.getName()).mobile(usersDTO.getMobile()).email(usersDTO.getEmail()).build();
    }

    public UsersDTO EntitytoDto(Users users) {
        log.info("In UsersMapper.EntitytoDto()");
        return UsersDTO.builder().id(users.getId()).name(users.getName()).mobile(users.getMobile()).email(users.getEmail()).build();
    }
}
