package ru.itis.springbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.ProductDto;
import ru.itis.springbootdemo.models.Product;
import ru.itis.springbootdemo.repositories.ProductRepository;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getProductBySizeAndPrice(String size, int price) {
        List<Product> product = productRepository.findAllByPriceBeforeAndSize(price,size);
        return ProductDto.from(product);
    }
}
