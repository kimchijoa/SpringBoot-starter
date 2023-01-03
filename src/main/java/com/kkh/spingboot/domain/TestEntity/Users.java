package com.kkh.spingboot.domain.TestEntity;

import com.kkh.spingboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseTimeEntity {
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String address;
    @Column
    private String identfyNumber;

    @Builder
    public Users(String name, int age, String address, String identfyNumber){
        this.name = name;
        this.age = age;
        this.address = address;
        this.identfyNumber = identfyNumber;
    }
}
