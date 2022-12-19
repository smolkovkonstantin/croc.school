package ru.croc.task17_19.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String nameProduct;

    @ManyToOne
    @JoinColumn(name = "my_order_id")
    private Order order;

    private Integer price;

    private String productCode;
}
