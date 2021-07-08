package uz.pdp.pcmarketstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(nullable = false)
    private int quantity;       // skladda borligi bu kiritilishi shart
    @Column(nullable = false)
    private BigDecimal price;
    private String params;

    @ManyToOne
    @JoinColumn(
            name = "category_id",
            nullable = false
    )
    private Category categoryDatabase; // category_database_id bb saqlanadi




}
