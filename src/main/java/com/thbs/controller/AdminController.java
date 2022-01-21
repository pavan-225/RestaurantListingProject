package com.thbs.controller;

import com.thbs.constants.PropertyConstants;
import com.thbs.model.Admin;
import com.thbs.model.Restaurants;
import com.thbs.repository.RestaurantRepo;
import com.thbs.sevices.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ${Pavan Priyanka Varun}
 *
 * ${Admin operations}
 */
@Controller
public class AdminController
{
    @Autowired
    AdminService adminService;

    /**
     * Check for Admin credentials
     * @param a1
     * @return - Admin operations Page
     */
    @RequestMapping(PropertyConstants.ADMINCHECK)
    public String Adminlogin(@ModelAttribute("admin") Admin a1)
    {
        return adminService.Adminlogin(a1);
    }

    /**
     * Admin Crud Operations
     * @param request
     * @param rest
     * @return
     */
    @PostMapping(value = PropertyConstants.ADMINOP)
    public String adminop(HttpServletRequest request,Restaurants rest, @RequestParam("img")MultipartFile file) throws IOException {
        return adminService.adminop(request,rest, file);
    }

    @Autowired
    RestaurantRepo restaurantRepo;

    @RequestMapping(value = PropertyConstants.ADMINOP2,method = RequestMethod.GET)
    public String adminop2(HttpServletRequest request, Restaurants rest){
        int id=rest.getResid();
        restaurantRepo.deleteById(id);
        return "Adminop.html";

    }

    @RequestMapping("/check1")
    public String Adminlogin1()
    {
        return "Adminop.html";
    }

    @RequestMapping("/payment123")
    public String Payment()
    {
        return "Payment.html";
    }
}

