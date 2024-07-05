package com.example.barter.dto.entity;

import com.example.barter.dto.input.SaveUserInput;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@Table("user")
public class UserEntity {

    @Id
    String id;

    @NonNull
    String name;

    int age;

    List<String> products;

    @Column("profileimage")
    String profileImage;

    List<String> connections;


    public static UserEntity fromSaveUserInput(final SaveUserInput saveUserInput)
    {
        return UserEntity.builder()
                .id(saveUserInput.getId())
                .name(saveUserInput.getName())
                .age(saveUserInput.getAge())
                .products(new ArrayList<>())
                .profileImage(saveUserInput.getProfileImage())
                .connections(new ArrayList<>())
                .build();

    }

}


//CREATE TABLE user
//        (
//                id UUID primary key,
//                name varchar not null,
//                age int,
//                products jsonb,
//                profile varchar,
//                connections jsonb
//        );