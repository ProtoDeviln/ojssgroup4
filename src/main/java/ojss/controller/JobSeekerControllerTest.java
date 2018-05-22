package ojss.controller;

import ojss.domain.JobSeeker;
import ojss.repository.JobSeekerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@org.springframework.stereotype.Controller
@RequestMapping(path="/demo")
public class JobSeekerControllerTest {
    @Autowired
    private JobSeekerRepository jobSeekerRepository;

    @GetMapping(path="/add")
    public @ResponseBody
    String addNewJobSeeker (@RequestParam String nickname, @RequestParam String pwd, @RequestParam String email) {

        JobSeeker js = new JobSeeker();
        js.setUserName(nickname);
        js.setPassword(pwd);
        js.setEmail(email);
        jobSeekerRepository.save(js);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<JobSeeker> getAllJobSeekers() {
        // This returns a JSON or XML with the users
        return jobSeekerRepository.findAll();
    }
}

