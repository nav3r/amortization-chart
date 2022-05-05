package com.example.handlingformsubmission;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }

    @GetMapping("/mortgage")
    public String mortgageForm(Model model) {
        model.addAttribute("mortgage", new Mortgage());
        return "mortgage";
    }

//    @PostMapping("/mortgage")
//    public String mortgageSubmit(@ModelAttribute Mortgage mortgage, Model model) {
//        model.addAttribute("mortgage", mortgage);
//        return "amortization";
//    }

    @PostMapping(value = "/mortgage", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String mortgageSubmit(@ModelAttribute Mortgage mortgage, Model model) throws JSONException, IOException, InterruptedException {
        String content = (CallOsExeUtil.call(new String[]{"C:/Users/Naveen/source/repos/AmortizationTableSource/x64/Debug/AmortizationTableSource.exe",
                String.valueOf(mortgage.getYear()), String.valueOf(mortgage.getPrinciple()), String.valueOf(mortgage.getApr())}));

        JSONArray jsonArray = new JSONArray(content);

        return CallOsExeUtil.toHtml(jsonArray);

    }
}