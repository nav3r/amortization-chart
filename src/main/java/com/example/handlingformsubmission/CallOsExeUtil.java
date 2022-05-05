package com.example.handlingformsubmission;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CallOsExeUtil {
    public static String call(String[] args) throws IOException, InterruptedException {

        ProcessBuilder processBuilder = new ProcessBuilder(args);
        Process process = processBuilder.start();
        int waitFlag = process.waitFor();// Wait to finish application execution.
        StringBuilder sb = new StringBuilder("");
        if (waitFlag == 0) {
            if (process.exitValue() == 0) {

                BufferedInputStream in = (BufferedInputStream) process.getInputStream();
                byte[] contents = new byte[1024];

                int bytesRead = 0;

                while ((bytesRead = in.read(contents)) != -1) {
                    sb.append(new String(contents, 0, bytesRead));
                }
            }

        }
        return sb.toString();
    }

    public static String toHtml(String abc) {
        return abc.replace("[", "<table>\n")
                .replace("]", "</table>\n")
                .replace("{", "\t<tr>\n")
                .replace("}", "\t</tr>\n")
                .replace("\"", "\t\t<th>\n")
                .replace("\",", "\t\t</th>\n");
    }
    public static String toHtml(JSONArray jsonArray) throws JSONException {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html xmlns:th=\"https://www.thymeleaf.org\">\n");
        sb.append("<head>\n");
        sb.append("    <title>Getting Started: Handling Form Submission</title>\n");
        sb.append("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n");
        sb.append("<style>\n");
        sb.append("  table {\n");
        sb.append("    font-family: arial, sans-serif;\n");
        sb.append("    border-collapse: collapse;\n");
        sb.append("    width: 100%;\n");
        sb.append("  }\n");
        sb.append("  td, th {\n");
        sb.append("      border: 1px solid #dddddd;\n");
        sb.append("      text-align: left;\n");
        sb.append("      padding: 8px;\n");
        sb.append("  }\n");
        sb.append("  tr:nth-child(even) {\n");
        sb.append("    background-color: #dddddd;\n");
        sb.append("  }\n");
        sb.append("</style>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("<table>\n");
        List<String> columns = new ArrayList<>();
        sb.append("  <tr>\n");
        Iterator hmIterator = ((JSONObject) jsonArray.get(0)).keys();
        while (hmIterator.hasNext()) {
            columns.add((String) hmIterator.next());
            sb.append("    <th>" + columns.get(columns.size()-1) + "</th>\n");
        }
        sb.append("  </tr>\n");
        for (int i = 0; i < jsonArray.length(); i++) {
            sb.append("  <tr>\n");
            JSONObject json = (JSONObject) jsonArray.get(i);
            for (String column : columns){
                sb.append("    <th>" + json.get(column) + "</th>\n");
            }
            sb.append("  </tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<a href=\"/mortgage\">Submit another message</a>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");
        return sb.toString();
    }
}