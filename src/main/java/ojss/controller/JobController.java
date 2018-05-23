package ojss.controller;


import ojss.domain.Job;
import ojss.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping(value="/homePage")
    public ModelAndView searchPage(ModelAndView modelAndView) {
        modelAndView.setViewName("homePage");
        return modelAndView;
    }

    @PostMapping(value = "/jobListPage/{pageNum}/{pageSize}")
    public List<Job> getJob(@PathVariable("pageNum") Integer pageNum,
                            @PathVariable("pageSize") Integer pageSize,
                            @RequestBody Job job, ModelAndView modelAndView) {
        modelAndView.addObject("job", job);
        List<Job> jobList = jobService.findAll(pageNum, pageSize, job);
        return jobList;
    }
}
