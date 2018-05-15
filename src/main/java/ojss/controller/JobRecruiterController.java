package ojss.controller;

import ojss.domain.JobRecruiter;
import ojss.service.JobRecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class JobRecruiterController {

    private JobRecruiterService jobRecruiterService;

    @Autowired
    public JobRecruiterController(JobRecruiterService jobRecruiterService) {
        this.jobRecruiterService = jobRecruiterService;
    }
    @GetMapping(value = "/recruiterRegistration")
    public ModelAndView displayRecruiterRegistrationPage(ModelAndView modelAndView, JobRecruiter jobRecruiter) {
        modelAndView.addObject("jobRecruiter", jobRecruiter);
        modelAndView.setViewName("recruiterRegistration");
        return modelAndView;
    }
    @RequestMapping(value = "/jobRecruiterLogin", method = RequestMethod.POST)
    public String jobRecruiterLogin(JobRecruiter jobRecruiter, Model model) {
        boolean verify = jobRecruiterService.verifyJobRecruiter(jobRecruiter);
        if (verify) {
            model.addAttribute("name", jobRecruiter.getEmail());
            model.addAttribute("password", jobRecruiter.getPassword());
            return "result";
        } else {
            return "redirect:/notVerify";
        }
    }

    @PostMapping(value = "/recruiterRegistration")
    public ModelAndView processRecruiterRegistration(ModelAndView modelAndView, @Valid JobRecruiter jobRecruiter, BindingResult bindingResult) {
        JobRecruiter tempRecruiter = jobRecruiterService.findByEmail(jobRecruiter.getEmail());
        System.out.println(tempRecruiter);

        if (tempRecruiter != null) {
            modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
            modelAndView.setViewName("recruiterRegistration");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("recruiterRegistration");
        } else {
            jobRecruiterService.addJobRecruiter(jobRecruiter);
        }
            return modelAndView;
    }

}
