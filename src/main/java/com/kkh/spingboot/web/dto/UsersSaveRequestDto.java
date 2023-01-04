//package com.kkh.spingboot.web.dto;
//
//import com.kkh.spingboot.domain.TestEntity.Users;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//@Getter
//@NoArgsConstructor
//public class UsersSaveRequestDto {
//
//    private String name;
//    private int age;
//    private String address;
//    private String identifyNumber;
//
//    @Builder
//    public UsersSaveRequestDto(String name, int age, String address, String identifyNumber){
//        this.name = name;
//        this.age = age;
//        this.address = address;
//        this.identifyNumber = identifyNumber;
//    }
//
//    public Users toEntity() {
//        return Users.builder()
//                .name(name)
//                .age(age)
//                .address(address)
//                .identfyNumber(identifyNumber)
//                .build();
//    }
//}
