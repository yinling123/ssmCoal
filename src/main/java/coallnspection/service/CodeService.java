package coallnspection.service;

import coallnspection.pojo.Coalmine;
import coallnspection.pojo.Code;

import java.util.List;

/**
 * 进行验证码的业务操作方法接口
 */
public interface CodeService {

    /**
     * 进行验证码的增加操作
     * @param code
     */
    public int addCode(Code code);

    /**
     * 查询所有的验证码
     * @return
     */
    public List<Code> selectCodes(String phone,String code);

}
