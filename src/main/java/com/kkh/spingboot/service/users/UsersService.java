package com.kkh.spingboot.service.users;

import com.kkh.spingboot.domain.TestEntity.Users;
import com.kkh.spingboot.domain.TestEntity.UsersRepository;
import com.kkh.spingboot.web.dto.UsersResponseDto;
import com.kkh.spingboot.web.dto.UsersSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional
    public UsersResponseDto save(UsersSaveRequestDto requestDto){
        Long id = usersRepository.save(requestDto.toEntity()).getId();
        System.out.println(id);
        Users entity = usersRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("입력하신 정보로 데이터 생성이 실패하였습니다." ));
        System.out.println(entity.getName());
        return new UsersResponseDto(entity);
    }

}
