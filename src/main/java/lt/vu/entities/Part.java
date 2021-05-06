package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
})
@Table(name = "PART")
@Getter
@Setter
//@EqualsAndHashCode(of={"productID"})
public class Part implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 20)
    @Column(name = "PART_NAME")
     private String name;

    @Column(name = "PRICE")
    private Integer price;

    /// MAYBE CHANGE
   // @Column(name = "PRODUCT_ID")
   //  private Integer productID;

    @OneToMany(mappedBy = "part")
    private List<Component> components;

    @ManyToMany
    private List<Computer> computers;

}
