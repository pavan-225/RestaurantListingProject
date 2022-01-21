package com.thbs.sevices;

import com.thbs.constants.PropertyConstants;
import com.thbs.model.Admin;
import com.thbs.model.Restaurants;
import com.thbs.repository.AdminRepo;
import com.thbs.repository.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * AdminServiceImpl implements the business logic for CRUD Operations
 * @author Priyanka_Ramesh Pavan Varun
 */

@Service
public class AdminServiceImpl implements AdminService
{
    @Autowired
    AdminRepo adminRepo;

    @Autowired
    RestaurantRepo restaurantRepo;

    int id;

    @Override
    public String Adminlogin(@ModelAttribute("admin") Admin a1)
    {
        System.out.println(a1);
        Optional<Admin> searchAdmin = adminRepo.findById(a1.getUsername());
        if(searchAdmin.isPresent())
        {

            id=searchAdmin.get().getAdmin_id();
            a1.setAdmin_id(id);
            Admin c1= searchAdmin.get();
            if(a1.getPassword().equals(c1.getPassword()))
            {

                return "Adminop.html";
            }
            return "admin_login.html";
        }
        else
            return "admin_login.html";
    }


    @Override
    public String adminop( HttpServletRequest request,Restaurants rest, @RequestParam("img")MultipartFile file) throws IOException {
        rest.setImage(file.getBytes());
        switch (request.getParameter("value"))
        {
            case PropertyConstants.ADD:
                restaurantRepo.save(rest);
                return "redirect:check1";

            case PropertyConstants.MODIFY:

                restaurantRepo.save(rest);
                return "redirect:check1";
            /*case PropertyConstants.DELETE:
                restaurantRepo.deleteById(rest.getResid());
                break;*/
        }
        return "admin_login.html";
    }
}
