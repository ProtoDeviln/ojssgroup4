
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
    public ModelAndView displayHomePage(ModelAndView modelAndView, Job job) {
        modelAndView.addObject("job", job);
        modelAndView.setViewName("homePage");
        return modelAndView;
    }


    @PostMapping(value="/homePage")
    public ModelAndView searchPage(ModelAndView modelAndView, Job job) {
        modelAndView.addObject("job", job);
        modelAndView.setViewName("homePage");
        List<Job> jobList = jobService.findByJobName(job.getJobName());
        if (jobList.isEmpty()){
            modelAndView.setViewName("homePage");
            return modelAndView;
        }
        else {
            modelAndView.addObject("jobList", jobList);
            modelAndView.setViewName("redirect:jobList");
            return modelAndView;}
    }


    /*
    @PostMapping(value = "/jobListPage/{pageNum}/{pageSize}")
    public List<Job> getJob(@PathVariable("pageNum") Integer pageNum,
                            @PathVariable("pageSize") Integer pageSize,
                            @RequestBody Job job) {
        List<Job> jobList = jobService.findAll(pageNum, pageSize, job);
        return jobList;
    }
    */
}
