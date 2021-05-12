package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Computer;
import org.mybatis.cdi.Mapper;

@Mapper
public interface ComputerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPUTER
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPUTER
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    int insert(Computer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPUTER
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    Computer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPUTER
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    List<Computer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.COMPUTER
     *
     * @mbg.generated Tue May 11 11:49:17 EEST 2021
     */
    int updateByPrimaryKey(Computer record);
}