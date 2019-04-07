package asl.dbpinger.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import asl.dbpinger.Config;

@Controller
public class PingerViewController {
	
	@Autowired
	Config config;

	@GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pingQuery", config.getPingQuery());
        model.addAttribute("scheduledRate", config.getScheduledRate());
        return "index";
    }
}
