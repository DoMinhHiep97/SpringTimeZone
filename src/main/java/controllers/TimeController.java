package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class TimeController {
    @RequestMapping("/worldclock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        // Get current time at local
        Date date = new Date();
// Get timezone by the local
        TimeZone local = TimeZone.getDefault();
// Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
// Reset the date by locale_time
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "index";
    }
}
