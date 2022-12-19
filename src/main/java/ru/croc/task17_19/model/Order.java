package ru.croc.task17_19.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "my_order")
public class Order {

    @Id
    @Column(name = "id_my_order")
    private Long idOrder;

    private String customerName;

    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    private List<Product> products;
}
