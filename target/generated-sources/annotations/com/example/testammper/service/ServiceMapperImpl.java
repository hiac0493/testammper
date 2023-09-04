package com.example.testammper.service;

import com.example.testammper.model.entity.UsersEntity;
import com.example.testammper.model.request.users.SignUpRequest;
import com.example.testammper.model.response.InstitutionsResponse;
import com.example.testammper.model.response.belvo.institutions.InstitutionsDetailResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-01T13:05:05-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (JetBrains s.r.o.)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public List<InstitutionsResponse> toInstitutionsResponseList(List<InstitutionsDetailResponse> detailResponseList) {
        if ( detailResponseList == null ) {
            return null;
        }

        List<InstitutionsResponse> list = new ArrayList<InstitutionsResponse>( detailResponseList.size() );
        for ( InstitutionsDetailResponse institutionsDetailResponse : detailResponseList ) {
            list.add( institutionsDetailResponseToInstitutionsResponse( institutionsDetailResponse ) );
        }

        return list;
    }

    @Override
    public UsersEntity toUserEntity(SignUpRequest request) {
        if ( request == null ) {
            return null;
        }

        UsersEntity usersEntity = new UsersEntity();

        usersEntity.setName( request.getName() );
        usersEntity.setLastname( request.getLastname() );
        usersEntity.setUsername( request.getUsername() );
        usersEntity.setPass( request.getPass() );

        return usersEntity;
    }

    protected InstitutionsResponse institutionsDetailResponseToInstitutionsResponse(InstitutionsDetailResponse institutionsDetailResponse) {
        if ( institutionsDetailResponse == null ) {
            return null;
        }

        InstitutionsResponse institutionsResponse = new InstitutionsResponse();

        institutionsResponse.setId( institutionsDetailResponse.getId() );
        institutionsResponse.setDisplayName( institutionsDetailResponse.getDisplayName() );
        institutionsResponse.setName( institutionsDetailResponse.getName() );

        return institutionsResponse;
    }
}
