package lt.vu.mybatis.model;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Component;
import lt.vu.entities.Computer;

import java.util.ArrayList;
import java.util.List;

public class Part {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PART.ID
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PART.PART_NAME
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    private String partName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.PART.PRICE
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    private Double price;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PART.ID
     *
     * @return the value of PUBLIC.PART.ID
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PART.ID
     *
     * @param id the value for PUBLIC.PART.ID
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PART.PART_NAME
     *
     * @return the value of PUBLIC.PART.PART_NAME
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    public String getPartName() {
        return partName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PART.PART_NAME
     *
     * @param partName the value for PUBLIC.PART.PART_NAME
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    public void setPartName(String partName) {
        this.partName = partName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.PART.PRICE
     *
     * @return the value of PUBLIC.PART.PRICE
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.PART.PRICE
     *
     * @param price the value for PUBLIC.PART.PRICE
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = (computers);
    }

    @Getter
    @Setter
    private List<Component> components;

    @Getter @Setter
    private List<Computer> computers;
}