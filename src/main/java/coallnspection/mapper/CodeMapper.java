package coallnspection.mapper;

import coallnspection.pojo.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 验证码表的数据库方法接口
 */
public interface CodeMapper {

    /**
     * 进行验证码对象的增加
     * @param code
     */
    public int addCode(Code code);

    /**
     * 进行验证码判断
     * @return
     */
    public List<Code> selectCodes(@Param("phone") String phone, @Param("code") String code);
}
