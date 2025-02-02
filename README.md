# Student Grades Management System

## Description
This project is a Java-based console application that allows a school to manage student records, assign subjects, input grades, and calculate grade averages. The system is built using Java with Maven and follows a structured service-oriented architecture.

## Features
- **Student Management**:
  - Add new students
  - List all students
- **Subject Management**:
  - Assign subjects to students
- **Grade Management**:
  - Add grades to subjects
  - Calculate subject and student averages
- **Data Export**:
  - Export student grade averages to a `.txt` file

## Technologies Used
- Java
- Maven
- JUnit5 & Mockito (for testing)

## Project Structure
- **vistas** (Views)
  - `MenuTemplate`: Base class for menu handling
  - `Menu`: Extends `MenuTemplate` and manages user interaction
- **modelos** (Models)
  - `Alumno`: Represents a student
  - `MateriaEnum`: Enum listing available subjects
  - `Materia`: Represents a subject with a list of grades
- **servicios** (Services)
  - `AlumnoServicio`: Manages students and their assigned subjects
  - `ArchivoServicio`: Handles file operations for data export
  - `PromedioServicioImp`: Implements grade average calculations
- **utilidades** (Utilities)
  - Utility methods for menu handling and other reusable functions

## Setup Instructions
1. Clone the repository
2. Import the project into Eclipse as a Maven project.
3. Run the `Menu` class to start the console application.

## Usage
1. Run the program and interact with the menu.
2. Add students, assign subjects, and input grades.
3. View student records and calculate grade averages.
4. Export data to a text file.

