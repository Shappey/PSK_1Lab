package lt.vu.mybatis.model;

public class Component {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMPONENT.ID
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMPONENT.COMPONENT_NAME
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    private String componentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMPONENT.TYPE
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.COMPONENT.PART_ID
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    private Integer partId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMPONENT.ID
     *
     * @return the value of PUBLIC.COMPONENT.ID
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMPONENT.ID
     *
     * @param id the value for PUBLIC.COMPONENT.ID
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMPONENT.COMPONENT_NAME
     *
     * @return the value of PUBLIC.COMPONENT.COMPONENT_NAME
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public String getComponentName() {
        return componentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMPONENT.COMPONENT_NAME
     *
     * @param componentName the value for PUBLIC.COMPONENT.COMPONENT_NAME
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMPONENT.TYPE
     *
     * @return the value of PUBLIC.COMPONENT.TYPE
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMPONENT.TYPE
     *
     * @param type the value for PUBLIC.COMPONENT.TYPE
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.COMPONENT.PART_ID
     *
     * @return the value of PUBLIC.COMPONENT.PART_ID
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public Integer getPartId() {
        return partId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.COMPONENT.PART_ID
     *
     * @param partId the value for PUBLIC.COMPONENT.PART_ID
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    public void setPartId(Integer partId) {
        this.partId = partId;
    }
}