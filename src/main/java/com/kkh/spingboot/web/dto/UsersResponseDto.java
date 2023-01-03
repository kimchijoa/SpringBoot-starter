package com.kkh.spingboot.web.dto;

import com.kkh.spingboot.domain.TestEntity.Users;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UsersResponseDto {
    private String name;
    private int age;
    private String address;
    private String identifyNumber;
    private LocalDateTime created;
    private LocalDateTime updated;

    public UsersResponseDto(Users entity) {
        this.name = entity.getName();
        this.age = entity.getAge();
        this.address = entity.getAddress();
        this.identifyNumber = entity.getIdentfyNumber();
        this.created = entity.getCreateDate();
        this.updated = entity.getUpdateDate();
    }
}
