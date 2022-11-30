package com.gientech.study.demo.mapper;

import com.gientech.study.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public
interface UserMapper {

    /**
     * getUserById
     *
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    UserEntity getUserById(Integer id);

    /**
     * getUsers
     *
     * @param name
     * @param age
     * @param startNo
     * @param pageSize
     * @return
     */
    @Select("""
               <script>
                    select * from user
                    <where>
                        <if test='name != null'>
                            and `name` like CONCAT(CONCAT('%', #{name,jdbcType=VARCHAR}), '%')
                        </if>
                        <if test='age != null'>
                            and `age` = #{age,jdbcType=INTEGER}
                        </if>
                    </where>
                    limit #{startNo}, #{pageSize}
                </script>
            """)
    List<UserEntity> getUsers(String name, Integer age, Integer startNo, Integer pageSize);
}
