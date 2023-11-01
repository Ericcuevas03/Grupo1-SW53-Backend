package com.upc.cargasinestres.CargaSinEstres.service;


import com.upc.cargasinestres.CargaSinEstres.model.Review;

import java.util.List;

public interface IReviewService {
    public abstract Review createReview(Review review);

    public abstract List<Review> getReviewsByCompanyId(Long companyId);
}
