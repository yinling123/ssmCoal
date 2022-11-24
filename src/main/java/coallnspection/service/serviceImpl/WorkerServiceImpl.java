package coallnspection.service.serviceImpl;

import coallnspection.mapper.WorkerMapper;
import coallnspection.pojo.Worker;
import coallnspection.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    WorkerMapper workerMapper;

    @Override
    public boolean addWorker(Worker worker) {
        //进行工作人员增加
        int i = workerMapper.addWorker(worker);
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Worker> checkAllWorkers() {
        //进行工作人员查询
        List<Worker> workers = workerMapper.selectAllWorkers();
        return workers;
    }

    @Override
    public boolean deleteWorker(Worker worker) {
        //进行工作人员删除
        int i = workerMapper.deleteWorker(worker.getName());
        if(i > 0){
            return true;
        }
        return false;
    }

    @Override
    public Worker checkWorker(String area) {
        final Worker worker = workerMapper.selectWorker(area);
        return worker;
    }
}
