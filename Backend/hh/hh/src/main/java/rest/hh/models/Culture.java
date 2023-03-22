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
    @GeneratedValue
    private Long id;
    private String name;
    private Double optimalTemperature;
    private LocalDateTime optimalTime;
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
