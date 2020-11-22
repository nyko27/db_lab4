package ua.lviv.iot.view;

import ua.lviv.iot.controller.*;
import ua.lviv.iot.model.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final AirlineController airlineController = new AirlineController();
    private final AirportController airportController = new AirportController();
    private final FlightController flightController = new FlightController();
    private final TicketController ticketController = new TicketController();
    private final UserProfileController userProfileController = new UserProfileController();
    private final UserProfileHasTicketController userProfileHasTicketController = new UserProfileHasTicketController();

    public View() {

        menu.put("11", this::getAllAirlines);
        menu.put("12", this::getAirlineById);
        menu.put("13", this::createAirline);
        menu.put("14", this::updateAirline);
        menu.put("15", this::deleteAirline);

        menu.put("21", this::getAllAirports);
        menu.put("22", this::getAirportById);
        menu.put("23", this::createAirport);
        menu.put("24", this::updateAirport);
        menu.put("25", this::deleteAirport);

        menu.put("31", this::getAllFlights);
        menu.put("32", this::getFlightById);
        menu.put("33", this::createFlight);
        menu.put("34", this::updateFlight);
        menu.put("35", this::deleteFlight);

        menu.put("41", this::getAllTickets);
        menu.put("42", this::getTicketById);
        menu.put("43", this::createTicket);
        menu.put("44", this::updateTicket);
        menu.put("45", this::deleteTicket);

        menu.put("51", this::getAllUserProfiles);
        menu.put("52", this::getUserProfileById);
        menu.put("53", this::createUserProfile);
        menu.put("54", this::updateUserProfile);
        menu.put("55", this::deleteUserProfile);

        menu.put("61", this::getAllUserUserProfileHasTickets);
        menu.put("62", this::getUserProfileHasTicketById);
        menu.put("63", this::createUserProfileHasTicket);
        menu.put("64", this::updateUserProfileHasTicket);
        menu.put("65", this::deleteUserProfileHasTicket);

    }

    private void getAllAirlines() throws SQLException {
        System.out.println("\nAll airlines: ");
        System.out.println(airlineController.findAll() + "\n");
    }

    private void getAllAirports() throws SQLException {
        System.out.println("\nAll airports: ");
        System.out.println(airportController.findAll() + "\n");
    }

    private void getAllFlights() throws SQLException {
        System.out.println("\nAll flights: ");
        System.out.println(flightController.findAll() + "\n");
    }

    private void getAllTickets() throws SQLException {
        System.out.println("\nAll tickets: ");
        System.out.println(ticketController.findAll() + "\n");
    }

    private void getAllUserProfiles() throws SQLException {
        System.out.println("\nAll User Profiles: ");
        System.out.println(userProfileController.findAll() + "\n");
    }

    private void getAllUserUserProfileHasTickets() throws SQLException {
        System.out.println("\nAll info about user's tickets: ");
        System.out.println(userProfileHasTicketController.findAll() + "\n");
    }

    private void getAirlineById() throws SQLException {
        System.out.println("\nEnter id to find airline with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(airlineController.findById(id) + "\n");
    }

    private void getAirportById() throws SQLException {
        System.out.println("\nEnter id to find airport with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(airportController.findById(id) + "\n");
    }

    private void getFlightById() throws SQLException {
        System.out.println("\nEnter id to find flight with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(flightController.findById(id) + "\n");
    }

    private void getTicketById() throws SQLException {
        System.out.println("\nEnter id to find ticket with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(ticketController.findById(id) + "\n");
    }

    private void getUserProfileById() throws SQLException {
        System.out.println("\nEnter id to find user with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(userProfileController.findById(id) + "\n");
    }

    private void getUserProfileHasTicketById() throws SQLException {
        System.out.println("\nEnter id to find user and ticket with this id ...: ");
        Integer id = scanner.nextInt();
        System.out.println(userProfileHasTicketController.findById(id) + "\n");
    }

    private Airline getAirlineValues() throws SQLException {
        System.out.println("Input airline name: ");
        String airlineName = scanner.next();
        return new Airline(airlineName);
    }

    private Airport getAirportValues() throws SQLException {
        System.out.println("Input airline id: ");
        Integer airLineId = scanner.nextInt();
        System.out.println("Input airport name: ");
        String airportName = scanner.next();
        System.out.println("Input city name: ");
        String city = scanner.next();
        System.out.println("Input country name: ");
        String country = scanner.next();
        return new Airport(airLineId, airportName, city, country);
    }

    private Flight getFlightValues() throws SQLException {
        System.out.println("Input airline id: ");
        Integer airLineId = scanner.nextInt();
        System.out.println("Input departure airport id: ");
        Integer departureAirportId = scanner.nextInt();
        System.out.println("Input arrival airport id: ");
        Integer arrivalAirportId = scanner.nextInt();
        System.out.println("Input allowed baggage in kg: ");
        Integer allowedBaggageInKilograms = scanner.nextInt();
        System.out.println("Input airplane name: ");
        String airplaneName = scanner.next();
        return new Flight(airLineId, departureAirportId, arrivalAirportId, allowedBaggageInKilograms, airplaneName);
    }

    private Ticket getTicketValues() throws SQLException {
        System.out.println("Input flight id: ");
        Integer flightId = scanner.nextInt();
        System.out.println("Input price in UAH: ");
        Integer priceInUah = scanner.nextInt();
        return new Ticket(flightId, priceInUah);
    }

    private UserProfile getUserProfileValues() throws SQLException {
        System.out.println("Input user name: ");
        String userName = scanner.next();
        System.out.println("Input surName: ");
        String surName = scanner.next();
        return new UserProfile(userName, surName);
    }

    private UserProfileHasTicket getUserProfileTicketValues() throws SQLException {
        System.out.println("Input ticket id: ");
        Integer ticketId = scanner.nextInt();
        System.out.println("Input user id: ");
        Integer userProfileId = scanner.nextInt();
        return new UserProfileHasTicket(ticketId, userProfileId);
    }

    private void createAirline() throws SQLException {
        System.out.println("\nAdd new Airline...");
        Airline airline = getAirlineValues();
        airlineController.create(airline);
        System.out.println("added an airline\n");
    }

    private void createAirport() throws SQLException {
        System.out.println("\nAdd new airport...");
        Airport airport = getAirportValues();
        airportController.create(airport);
        System.out.println("added an airport\n");
    }

    private void createFlight() throws SQLException {
        System.out.println("\nAdd new Flight...");
        Flight flight = getFlightValues();
        flightController.create(flight);
        System.out.println("added new flight\n");
    }

    private void createTicket() throws SQLException {
        System.out.println("\nAdd new ticket...");
        Ticket ticket = getTicketValues();
        ticketController.create(ticket);
        System.out.println("added new ticket\n");
    }

    private void createUserProfile() throws SQLException {
        System.out.println("\nAdd new user...");
        UserProfile userProfile = getUserProfileValues();
        userProfileController.create(userProfile);
        System.out.println("added an userProfile\n");
    }

    private void createUserProfileHasTicket() throws SQLException {
        System.out.println("\nAdd new user-ticket link...");
        UserProfileHasTicket userProfileHasTicket = getUserProfileTicketValues();
        userProfileHasTicketController.create(userProfileHasTicket);
        System.out.println("added user with ticket\n");
    }

    private void updateAirport() throws SQLException {
        System.out.println("\nEnter id of airport to update: ");
        Integer id = scanner.nextInt();
        Airport airport = getAirportValues();
        airport.setId(id);

        airportController.update(airport.getId(), airport);
        System.out.println("Updated \n");
    }

    private void updateFlight() throws SQLException {
        System.out.println("\nEnter id of flight to update: ");
        Integer id = scanner.nextInt();
        Flight flight = getFlightValues();


        flightController.update(id, flight);
        System.out.println("Updated \n");
    }

    private void updateTicket() throws SQLException {
        System.out.println("\nEnter id of ticket to update: ");
        Integer id = scanner.nextInt();
        Ticket ticket = getTicketValues();
        ticket.setId(id);

        ticketController.update(ticket.getId(), ticket);
        System.out.println("Updated \n");
    }

    private void updateUserProfile() throws SQLException {
        System.out.println("\nEnter id of user to update: ");
        Integer id = scanner.nextInt();
        UserProfile userProfile = getUserProfileValues();
        userProfile.setId(id);

        userProfileController.update(userProfile.getId(), userProfile);
        System.out.println("Updated \n");
    }

    private void updateUserProfileHasTicket() throws SQLException {
        System.out.println("\nEnter id of user with ticket to update: ");
        Integer id = scanner.nextInt();
        UserProfileHasTicket userProfileHasTicket = getUserProfileTicketValues();
        userProfileHasTicket.setId(id);

        userProfileHasTicketController.update(userProfileHasTicket.getId(), userProfileHasTicket);
        System.out.println("Updated \n");
    }

    private void updateAirline() throws SQLException {
        System.out.println("\nEnter id of airline to update: ");
        Integer id = scanner.nextInt();
        Airline airline = getAirlineValues();
        airline.setId(id);

        airlineController.update(airline.getId(), airline);
        System.out.println("Updated \n");
    }

    private void deleteAirline() throws SQLException {
        System.out.println("\nEnter ID of airline to delete it: ");
        int id = scanner.nextInt();

        airlineController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteAirport() throws SQLException {
        System.out.println("\nEnter ID of airport to delete it: ");
        int id = scanner.nextInt();

        airportController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteFlight() throws SQLException {
        System.out.println("\nEnter ID of flight to delete it: ");
        int id = scanner.nextInt();

        flightController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteTicket() throws SQLException {
        System.out.println("\nEnter ID of ticket to delete it: ");
        int id = scanner.nextInt();

        ticketController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteUserProfile() throws SQLException {
        System.out.println("\nEnter ID of user to delete him: ");
        int id = scanner.nextInt();

        userProfileController.delete(id);
        System.out.println("Deleted \n");
    }

    private void deleteUserProfileHasTicket() throws SQLException {
        System.out.println("\nEnter ID of user to delete his link with ticket: ");
        int id = scanner.nextInt();

        userProfileHasTicketController.delete(id);
        System.out.println("Deleted \n");
    }

    public final void view() {
        System.out.println("\nInput method key to deal with db:");
        String input;
        do {
            try {
                input = scanner.next();
                menu.get(input).print();
                System.out.println("\nInput method key to deal with db:");
            } catch (Exception e) {
                System.out.println("No operation for this key");
                System.out.println("\nInput method key to deal with db:");
            }
        } while (scanner.hasNext());
    }

}

