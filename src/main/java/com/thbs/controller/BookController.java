package com.thbs.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.thbs.constants.PropertyConstants;
import com.thbs.model.BookingDetails;
import com.thbs.model.RestaurantResponse;
import com.thbs.model.Restaurants;
import com.thbs.repository.BookingRepo;
import com.thbs.repository.RestaurantRepo;
import com.thbs.sevices.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author ${Pavan Priyanka Varun}
 *
 * ${Booking}
 */

@RestController
public class BookController
{
    @Autowired
    BookingService bookingService;

    @Autowired
    RestaurantRepo restaurantRepo;





    @GetMapping("imageList")
    public List<Restaurants> imagetoByte(){
        List arrList = new ArrayList();
      List<Restaurants> list = restaurantRepo.findAll();
        list.forEach(rest -> {
          //  Blob blob = (Blob) x;
                   byte [] bytes = new byte[0];
                    byte[] blob = rest.getImage();
                   /* bytes = blob.getBytes(1l, (int)blob.length());*/
                   /* try {

                       // bytes = blob.getBytes(1l, (int)blob.length());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }*/

                    String encodedString =  Base64.getMimeEncoder().encodeToString(blob);
                    RestaurantResponse response = new RestaurantResponse();
                    response.setImageString(encodedString);
                    response.setResname(rest.getResname());
                    response.setResplace(rest.getResplace());
                    response.setResprice(rest.getResprice());
                    arrList.add(response);
        }
        );
        return  arrList;
    }
}

