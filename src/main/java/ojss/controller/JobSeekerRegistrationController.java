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
public class JobSeekerRegistrationController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerRegistrationController(JobSeekerService jobSeekerService) {
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

        System.out.println("This e-mail has been used.");

        if (jsExists != null) {
            modelAndView.addObject("registeredEmail", "Sorry, this e-mail has been used");
            modelAndView.setViewName("jobSeekerRegistration");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()){
            modelAndView.setViewName("jobSeekerRegistration");
        } else {
            jobSeeker.setPassword(map.get("password").toString());
            jobSeekerService.addNewJobSeeker(jobSeeker);
            modelAndView.addObject("registrationSuccess","Congratulations!");
        }
        return modelAndView;


    }


}
