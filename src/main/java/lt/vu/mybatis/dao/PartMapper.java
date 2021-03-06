package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Part;
import org.mybatis.cdi.Mapper;

@Mapper
public interface PartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PART
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PART
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    int insert(Part record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PART
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    Part selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PART
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    List<Part> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PART
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    int updateByPrimaryKey(Part record);
}