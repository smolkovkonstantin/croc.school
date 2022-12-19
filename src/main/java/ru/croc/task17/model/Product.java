package ru.croc.task17.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_product")
public class Product {

    @Id
    @Column(name = "id_product")
    private String idProduct;

    private String nameProduct;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "my_order_id")
    private Order order;
}
