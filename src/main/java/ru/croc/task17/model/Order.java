package ru.croc.task17.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_order")
public class Order {

    @Id
    @Column(name = "id_my_order")
    private Long idOrder;

    private String customerName;

    @OneToMany(mappedBy = "order")
    private List<Product> products;
}
