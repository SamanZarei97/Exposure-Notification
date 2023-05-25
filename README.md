# Exposure-Notification
This project implements a simple Exposure Notification System simulation based on the system described at Google Exposure Notifications. The simulation involves tracking students' movements, 
COVID-19 testing, and determining the risk of exposure based on contact information exchanged between students' phones.

## Project Files
The project consists of the following files:

#### ContactInfo.java: 
This file contains the ContactInfo class, which stores information about student contacts. It includes the contact's ID, distance, 
time of contact, and a flag indicating if the contact information has been used for notification.

#### Server.java:
This file contains the Server class, which represents the server storing infected IDs. It provides methods to add new infected IDs and retrieve all stored infected IDs.

#### Simulator.java:
This file contains the Simulator class, which runs the simulation. It simulates students' movements, infections, and notifications using the Student, Server, 
and ContactInfo classes. The simulation takes input from a file, performs daily simulations, and outputs information about students, locations, infections, and notifications.

#### Student.java:
This file contains the Student class, which represents students in the simulation. It handles student movements, COVID-19 test status, and interactions with the server 
and contact information. The class includes methods to update locations, IDs, infection status, and quarantine choices, as well as risk assessment based on recent positive contacts.

#### sample.txt:
This file is an example input file for the simulation. It contains comma-separated values representing quarantine choices, student locations, 
and student infection statuses for each day of the simulation.

## Running the Simulation
To run the simulation, execute the main method in the Simulator class. The simulation reads input from an input file (e.g., sample.txt) and performs the daily simulations based on the provided data. It outputs information about each day, including locations, infections, infected IDs in the server, students' status, and the number of notifications.

## Simulation Process
The simulation follows these main steps for each day:

Update student IDs and locations based on the input data for the day.
Update student infection statuses based on the input data for the day.
Simulate information exchange between students' phones and update contact history.
Assess the risk of COVID-19 exposure for each student based on recent positive contacts and quarantine choices.
Output information about the day, including locations, infections, infected IDs in the server, students' status, and the number of notifications.
The simulation continues until it reaches the end of the input file. At the end of the simulation, it provides the total number of days simulated and the total number of notifications sent.

## Note
This simulation is a simplified model and does not represent a real-world COVID-19 exposure notification system. It is provided as an educational example to 
demonstrate the concepts of tracking movements, testing, and assessing the risk of exposure based on contact information.


