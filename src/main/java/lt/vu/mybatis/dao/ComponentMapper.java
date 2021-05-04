package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Component;
import org.mybatis.cdi.Mapper;

@Mapper
public interface ComponentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPONENT
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPONENT
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    int insert(Component record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPONENT
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    Component selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPONENT
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    List<Component> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPONENT
     *
     * @mbg.generated Tue May 04 01:43:36 EEST 2021
     */
    int updateByPrimaryKey(Component record);
}