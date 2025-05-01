*COMPNAY*:CODTECH IT SOLUTION

*NAME*:LADI BIKASH

*INTERN ID*:CT04DA376

*DOMAIN*:ANDROID DEVELOPMENT

*DURATION*:4 WEEKS

*MENTOR*:NEELA SANTOSH

##The Ride Sharing App is a mobile application built using Java in Android Studio that aims to connect passengers with nearby drivers for convenient, on-demand transportation. Inspired by services like Uber and Lyft, this app provides a basic but functional ride-hailing experience, enabling users to book rides, track drivers in real time, and handle ride requests efficiently. This project showcases the integration of Android development skills, location services, mapping, and real-time communication.

The app is structured with two primary user roles: Riders (Passengers) and Drivers. Riders can request rides by selecting their pickup and drop-off locations, while drivers can view nearby ride requests and choose to accept them. The core functionality revolves around geolocation, ride matching, and map-based interaction, making use of Android’s location APIs and Google Maps.

✨ Key Features
User Authentication: Both riders and drivers can register and log in using email/password or social login (e.g., Firebase Authentication).

Map Integration: Real-time location display using the Google Maps API.

Ride Request: Riders can pin a pickup and drop location, estimate fare, and submit a ride request.

Driver Mode: Drivers can view nearby ride requests and accept them with a single tap.

Live Tracking: Both users can see the live position of the vehicle using location updates.

Status Updates: The ride status changes from "Requested" to "Accepted", "In Progress", and "Completed".

🛠️ Technologies Used
Component	Details
Programming Language	Java
IDE	Android Studio
Maps	Google Maps SDK for Android
Location Services	FusedLocationProviderClient
Authentication	Firebase Authentication
Real-time Database	Firebase Realtime Database / Firestore
UI Design	XML (ConstraintLayout, RecyclerView)

📱 App Architecture
The app consists of multiple activities or fragments depending on the user role:

Login/Register Activity – Handles user authentication and role selection (Driver or Rider).

Rider Home Activity – Allows passengers to search for a ride, place a request, and track the driver.

Driver Home Activity – Lets drivers see nearby ride requests and accept or decline them.

Maps Activity – Shared component showing locations, routes, and real-time tracking.

Google’s Fused Location Provider is used to fetch the device’s current GPS location, ensuring power-efficient and accurate positioning. Firebase's real-time database or Firestore is used to sync driver and rider locations, ride statuses, and requests in real time. Push notifications or Firebase Cloud Messaging (FCM) can be implemented to alert drivers of new ride requests.

🌟 Potential Enhancements
Payment Integration: Add online payment via UPI, Google Pay, or Stripe.

Route Optimization: Use Google Directions API for ETA and optimized routing.

Ratings & Reviews: Riders and drivers can rate each other post-ride.

Ride History: View past rides and receipts.

SOS/Emergency Feature: Send location to emergency contacts in case of danger.

🧾 Conclusion
The Ride Sharing App serves as a powerful learning project for mobile developers, combining real-time data handling, geolocation, UI/UX design, and multi-role user management. Developed using Java in Android Studio, it lays the groundwork for scalable and production-ready ride-hailing platforms with features that can be expanded upon as needed.
