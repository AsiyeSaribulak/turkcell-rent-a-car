package kodlama.io.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

//lombok
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "brands")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;




}
