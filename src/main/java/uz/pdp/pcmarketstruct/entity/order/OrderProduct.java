package uz.pdp.pcmarketstruct.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.pcmarketstruct.entity.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User userDatabase;

    @OneToMany(fetch = FetchType.LAZY)
    List<OrderProductCountDatabase> orderProductCountDatabases;

    private int stateId;

    private BigDecimal totalSum = BigDecimal.valueOf(0);
}
