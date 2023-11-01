package com.upc.cargasinestres.CargaSinEstres.service.Impl;

import com.upc.cargasinestres.CargaSinEstres.model.BookingHistory;
import com.upc.cargasinestres.CargaSinEstres.repository.IBookingHistoryRepository;
import com.upc.cargasinestres.CargaSinEstres.service.IBookingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("bookingHistoryServiceImpl")
public class BookingHistoryServiceImpl implements IBookingHistoryService {

    private final IBookingHistoryRepository bookingHistoryRepository;

    @Autowired
    public BookingHistoryServiceImpl(IBookingHistoryRepository bookingHistoryRepository) {
       this.bookingHistoryRepository = bookingHistoryRepository;
    }

    //Method : POST
    @Override
    public BookingHistory createBookingHistory( BookingHistory bookingHistory ) {
        return bookingHistoryRepository.save(bookingHistory);
    }

    @Override
    public List<BookingHistory> getBookingHistoryByClientId(Long clientId) {
        return bookingHistoryRepository.findByClientId(clientId);
    }

    @Override
    public List<BookingHistory> getBookingHistoryByCompanyId(Long companyId) {
        return bookingHistoryRepository.findByCompanyId(companyId);
    }


}
