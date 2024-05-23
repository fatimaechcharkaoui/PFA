package ma.xproce.blood_donation.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter
@Setter
@Table(name = "donateurs")
public class Donateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String bloodGroup;
    private String tel;

    @OneToMany(mappedBy = "donateur")
    private List<Appointment> appointment;
}
