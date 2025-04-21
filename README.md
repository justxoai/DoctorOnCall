# DoctorOnCall

## 📱 Project Overview  
**DoctorOnCall** is a mobile application developed for hospitals to facilitate online doctor booking and consultations.

## 🩺 Description  
DoctorOnCall enables patients to schedule and attend appointments with doctors without needing to physically visit the hospital.  
The app is especially designed to support:
- Elderly patients  
- Patients with disabilities  
- Individuals living far from the hospital  

## 🎯 Features & Expected Outcomes
- **Role-Based Access Control**  
  - Separate roles for **Doctors** and **Patients**
- **Doctor Appointment Management**  
  - Doctors can schedule appointments (Face-to-Face or Online)
- **Real-Time Notifications**  
  - Updates and reminders for both doctors and patients

## 🛠️ Technologies Used
- Native Mobile App Development  
- Spring Boot (Backend)  
- PostgreSQL (Database)  
- Custom Booking System  
- Firebase (Authentication)  
- SIP Integration for online calls

## ✅ Completed Features
- Role-based authentication using Firebase  
- Login and schedule UI implemented  
- SIP connection setup for voice communication

## 🔧 Tasks in Progress
- For Logic:
  - **Task 1:** Implement password rules (complexity requirements) during sign-up and password changes  
  - **Task 2:** Refactor password change logic for better reliability and security 
  - **Task 3:** Search in Doctor List based on their Specilization

- For UI: 
  - **Task 1:** Patient Medical Survey: Survey to check medical history (Use SharePreference): Based on Giấy khám sức khỏe
  - **Task 2:** Setup UI for HealthCheck: check note
  - **Task 3:** Setup cmt, re-name file, textSize in Header(18-> 22)
  - **Task  :** Edit Profile Function (later)
  - **Task  :** Update UI in Schedule (later)
  - **Task  :** Update UI in Dashboard: with Doctor: HealthCheck and Schedule, with Patient: HealthCheck, ListDoctor, Newsfeed, Schedule

- For Backend:
  - **Task 1:** Setup Backend
  - **Task 2:** Setup Real-time Notification
  - **Task 3:** Setup Booking System
  - **Task 4:** Setup Audio Call