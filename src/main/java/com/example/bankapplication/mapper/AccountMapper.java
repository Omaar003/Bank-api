package com.example.bankapplication.mapper;

import com.example.bankapplication.dto.AccountResponse;
import com.example.bankapplication.entity.AccountEntity;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity toEntity(AccountResponse dto);
    AccountResponse toDto(AccountEntity entity);


    AccountResponse toDto(Optional<AccountEntity> accountEntity2);
}
