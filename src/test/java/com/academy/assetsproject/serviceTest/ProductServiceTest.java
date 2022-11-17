package com.academy.assetsproject.serviceTest;

import com.academy.assetsproject.enums.CategoryType;
import com.academy.assetsproject.exception.RecordNotFoundException;
import com.academy.assetsproject.models.Products;
import com.academy.assetsproject.repository.ProductRepository;
import com.academy.assetsproject.services.ProductService;
import com.academy.assetsproject.services.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService = new ProductServiceImpl();



    Products furniture1 = new Products(1L, "Furniture1", 100, LocalDate.now(), CategoryType.FURNITURE);
    Products furniture2 = new Products(2L, "Furniture1", 200, LocalDate.now(), CategoryType.FURNITURE);
    Products officeSupplies1 = new Products(3L, "OfficeSupplies1", 300, LocalDate.now(), CategoryType.OFFICE_SUPPLIES);
    Products officeSupplies2 = new Products(4L, "OfficeSupplies2", 400, LocalDate.now(), CategoryType.OFFICE_SUPPLIES);
    List<Products> products =  List.of(furniture1,furniture2,officeSupplies1,officeSupplies2);
    Pageable pageable1 = PageRequest.of(0,20);
    Page<Products> productsList = new PageImpl<>(products,pageable1,products.size());

    @Test
    @DisplayName("Given products from repository with the setup above " +
            "WHEN findAllProducts is executed" +
            "THEN result should return data")
    void testFindAllProducts() throws RecordNotFoundException {
        //arrange
        Mockito.when(productService.findAllProducts(pageable1)).thenReturn(productsList);
        //act
        Page<Products> filteredEmployees = productService.findAllProducts(pageable1);
        //assert
        assertThat(filteredEmployees).hasSize(4);
    }

    @Test
    @DisplayName("Given products from repository with the setup above " +
            "WHEN findAllByCategory is executed with value FURNITURE" +
            "THEN result should return furniture data")
    void testFindByCategory() throws RecordNotFoundException {
        // arrange
        Mockito.when(productRepository.findAll(pageable1)).thenReturn(productsList);
        // act
        Page<Products> expectedResult = productService.findByCategory(CategoryType.FURNITURE, pageable1);
        // assert
        List<Products> expected = List.of(furniture1,furniture2);
        Page<Products> expectedPage = new PageImpl<>(expected);
        assertEquals(expectedPage, expectedResult);
    }

    @Test
    @DisplayName("Given products from repository with the setup above " +
            "WHEN findFindByProductID is executed" +
            "THEN result should return data")
    void testFindByProductID() throws RecordNotFoundException {
        //vic arrange
        Mockito.when(productRepository.findById(anyLong())).thenReturn(Optional.ofNullable(furniture2));
        // act
        Optional<Products> result = productService.findByProductById(2L);
        // assert
        assertEquals(furniture2,result.get());
    }

    @Test
    @DisplayName("Given products from repository with the setup above " +
            "WHEN saveProducts is executed" +
            "THEN result should save data")
    void testSaveProduct() throws RecordNotFoundException {
        //arrange
        Products expectedProducts = new Products(4L, "OfficeSupplies2", 400, LocalDate.now(), CategoryType.OFFICE_SUPPLIES);
        Mockito.when(productService.saveProducts(any(Products.class))).thenReturn(expectedProducts);
        //act
        Products result = productService.saveProducts(expectedProducts);
        verify(productRepository).save(expectedProducts);
        //assert
        assertEquals(result, expectedProducts);
    }

    @Test
    @DisplayName("Given products from repository with the setup above " +
            "WHEN findUpdateProducts is executed" +
            "THEN result should update the data")
    void testUpdateProduct() throws RecordNotFoundException {
        //ali
    }

    @Test
    @DisplayName("Given products from repository with the setup above " +
            "WHEN deleteProduct is executed" +
            "THEN result should delete the data")
    void testDeleteProduct() throws RecordNotFoundException {
        //vic
    }
}
