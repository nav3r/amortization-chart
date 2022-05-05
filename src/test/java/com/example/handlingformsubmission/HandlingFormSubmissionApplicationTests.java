package com.example.handlingformsubmission;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;

@SpringBootTest
class HandlingFormSubmissionApplicationTests {

    @Test
    void contextLoads() throws IOException, InterruptedException {
        System.out.println(CallOsExeUtil.call(new String[]{"my.bat", "pom.xml"}));
    }

    @Test
    void testToHtmlTable() throws JSONException {
        System.out.println(CallOsExeUtil.toHtml(new JSONArray("[{'balance':100000,'interest':1000,'principal':0}, {'balance':100000,'interest':1000,'principal':99000}]")));
    }

    @Test
    void testToHtml() throws JSONException {
        System.out.println(CallOsExeUtil.toHtml("[{'balance':100000,'interest':1000,'principal':0}, {'balance':100000,'interest':1000,'principal':99000}]"));
    }

    @Test
    void mortgageSubmit() throws JSONException, IOException, InterruptedException {
        String content = (CallOsExeUtil.call(new String[]{"C:/Users/Naveen/source/repos/AmortizationTable/x64/Debug/AmortizationTable.exe",
                "3",
                "100000", ".08"}));
        System.out.println(content);
    }
}
