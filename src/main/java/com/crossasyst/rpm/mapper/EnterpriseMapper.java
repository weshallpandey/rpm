package com.crossasyst.rpm.mapper;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.response.EnterpriseResponse;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface EnterpriseMapper {
    EnterpriseEntity modelToEntity(Enterprise enterprise);

    List<Enterprise> entityToModel(List<EnterpriseEntity> enterpriseEntities);
    Enterprise entityToModel(EnterpriseEntity enterpriseEntity);

}
