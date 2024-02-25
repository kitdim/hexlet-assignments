package exercise.mapper;

import exercise.dto.*;
import exercise.model.Product;
import org.mapstruct.*;

// BEGIN
@Mapper(
        uses = {JsonNullableMapper.class, ReferenceMapper.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(source = "categoryId", target = "category")
    public abstract Product map(ProductCreateDTO dto);

    @InheritConfiguration
    public abstract Product update(ProductUpdateDTO dto, @MappingTarget Product model);

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    public abstract ProductDTO map(Product model);
}
// END
