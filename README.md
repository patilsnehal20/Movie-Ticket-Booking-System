**Movie Ticket Management**

**Overview** :

The Movie Ticket Booking System is a Java-based application that allows users to book movie tickets online. It provides a user-friendly interface for selecting movies, choosing showtimes, and purchasing tickets along with snacks and beverages. The system also includes features for user feedback and coupon application for discounts.

**Problem Statement** :

In the current entertainment landscape, moviegoers often encounter several challenges that hinder their experience when booking tickets. These challenges include long queues at theaters, limited access to information about available movies, and difficulties in selecting preferred seats. Traditional ticket booking systems are often fragmented and inefficient, leading to frustration for users who seek a seamless and enjoyable experience.

To address these challenges, we propose a comprehensive Movie Ticket Booking System, built using Java and designed to streamline the ticket purchasing process.

With the rise of online ticketing, there’s a growing need for systems that:

- Provide a user-friendly interface for browsing and selecting movies with detailed descriptions and cast information.
- Allow users to easily choose showtimes and theaters while ensuring real-time seat availability.
- Offer an interactive seat selection feature that visually represents available and booked seats.
- Include options for purchasing snacks and beverages alongside ticket bookings.
- Implement a coupon system that allows users to apply discounts seamlessly during the payment process.

**Tech Stack**
- Programming Language: Java
- Data Structures : ArrayList, Arrays
- Exception Handling : Custom exceptions for error management
- User  Input : Scanner for console input

**Tech Stack Implementation** :

**Programming Language**

Java : The core programming language used to develop the application, leveraging its object-oriented features for modular design and maintainability.

**Data Structures**

ArrayList:
Used to store and manage collections of movies, theaters, snacks, and user selections dynamically.

Arrays:
Employed for managing seat availability and selection, providing a straightforward way to represent seat layouts.

**Exception Handling**

Custom Exceptions:
Implemented to handle specific errors, such as invalid user input or insufficient seat availability, ensuring robust error management and user feedback.

**User Input**

Scanner Class:
Utilized for capturing user input from the console, allowing for interactive engagement throughout the booking process.

**Key Features and Implementation** :

- **User Module**

**User Authentication**:
Input validation for name and mobile number.

**Welcome Message**:
Personalized greeting for users upon login.

**Movie Listings**:
Display of available movies with descriptions, genres, and cast information.

- **Movie Selection**

**Browse Movies**:
Users can view a list of movies and select one for more details.

**Movie Details**:
Information about the selected movie, including duration, language, and cast.

- **Date and Theater Selection**

**Choose Date**:
Users can select a date for the movie screening.

**Theater Options**:
Display of available theaters with location details.

- **Seat Selection**

**Interactive Seat Map**:
Visual representation of available and booked seats.

**Real-Time Availability**:
Users can select their preferred seats based on availability.

- **Snacks and Beverages**

**Menu Display**:
Option to view and select snacks and beverages during the booking process.

**Pricing Information**:
Clear display of prices for each snack and beverage item.

- **Payment Processing**

**Total Cost Calculation**:
Automatic calculation of total cost including tickets and snacks.

**Coupon Application**:
Users can apply discount coupons for savings during checkout.

- **Feedback Collection**

**Post-Booking Feedback**:
Users are prompted to provide feedback on their booking experience.

**Output** :
https://drive.google.com/drive/folders/10ybkbXpn7qo8_ZsW3sFKNPWxQDSopn31?usp=sharing

**Code Flow Summary**

User Initialization                             →     Input name and mobile number for authentication.

Movie Selection                                 →     Browse available movies and select one for details.

Date and Theater Selection                      →     Choose a screening date and theater.

Slot Selection                                  →     Select a time slot for the chosen movie.

Seat Selection                                  →     View interactive seat map and select preferred seats.

Snacks and Beverages                            →     Choose snacks and beverages to add to the order.

Payment Processing                              →     Calculate total cost, apply coupons, and process payment.

Ticket Generation                               →     Generate and display digital ticket with booking details.

Feedback Collection                             →     Prompt user for feedback on their booking experience.

End of Process                                  →     Conclude the session and allow for a new booking or exit.

**Future Enhancements**

- Database integration for persistent storage of user data and bookings.
- Graphical User Interface (GUI) for a more interactive experience.
- Online payment gateway integration for secure transactions.
- Recommendation system based on user preferences and viewing history.
- Admin panel for managing movies and viewing booking statistics.


