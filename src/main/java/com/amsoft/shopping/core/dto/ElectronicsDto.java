package com.amsoft.shopping.core.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents a data transfer object (DTO) for electronics.
 * Extends the {@link ProductDto} class.
 * Contains additional attributes specific to electronics.
 * Provides getters and setters for accessing the attributes.
 * Overrides the toString() method to provide a string representation of electronics.
 * Implements equals() and hashCode() methods based on the attributes.
 *
 * @author Alex Pumnea
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ElectronicsDto extends ProductDto {
    private final String productBrand;
    private final String productModel;

    public ElectronicsDto(String productName, double productPrice, String productBrand, String productModel) {
        super(productName, productPrice);
        this.productBrand = productBrand;
        this.productModel = productModel;
    }

    @Override
    public String toString() {
        return "Electronics - " +
                "productName='" + getName() + '\'' +
                "productPrice=" + getPrice() + '\'' +
                "productBrand='" + productBrand + '\'' +
                "productModel='" + productModel + '\'';
    }
}
