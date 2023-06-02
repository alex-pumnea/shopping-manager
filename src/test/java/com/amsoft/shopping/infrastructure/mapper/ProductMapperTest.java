package com.amsoft.shopping.infrastructure.mapper;

import com.amsoft.shopping.core.dto.BookDto;
import com.amsoft.shopping.core.dto.ElectronicsDto;
import com.amsoft.shopping.core.model.Book;
import com.amsoft.shopping.core.model.Electronics;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
/**
 * @author Alex Pumnea
 */
class ProductMapperTest {
    private final ProductMapper productMapper = new ProductMapper();

    @Test
    void shouldMapBookToBookDto() {
        // Given
        Book book = new Book("BookName", 10.0, 50, "Author", "Category");

        // When
        BookDto bookDto = productMapper.getBookDto(book);

        // Then
        assertThat(bookDto.getName()).isEqualTo("BookName");
        assertThat(bookDto.getPrice()).isEqualTo(10.0);
        assertThat(bookDto.getAuthor()).isEqualTo("Author");
        assertThat(bookDto.getCategory()).isEqualTo("Category");
    }

    @Test
    void shouldMapElectronicsToElectronicsDto() {
        // Given
        Electronics electronics = new Electronics("ElectronicsName", 20.0, 100, "Brand", "Model");

        // When
        ElectronicsDto electronicsDto = productMapper.getElectronicsDto(electronics);

        // Then
        assertThat(electronicsDto.getName()).isEqualTo("ElectronicsName");
        assertThat(electronicsDto.getPrice()).isEqualTo(20.0);
        assertThat(electronicsDto.getBrand()).isEqualTo("Brand");
        assertThat(electronicsDto.getModel()).isEqualTo("Model");
    }

}