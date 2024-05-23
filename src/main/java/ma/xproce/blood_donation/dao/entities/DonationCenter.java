package ma.xproce.blood_donation.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@AllArgsConstructor  @NoArgsConstructor
@Getter
@Setter
@Table(name = "donation_centers")
public class DonationCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String Tel;

    @OneToMany(mappedBy = "center")
    private List<Appointment> appointment;
}
