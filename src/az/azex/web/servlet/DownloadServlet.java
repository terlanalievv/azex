package az.azex.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long declarationId = Long.parseLong(request.getParameter("id"));
        System.out.println("declaration id = " + declarationId);


        String fileLocation = "";
        String contentType = "";

        if(declarationId == 1) {
            fileLocation = "/home/stundent/IdeaProjects/upload/IntelliJIDEA_ReferenceCard.pdf";
            contentType = "application/pdf";
        } else if(declarationId == 2) {
            fileLocation = "/home/stundent/IdeaProjects/upload/Screenshot from 2019-03-15 11-40-36.png";
            contentType = "image/png";
        } else if(declarationId == 3) {
            fileLocation = "/home/stundent/IdeaProjects/upload/Kendo UI Grid Export.xlsx";
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
            response.addHeader("Content-Disposition", "attachment; filename=\"" + "Kendo UI Grid Export.xlsx" + "\"");
        }

        response.setContentType(contentType);
        OutputStream out = response.getOutputStream();

        FileInputStream in = new FileInputStream(fileLocation);
        byte[] data = new byte[1024];
        while(in.read(data) != -1) {
            out.write(data);
        }

        in.close();
        out.close();
    }
}
