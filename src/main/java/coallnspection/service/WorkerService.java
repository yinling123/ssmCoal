package coallnspection.service;

import coallnspection.pojo.Worker;

import java.util.List;

/**
 * 进行工作员表的相关操作接口
 */
public interface WorkerService {
    /**
     * 进行工作人员添加
     * @param worker
     * @return 若添加失败，返回false
     */
    public boolean addWorker(Worker worker);

    /**
     * 进行工作人员查询
     * @return 若查询成功，返回对应的员工列表
     */
    public List<Worker> checkAllWorkers();

    /**
     * 进行工作人员删除
     * @param worker
     * @return 若删除失败，返回false
     */
    public boolean deleteWorker(Worker worker);

    /**
     * 进行工作人员查询
     * @param area
     * @return
     */
    public Worker checkWorker(String area);
}
