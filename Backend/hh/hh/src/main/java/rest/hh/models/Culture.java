package rest.hh.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cultures")
public class Culture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(name = "description", length = 4096)
    private String description;
    private Double optimalTemperature;
    private String optimalTime;
    @Column(name = "tips", length = 4096)
    private String tips;
    @ManyToOne
    @JoinColumn(name = "type")
    private CultureType type;
    @ManyToMany(mappedBy = "cultures")
    private List<City> cities = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "cultures_user",
            joinColumns = {@JoinColumn(name="culture_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")}
    )
    private List<User> users = new ArrayList<>();
}
