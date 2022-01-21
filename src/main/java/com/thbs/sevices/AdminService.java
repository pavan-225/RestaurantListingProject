package com.thbs.sevices;

import com.thbs.model.Admin;
import com.thbs.model.Restaurants;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Pavan
 */

public interface AdminService
{
    public String Adminlogin(@ModelAttribute("admin") Admin a1);
    public String adminop(HttpServletRequest request, Restaurants rest, MultipartFile file) throws IOException;
}