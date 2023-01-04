//package com.kkh.spingboot.web;
//
//import com.kkh.spingboot.service.users.UsersService;
//import com.kkh.spingboot.web.dto.UsersResponseDto;
//import com.kkh.spingboot.web.dto.UsersSaveRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class UsersApiController {
//
//    private final UsersService usersService;
//
//    @PostMapping("/api/v1/users")
//    public UsersResponseDto save(@RequestBody UsersSaveRequestDto requestDto) {
//        return usersService.save(requestDto);
//    }
//}
