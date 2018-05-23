package ojss.controller;

import ojss.domain.JobSeeker;
import ojss.service.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class JobSeekerController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping(value="/jobSeekerRegistration")
    public ModelAndView registerJSPage(ModelAndView modelAndView, JobSeeker jobSeeker) {
        modelAndView.addObject("jobSeeker", jobSeeker);
        modelAndView.setViewName("jobSeekerRegistration");
        return modelAndView;
    }

    @PostMapping(value="/jobSeekerRegistration")
    public ModelAndView validateRegistration(ModelAndView modelAndView, @Valid JobSeeker jobSeeker,
                                             BindingResult bindingResult, @RequestParam Map map) {
        JobSeeker jsExists = jobSeekerService.findJobSeekerByEmail(jobSeeker.getEmail());

        if (jsExists != null) {
            modelAndView.addObject("registeredEmail", "Sorry, this e-mail has been used");
            modelAndView.setViewName("jobSeekerRegistration");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()){
            modelAndView.setViewName("jobSeekerRegistration");
        } else {
            jobSeeker.setPassword(map.get("password").toString());
            modelAndView.addObject("registrationSuccess","Congratulations!");
            jobSeekerService.addNewJobSeeker(jobSeeker);

        }
        return modelAndView;


    }

    @GetMapping(value="/jobSeekerLogin")
    public ModelAndView displayJobSeekerLoginPage(ModelAndView modelAndView, JobSeeker jobRecruiter) {
        modelAndView.addObject("jobSeeker", jobRecruiter);
        modelAndView.setViewName("jobSeekerLogin");
        return modelAndView;
    }

    @RequestMapping(value = "/jobSeekerLogin", method = RequestMethod.POST)
    public ModelAndView jobSeekerLogin(JobSeeker jobSeeker, ModelAndView modelAndView,BindingResult bindingResult) {
        JobSeeker jsExists = jobSeekerService.findJobSeekerByEmail(jobSeeker.getEmail());
        JobSeeker jsMatches = jobSeekerService.verifyJobSeeker(jobSeeker);

        //boolean verify = jobRecruiterService.verifyJobRecruiter(jobRecruiter);
        if (jsExists == null) {
            modelAndView.addObject("emailNotExist", "The email address that you've entered doesn't match any account.");
            modelAndView.setViewName("jobSeekerLogin");
        } else if (jsMatches != null){
            //modelAndView.addObject("loginSuccess", "Welcome back, " + jobRecruiter.getUserName() + "!");
            modelAndView.setViewName("redirect:homePage");
        } else {
            modelAndView.addObject("wrongPwd", "Wrong password!");
            modelAndView.setViewName("jobSeekerLogin");
        }
        return modelAndView;
    }

    @GetMapping(value = "/updateJobSeekerDetails")
    public ModelAndView updateJobSeekerDetails(ModelAndView modelAndView, JobSeeker jobSeeker) {
        return modelAndView;
    }


}
