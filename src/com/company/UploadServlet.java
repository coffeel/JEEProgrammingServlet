package com.company;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yonglinx on 8/29/16.
 */
@WebServlet(name = "UploadServlet")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, //The size threshold after which the file will be written to disk
        maxFileSize = 1024 * 1024 * 10, //The maximum size allowed for uploaded files
        maxRequestSize = 1024 * 1024 * 50//The maximum size allowed for multipart/form-data requests
)
public class UploadServlet extends HttpServlet {
    private static final String SAVE_DIR = "UploadFiles";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists())
            fileSaveDir.mkdir();

        for (javax.servlet.http.Part part : request.getParts()) {
            String fileName = extractFileName(part);›
            if (fileName != null && !fileName.isEmpty())
                part.write(savePath + File.separator + fileName);
        }

        PrintWriter out = response.getWriter();
        out.println("File Uploaded Successfully!");
    }

    private String extractFileName(javax.servlet.http.Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
