package com.example.jk.SysAdmin;


import com.example.jk.petService.PetService;
import com.example.jk.petService.PetServiceRepository;
import com.example.jk.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class sysAdminController {
    @Autowired
    private PetServiceRepository serviceRepository;

    @Autowired
    private ReviewRepository reviewRepository;
/*
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Admin Dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalUsers", userRepository.count());
        model.addAttribute("totalServices", serviceRepository.count());
        model.addAttribute("totalReviews", reviewRepository.count());
        return "admin-dashboard";
    }
*/
    // Service Moderation Page
    @GetMapping("/services")
    public String viewServices(Model model) {
        model.addAttribute("services", serviceRepository.findAll());
        //model.addAttribute("providers", providerRepository.findAll());
        model.addAttribute("flaggedServices", serviceRepository.findByReportCountGreaterThan(0));
        return "admin-moderation";
    }

    @PostMapping("/services/approve/{id}")
    public String approveService(@PathVariable int id) {
        PetService service = serviceRepository.findById(id).orElseThrow();
        service.setApproved(true);
        serviceRepository.save(service);
        return "redirect:/admin/services";
    }

    // Delete Service
    @PostMapping("/services/delete/{id}")
    public String deleteService(@PathVariable int id) {
        serviceRepository.deleteById(id);
        return "redirect:/admin/services";
    }

    // Reviews Page
    @GetMapping("/reviews")
    public String viewReviews(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "admin-reviews";
    }

    @PostMapping("/reviews/delete/{id}")
    public String deleteReview(@PathVariable int id) {
        reviewRepository.deleteById(id);
        return "redirect:/admin/reviews";
    }
/*
    // Users Page
    @GetMapping("/users")
    public String viewUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "admin-users";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/providers/suspend/{id}")
    public String suspendProvider(@PathVariable int id) {
        Provider provider = providerRepository.findById(id).orElseThrow();
        provider.setApprovalStatus("Suspended");
        providerRepository.save(provider);
        return "redirect:/admin/services";
    }
    */
}


