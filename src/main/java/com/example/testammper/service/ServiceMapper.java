package com.example.testammper.service;

import com.example.testammper.model.entity.UsersEntity;
import com.example.testammper.model.request.users.SignUpRequest;
import com.example.testammper.model.response.InstitutionsResponse;
import com.example.testammper.model.response.belvo.institutions.InstitutionsDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceMapper {

    ServiceMapper INSTANCE = Mappers.getMapper(ServiceMapper.class);

    @Mapping(target = "id", source = "id")
    List<InstitutionsResponse> toInstitutionsResponseList(List<InstitutionsDetailResponse> detailResponseList);

    UsersEntity toUserEntity(SignUpRequest request);
}
