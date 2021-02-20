package ru.itis.springbootdemo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDtoForRequst {
    private String size;
    private String price;
}
