package com.example.myhotel.utils;

public class Queries{
    public static final String findAllArchivesByNumber = "SELECT * FROM db.Archive WHERE noArchive = :noArchive ";

    public static final String findAllArchivesByID = "SELECT * FROM db.Archive WHERE archives_ID = :archives_ID ";

    public static final String changeArchivesID = "UPDATE db.Archives SET archives_ID = :ID WHERE archiveNo = :noArchive";

    public static final String changeArchivesType = "UPDATE db.Archives SET type = :type WHERE noArchive = :noArchive";

    public static final String findAllChainsByName = "SELECT * FROM db.Chain WHERE name = :chain_name ";

    public static final String findAllChains = "SELECT * FROM db.Chain ";

    //public static final String changeNumberOfHotels = "UPDATE db.Hotel SET noHotels = :numberHotels WHERE chain_name = :name";

    public static final String findAllClientsByID = "SELECT * FROM db.Clients WHERE ID = :client_ID ";

    public static final String findAllClientsByName = "SELECT * FROM db.Clients WHERE name = :name ";

    public static final String findAllClientsBySSN = "SELECT * FROM db.Clients WHERE SSN = :SSN ";

    public static final String changeCheckInDate = "UPDATE db.Clients SET checkin = :checkin WHERE ID = :client_ID";

    public static final String changePaymentStatus = "UPDATE db.Clients SET payment = :payment WHERE ID = :client_ID";

    public static final String findAllEmployeesByID = "SELECT * FROM db.Employee WHERE id = :employee_ID ";

    public static final String findAllEmployeesByName = "SELECT * FROM db.Employee WHERE name = :name ";

    public static final String findAllEmployeesBySSN = "SELECT * FROM db.Employee WHERE SSN = :ssn";

    public static final String changePost = "UPDATE db.Employee SET post = :post WHERE ID = :employee_ID";

    public static final String findAllHotelsByID = "SELECT * FROM db.Hotel WHERE ID = :hotel_id ";

    public static final String findAllHotelsByName = "SELECT * FROM db.Hotel WHERE name = :name ";

    public static final String findAllHotelsByRatings = "SELECT * FROM db.Hotel WHERE rating = :rating";

    public static final String changeManager = "UPDATE db.Hotel SET gestionnaire_id = :gestionnaire_id WHERE ID = :hotel_id";

    public static final String findAllRentByID = "SELECT * FROM db.Rent WHERE rent_ID = :rent_ID";

    public static final String findAllRentByDate = "SELECT * FROM db.Rent WHERE rentdate = :rentdate";

    public static final String findAllRentByStartDate = "SELECT * FROM db.Rent WHERE startdate= :startdate";

    public static final String findAllRentByEndDate = "SELECT * FROM db.Rent WHERE enddate = :enddate";

    public static final String changeDate = "UPDATE db.Rent SET rentdate = :rentdate WHERE rent_ID = :rent_ID";

    public static final String changeStartDate = "UPDATE db.Rent SET startdate = :startdate WHERE rent_ID = :rent_ID ";

    public static final String changeEndDate ="UPDATE db.Rent SET enddate = :enddate WHERE rent_ID = :rent_ID ";

    public static final String findAllReservationsByID = "SELECT * FROM db.Reservations WHERE reservation_ID = :reservation_ID";

    public static final String findAllReservationsByDate = "SELECT * FROM db.Reservations WHERE reservationdate = :reservationdate";

    public static final String findAllReservationsByStartDate = "SELECT * FROM db.Reservations WHERE startdate = :startdate";

    public static final String findAllReservationsByEndDate = "SELECT * FROM db.Reservations WHERE enddate = :enddate";

    public static final String findAllReservationsByCustomerID = "SELECT * FROM db.Reservations WHERE client_ID = :client_ID";

    public static final String findAllReservationsByArchiveNumber = "SELECT * FROM db.Reservations natural join db.Archives WHERE noArchive = :noArchive";

    public static final String changeReservationDate = "UPDATE db.Reservations SET reservationdate = :reservationdate WHERE reservation_ID = :reservation_ID ";

    public static final String changeReservationStartDate = "UPDATE db.Reservations SET startdate = :startdate WHERE SET reservation_ID = :reservation_ID";

    public static final String changeReservationEndDate = "UPDATE db.Reservations enddate = :enddate WHERE  SET reservation_ID = :reservation_ID" ;

    public static final String findAllRoomsByRoomNumber = "SELECT * FROM db.Room WHERE roomNumber = :roomNumber";

    public static final String findAllRoomsByRoomType = "SELECT * FROM db.Room WHERE roomType = :roomType";

    public static final String findAllRoomsByView = "SELECT * FROM db.Room WHERE view = :view";

    public static final String findAllRoomsByExtent = "SELECT * FROM db.Room WHERE extent = :extent";

    public static final String findAllRoomsByHotelChain = "SELECT * FROM db.Room WHERE chain = :chain";

    public static final String findAllRoomsByHotelCategory = "SELECT * FROM db.Room WHERE category = :category";

    public static final String findByPriceBetween = "SELECT * FROM db.Room WHERE price BETWEEN :startPrice AND :endPrice";

    public static final String findByCapacityBetween = "SELECT * FROM db.Room WHERE capacity BETWEEN :mincapacity AND :maxcapacity";

    public static final String findAllRoomsByAvailability= "SELECT * FROM db.Room WHERE availability = :availability";

    public static final String changeRoomStatus = "UPDATE db.Room SET payment= :payment WHERE roomNumber = :roomNumber  ";

    public static final String changeRoomAvailability = "UPDATE db.Room SET availability = :availability WHERE roomNumber = :roomNumber ";



}