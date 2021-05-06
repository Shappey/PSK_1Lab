package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;
import lt.vu.enums.ComponentType;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
})
@Table(name = "COMPONENT")
@Getter
@Setter
public class Component implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "COMPONENT_NAME")
    private String componentName;

    @Column(name = "TYPE")
    private ComponentType type;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @ManyToOne
    private Part part;


}
