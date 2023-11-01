package com.upc.cargasinestres.CargaSinEstres.service.Impl;
import com.upc.cargasinestres.CargaSinEstres.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.model.Review;
import com.upc.cargasinestres.CargaSinEstres.repository.IReviewRepository;
import com.upc.cargasinestres.CargaSinEstres.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Qualifier("reviewServiceImpl")
public class ReviewServiceImpl implements IReviewService {

    private final IReviewRepository reviewRepository;


    public ReviewServiceImpl(IReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviewsByCompanyId(Long companyId){
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review createReview(@RequestBody Review review){
        validateReview(review);
        return reviewRepository.save(review);
    }

    private void validateReview(Review review){
        if(review.getComment() == null || review.getComment().trim().isEmpty()){
            review.setComment("...");
        }
        if(review.getRating() == 0){
            throw new ValidationException("El rating es obligatorio");
        }
    }




}
