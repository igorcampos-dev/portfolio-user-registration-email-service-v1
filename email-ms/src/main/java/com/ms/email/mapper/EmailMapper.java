package com.ms.email.mapper;

import com.ms.email.models.dto.request.EmailRequestDto;
import com.ms.email.models.entity.EmailEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class EmailMapper {

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "emailTo", source = "emailTo")
    @Mapping(target = "subject", source = "subject")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "emailFrom", source = "emailFrom")
    @Mapping(target = "sendDateEmail", source = "sendDateEmail")
    @Mapping(target = "statusEmail", source = "statusEmail")
    public abstract EmailEntity toEntity(EmailRequestDto dto);

}
