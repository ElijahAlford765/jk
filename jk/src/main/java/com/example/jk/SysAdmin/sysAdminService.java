package com.example.jk.SysAdmin;


import com.example.jk.review.Review;
import com.example.jk.review.ReviewRepository;
import com.example.jk.petService.PetServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class sysAdminService {
    /*
    @Autowired
    private UserRepository userRepository;
*/
    @Autowired
    private PetServiceRepository petServiceRepository;

    @Autowired
    private ReviewRepository reviewRepository;
 /*
    public long countUsers() {
        return userRepository.count();
    }

  public List<User> getAllUsers() {
        return userRepository.findAll();
    }

   */

    public List<Review> getFlaggedReviews() {
        return reviewRepository.findByReportedTrue();
    }
}
