package com.upc.cargasinestres.CargaSinEstres.service;

import com.upc.cargasinestres.CargaSinEstres.model.BookingHistory;

import java.util.List;

public interface IBookingHistoryService {

    //create bookingHistory
    public abstract BookingHistory createBookingHistory(BookingHistory bookingHistory);

    //get all bookingHistory for a client by Id
    public abstract List<BookingHistory> getBookingHistoryByClientId(Long id);

    //get all bookingHistory for a company by Id
    public abstract List<BookingHistory> getBookingHistoryByCompanyId(Long id);

    //update bookingHistory chat


}
