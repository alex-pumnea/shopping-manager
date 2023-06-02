package com.amsoft.shopping.application;

import com.amsoft.shopping.core.dto.BookDto;
import com.amsoft.shopping.core.dto.ElectronicsDto;
import com.amsoft.shopping.core.dto.ProductDto;
import com.amsoft.shopping.core.factory.BookFactory;
import com.amsoft.shopping.core.factory.ElectronicsFactory;
import com.amsoft.shopping.core.model.Book;
import com.amsoft.shopping.core.model.Electronics;
import com.amsoft.shopping.core.repository.ProductRepository;
import com.amsoft.shopping.infrastructure.mapper.ProductMapper;
import com.amsoft.shopping.infrastructure.repository.ProductRepositoryImpl;
import com.amsoft.shopping.infrastructure.service.ShoppingCartServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Alex Pumnea
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        ProductRepository<ProductDto> productRepository = new ProductRepositoryImpl();
        ShoppingCartServiceImpl shoppingCart = new ShoppingCartServiceImpl(productRepository);
        BookFactory bookFactory = new BookFactory();
        ElectronicsFactory electronicsFactory = new ElectronicsFactory();
        ProductMapper mapper = new ProductMapper();


        Book book = bookFactory.createBook("Name", 2, 20, "John", "Drama");
        BookDto bookDto = mapper.getBookDto(book);
        productRepository.save(bookDto, book.getQuantity());
        shoppingCart.addToCart(bookDto, 1);
        shoppingCart.displayCartItems();

        Electronics electronics = electronicsFactory.createElectronics("Phone", 300, 5, "Iphone", "13");
        ElectronicsDto electronicsDto = mapper.getElectronicsDto(electronics);
        productRepository.save(electronicsDto, electronics.getQuantity());
        shoppingCart.addToCart(electronicsDto, 5);
        log.info(String.valueOf(shoppingCart.totalPrice()));
        shoppingCart.displayCartItems();
        shoppingCart.removeFromCart(bookDto, 1);
        shoppingCart.removeFromCart(electronicsDto, 3);
        shoppingCart.displayCartItems();
    }


}
