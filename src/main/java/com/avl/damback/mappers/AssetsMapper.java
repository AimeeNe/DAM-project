package com.avl.damback.mappers;

import com.avl.damback.dto.AssetsDto;
import com.avl.damback.entities.Assets;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AssetsMapper {
    Assets toEntity(AssetsDto assetsDto);

    AssetsDto toDto(Assets assets);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Assets partialUpdate(AssetsDto assetsDto, @MappingTarget Assets assets);
}