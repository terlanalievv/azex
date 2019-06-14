package az.azex.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet(name = "UploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream in = null;
        FileOutputStream out = null;
        response.setContentType("text/plain");

        try {
            Part declaration = request.getPart("declaration");
            System.out.println("file = " + declaration.getSubmittedFileName());
            System.out.println("content type = " + declaration.getContentType());
            in = declaration.getInputStream();
            String uploadDir = getServletContext().getInitParameter("uploadDirectory");

            out = new FileOutputStream(uploadDir + File.separator + declaration.getSubmittedFileName());
            byte[] data = new byte[1024]; // 1KB buffer
            while (in.read(data) != -1) {
                out.write(data);
            }

            response.getWriter().print("Upload ugurlu oldu");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("Upload bas tutmadi, xeta = " + e.getMessage());
        } finally {
            if(in != null) {
                in.close();
            }

            if(out != null) {
                out.close();
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
