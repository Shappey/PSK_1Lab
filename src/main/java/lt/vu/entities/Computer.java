package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "Computer.findAll", query = "select a from Computer as a")
})
@Table(name = "COMPUTER")
@Getter
@Setter
public class Computer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "NAME")
    private String name;

    @Column(name = "HEIGHT")
    private Integer height;

    @Column(name = "LENGTH")
    private Integer length;

    @Column(name = "BUILD_DATE")
    private Date buildDate;

    @Column(name = "WARRANTY_END_DATE")
    private Date warrantyEnd;

    @ManyToMany(mappedBy = "computers")
    private List<Part> parts;

}
