package com.example.jk.SysAdmin;


import com.example.jk.petService.PetService;
import com.example.jk.petService.PetServiceRepository;
import com.example.jk.provider.Provider;
import com.example.jk.provider.ProviderRepository;
import com.example.jk.review.Review;
import com.example.jk.review.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class sysAdminController {
    @Autowired
    private PetServiceRepository serviceRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private PetServiceRepository petServiceRepository;
/*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;
*/

    @GetMapping("/admin/services")
public String listServices(Model model) {
    List<PetService> services = serviceRepository.findAll();
    model.addAttribute("services", services);
    return "admin-services";
}

    @GetMapping("/admin/services/approve/{id}")
    public String approveService(@PathVariable int id) {
        Optional<PetService> service = serviceRepository.findById(id);
        service.ifPresent(s -> {
            s.setApproved(true);
            serviceRepository.save(s);
        });
        return "redirect:/admin/services";
    }

    @GetMapping("/admin/services/delete/{id}")
    public String deleteService(@PathVariable int id) {
        serviceRepository.deleteById(id);
        return "redirect:/admin/services";
    }
























    // Admin Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // model.addAttribute("totalUsers", userRepository.count());
        //model.addAttribute("totalServices", serviceRepository.count());
        model.addAttribute("totalReviews", reviewRepository.count());
        return "admin-dashboard";
    }

    @GetMapping("/reviews")
    public String viewReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findByReportedTrue());
        return "admin-moderation";
    }

    @PostMapping("/reviews/delete/{id}")
    public String deleteReview(@PathVariable int id) {
        reviewRepository.deleteById(id);
        return "redirect:/admin/reviews";
    }

    @PostMapping("/providers/suspend/{id}")
    public String suspendProvider(@PathVariable int id) {
        Provider provider = providerRepository.findById(id).orElseThrow();
        provider.setActive(false);
        providerRepository.save(provider);
        return "redirect:/admin/services";
    }
}