package ojss.controller;


import ojss.domain.Job;
import ojss.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping(value = "/getJob/{pageNum}/{pageSize}")
    public List<Job> getJob(@PathVariable("pageNum") Integer pageNum,
                            @PathVariable("pageSize") Integer pageSize,
                            @RequestBody Job job) {
        List<Job> uList = jobService.findAll(pageNum, pageSize, job);
        return uList;
    }
}
