package ojss.controller;

import ojss.domain.Job;
import ojss.domain.JobRecruiter;
import ojss.service.JobRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class JobRecruiterController {

    private JobRecruiterService jobRecruiterService;

    @Autowired
    public JobRecruiterController(JobRecruiterService jobRecruiterService) {
        this.jobRecruiterService = jobRecruiterService;
    }

    @GetMapping(value="/jobRecruiterLogin")
    public ModelAndView displayJobRecruiterLoginPage(ModelAndView modelAndView, JobRecruiter jobRecruiter) {
        modelAndView.addObject("jobRecruiter", jobRecruiter);
        modelAndView.setViewName("jobRecruiterLogin");
        return modelAndView;
    }

    @RequestMapping(value = "/jobRecruiterLogin", method = RequestMethod.POST)
    public ModelAndView jobRecruiterLogin(JobRecruiter jobRecruiter, ModelAndView modelAndView,BindingResult bindingResult) {
        JobRecruiter jrExists = jobRecruiterService.findByEmail(jobRecruiter.getEmail());
        JobRecruiter jrMatches = jobRecruiterService.verifyJobRecruiter(jobRecruiter);

        //boolean verify = jobRecruiterService.verifyJobRecruiter(jobRecruiter);
        if (jrExists == null) {
            modelAndView.addObject("emailNotExist", "The email address that you've entered doesn't match any account.");
            modelAndView.setViewName("jobRecruiterLogin");
        } else if (jrMatches != null){
            //modelAndView.addObject("loginSuccess", "Welcome back, " + jobRecruiter.getUserName() + "!");
            modelAndView.setViewName("redirect:homePage");
        } else {
            modelAndView.addObject("wrongPwd", "Wrong password!");
            modelAndView.setViewName("jobRecruiterLogin");
        }
        return modelAndView;
    }


    @GetMapping(value="/jobRecruiterRegistration")
    public ModelAndView registerJRPage(ModelAndView modelAndView, JobRecruiter jobRecruiter) {
        modelAndView.addObject("jobRecruiter", jobRecruiter);
        modelAndView.setViewName("jobRecruiterRegistration");
        return modelAndView;
    }

    @PostMapping(value="/jobRecruiterRegistration")
    public ModelAndView validateRegistration(ModelAndView modelAndView, @Valid JobRecruiter jobRecruiter,
                                             BindingResult bindingResult, @RequestParam Map map) {
        JobRecruiter jrExists = jobRecruiterService.findByEmail(jobRecruiter.getEmail());

        if (jrExists != null) {
            modelAndView.addObject("registeredEmail", "Sorry, this e-mail has been used");
            modelAndView.setViewName("jobRecruiterRegistration");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()){
            modelAndView.setViewName("jobRecruiterRegistration");
        } else {
            jobRecruiter.setPassword(map.get("password").toString());
            modelAndView.addObject("registrationSuccess","Congratulations!");
            jobRecruiterService.addJobRecruiter(jobRecruiter);

        }
        return modelAndView;


    }
}
