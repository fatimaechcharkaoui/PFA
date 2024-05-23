package ma.xproce.blood_donation.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
@Getter @Setter
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Temporal(TemporalType.DATE)

    private Date date;

    @Temporal(TemporalType.TIME)

    private Date heure;

    @ManyToOne
    @JoinColumn(name = "donateur_id")
    private Donateur donateur;

    @ManyToOne
    @JoinColumn(name = "center_id")
    private DonationCenter center;


}
