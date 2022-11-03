package coallnspection.service.serviceImpl;

import coallnspection.mapper.CodeMapper;
import coallnspection.pojo.Code;
import coallnspection.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService {

    @Autowired
    CodeMapper codeMapper;

    @Override
    public int addCode(Code code) {
        //进行验证码增加操作
        int i = codeMapper.addCode(code);
        return i;
    }

    @Override
    public List<Code> selectCodes(String phone,String code) {
        //进行验证码查询操作
        List<Code> codes = codeMapper.selectCodes(phone,code);
        return codes;
    }
}
