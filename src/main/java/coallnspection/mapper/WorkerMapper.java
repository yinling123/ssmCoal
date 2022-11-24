package coallnspection.mapper;

import coallnspection.pojo.Worker;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 针对worker数据表的操作
 */
@Repository
public interface WorkerMapper {

    //增加worker
    public int addWorker(Worker worker);

    //删除worker
    public int deleteWorker(String name);

    //查询所有员工
    public List<Worker> selectAllWorkers();

    //查找某个区域
    public Worker selectWorker(String area);

}
