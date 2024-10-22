# Project Name: NIT3213 Mobile Application

## Overview
This project is an Android mobile application built as part of the NIT3213 course. The app includes a Login screen, a Dashboard, and a Details page. The application interacts with the backend API (`vu-nit3213-api`) to authenticate users, retrieve data, and display detailed information about specific entities.

The app was developed using Kotlin, and the Android development stack, including Android Studio, Jetpack components (such as ViewModel, LiveData, and Hilt for Dependency Injection), and Retrofit for API interactions.

## Features
- **Login Screen**: Allows users to log in with credentials. Upon successful login, the user is directed to the Dashboard screen.
- **Dashboard Screen**: Displays a list of entities retrieved from the API. Uses `RecyclerView` for easy navigation and presentation.
- **Details Screen**: Shows detailed information about a selected entity.

## Tech Stack
- **Programming Language**: Kotlin
- **Development Tools**: Android Studio, Git for version control
- **Architecture**: MVVM (Model-View-ViewModel)
- **Dependencies**:
  - **Retrofit**: For making API calls
  - **Dagger Hilt**: For dependency injection
  - **Jetpack Components**: ViewModel, LiveData
  - **Espresso**: For UI testing
  - **JUnit & MockK**: For unit testing

## Installation
To set up the project on your local machine:

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/nit3213-mobile-app.git
   ```
2. Open the project in Android Studio.
3. Ensure that you have the appropriate SDK version and dependencies installed.
4. Build the project and run it on an Android emulator or a physical device.

## Usage
1. **Login**: Use your first name and student ID as credentials.
2. **Dashboard**: After logging in, you can view a list of entities.
3. **Details**: Click on any entity to view more information.

## Project Structure
- **`data`**: Contains models and network classes for API interactions.
  - **`model`**: Data classes like `Entity`, `LoginRequest`, `DashboardResponse`.
  - **`network`**: Retrofit service interfaces (`ApiService`).
  - **`repository`**: Repository pattern implementation to handle data interactions (`AppRepository`).
- **`ui`**: UI components of the application.
  - **`login`**: Login screen (`LoginActivity`, `LoginViewModel`).
  - **`dashboard`**: Dashboard screen (`DashboardActivity`, `DashboardViewModel`).
  - **`details`**: Details screen (`DetailsActivity`).

## Testing
- **Unit Tests**: Located in `src/test/java`. Written using JUnit and MockK.
- **Instrumented Tests**: Located in `src/androidTest/java`. Written using Espresso for UI testing.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature-name`).
3. Make your changes and commit (`git commit -m 'Description of feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a Pull Request.

## License
This project is licensed under the MIT License. See the `LICENSE` file for more details.

## Contact
For questions or feedback, contact:
- **Name**: Sakar Karki
- **Email**: [your-email@example.com]

