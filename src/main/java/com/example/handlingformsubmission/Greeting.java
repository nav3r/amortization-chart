package com.example.handlingformsubmission;

import java.io.IOException;

public class Greeting {

    private long id;
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) throws IOException, InterruptedException {
        this.content = CallOsExeUtil.call(new String[]{"c:/tmp/AmortizationTableSource.exe", "1", "1000", "1.4"});
    }

}