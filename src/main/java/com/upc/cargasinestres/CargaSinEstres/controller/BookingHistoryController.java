package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.model.BookingHistory;
import com.upc.cargasinestres.CargaSinEstres.service.IBookingHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/") // esto viene en el enunciado
public class BookingHistoryController {

    private final IBookingHistoryService bookingHistoryService;

    public BookingHistoryController(IBookingHistoryService bookingHistoryService) {
        this.bookingHistoryService = bookingHistoryService;
    }

    //URL: http://localhost:8080/api/v1/bookingHistory


    //Method : Post
    @PostMapping("/bookingHistory")
    public ResponseEntity<BookingHistory> createBookingHistory(@RequestBody BookingHistory bookingHistory){
        validateBookingHistory(bookingHistory); //validation
        return new ResponseEntity<BookingHistory>(bookingHistoryService.createBookingHistory(bookingHistory), HttpStatus.CREATED);
    }

    //Methods : Get
    @GetMapping("/bookingHistory/client/{id}")
    public ResponseEntity<List<BookingHistory>> getBookingHistoryByClientId(@PathVariable(name="id") Long id){
        return new ResponseEntity<List<BookingHistory>>(bookingHistoryService.getBookingHistoryByClientId(id), HttpStatus.OK);
    }

    @GetMapping("/bookingHistory/company/{id}")
    public ResponseEntity<List<BookingHistory>> getBookingHistoryByCompanyId(@PathVariable(name="id") Long id){
        return new ResponseEntity<List<BookingHistory>>(bookingHistoryService.getBookingHistoryByCompanyId(id), HttpStatus.OK);
    }

    //Method : Put


    //Validation
    private void validateBookingHistory(BookingHistory bookingHistory){

        if(bookingHistory.getPickupAddress() == null || bookingHistory.getPickupAddress().isEmpty()){
            throw new ValidationException("La dirección de recogida debe ser obligatoria"); //error 400
        }

        if(bookingHistory.getDestinationAddress() == null || bookingHistory.getDestinationAddress().isEmpty()){
            throw new ValidationException("La dirección de destino debe ser obligatoria"); //error 400
        }

        if(bookingHistory.getMovingDate() == null){
            throw new ValidationException("La fecha de recogida debe ser obligatoria"); //error 400
        }

        if(bookingHistory.getMovingTime() == null){
            throw new ValidationException("El tiempo de recogida debe ser obligatorio"); //error 400
        }

        if(bookingHistory.getStatus() == null || bookingHistory.getStatus().isEmpty()){
            throw new ValidationException("El estado debe ser obligatorio"); //error 400
        }

        if(bookingHistory.getServices() == null || bookingHistory.getServices().isEmpty()){
            throw new ValidationException("La reserva debe presentar almenos 1 servicio, es obligatorio"); //error 400
        }


    }



}

