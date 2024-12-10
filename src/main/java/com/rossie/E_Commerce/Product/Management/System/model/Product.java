package com.rossie.E_Commerce.Product.Management.System.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Table(name = "products")
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(nullable = false)
    private String productName;

    @Column
    @Size(max = 1000, message = "Description is too long")
    private String productDescription;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.00", message = "Price must be positive")
    @Column(nullable = false, precision = 11, scale = 2)
    private BigDecimal productPrice;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be Negative")
    @Column(nullable = false)
    private int productStock;

    @Column(updatable = false)
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updateAt;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    private Category category;

}
