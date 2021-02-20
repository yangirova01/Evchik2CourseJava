package ru.itis.springbootdemo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.springbootdemo.models.Product;
import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductDto {
    private Long id;
    private Integer price;
    private String size;

    public static ProductDto from(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .price(product.getPrice())
                .size(product.getSize())
                .build();
    }
    public static List<ProductDto> from(List<Product> product){
        return product.stream().map(ProductDto::from).collect(Collectors.toList());
    }

}
