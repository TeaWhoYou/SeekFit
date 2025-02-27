<div style="text-align: right;">
    <img src="https://github.com/TeaWhoYou/SeekFit/blob/main/docs/images/icon_seekfit.png?raw=true" width="250" style="margin-left: 20px; margin-bottom: 20px; float: right;>
</div>

<div style="clear: both;"></div>

# SeekFit
This project is the result of team work as part of the project assignment of the course [Software Engineering](https://www.fer.unizg.hr/predmet/proinz) at the Faculty of Electrical Engineering and Computing, University of Zagreb.
# Description of the Project
SeekFit is an innovative clothing management app designed to help users organize their wardrobe, plan outfits, and streamline the decision-making process based on weather and occasion. The app allows users to upload photos of clothing items and outfits, which are organized into a visual inventory for easy browsing. Users can categorize these items by tagging them with predefined or custom labels, such as style, weather suitability, or material, to sort and quickly access them.

SeekFit also features an AI-powered label detection system that automatically detects care labels and populates relevant information, which users can edit as needed. Outfits can be managed by assigning items to them, with the option to view, edit, or delete individual pieces. The app provides robust search and filtering options, allowing users to search for items by tags, exclude unavailable clothing, and find outfits based on item combinations.

One of SeekFit’s standout features is its integration with real-time weather data with the use of [AccuWeather Forecast API](https://developer.accuweather.com/accuweather-forecast-api/apis) [13], which helps users plan outfits tailored to the weather for the upcoming week. The app also offers secure login via [OAuth](https://developers.google.com/identity/protocols/oauth2) [7], allowing users to manage their profiles and store personal measurements. Users can access size conversion charts and create wishlists for future clothing purchases.

SeekFit enhances the social aspect of clothing management by enabling users to connect with friends, send borrowing requests for clothing items, and view their friends’ wardrobes. Additionally, users can create and manage up to five group chats for discussions or sharing wardrobe ideas. The app sends push notifications for new friend requests or group chat activities, keeping users engaged and connected.

In summary, SeekFit is a comprehensive solution for managing wardrobes, planning outfits, staying connected with friends, and taking advantage of real-time weather-based suggestions, making it an essential tool for fashion enthusiasts.

# Accessing the Application

### Overview
The application is currently available for manual download as an APK file. Users can download the file and install it on their Android devices following the provided instructions below. Please note that the app is not hosted on the Google Play Store, so installation requires enabling installations from unknown sources.

### Current Version
- **Version:** 1.0.0
- **Release Date:** 25.01.2025

- [**APK File Download**](https://drive.google.com/drive/folders/1Cm97XrsjIjmAP6FocAjH0pViXGJXNnIm?usp=sharing)
  - SHA256: 206cf68fa241b1ee7f3a8429ed4b76533d926e0eba36c9c8f9e7a171b484942a  seekfit-1.0.apk  
  - SHA256: a446fd37a11aee0fc3d9860a7f9e162505b828e36ce27f3a8c3dea80cc1ddbf2   seekfit-1.0.zip  
  - SHA1: 500261b610fd88d2bc38845f636f5c7e9e3470aa  seekfit-0.5.apk
  - SHA1: 07c1b267f9176cf3e62a090fc8068facebc668df  seekfit-0.5.zip


### Installation Instructions
0. **Uninstall any previous version if present**
   
2. **Download the APK File:**
   - Use the link provided above to download the APK file.
   - Transfer the APK file to your Android device.

3. **Enable Unknown Sources:**
   - Open your Android device’s **Settings**.
   - Navigate to **Security** or **Privacy** (the menu may vary by device).
   - Enable the option for **Unknown Sources** to allow installations from outside the Google Play Store.

4. **Install the APK:**
   - Locate the downloaded APK file in your device’s **Downloads** folder or the location where it was saved.
   - Tap on the APK file and follow the on-screen prompts to complete the installation.

5. **Run the Application:**
   - After installation, you can find the application in your device’s app drawer. Tap on the app icon to launch it.

### Important Notes
- **Permission Settings:** During installation, you may be prompted to grant specific permissions. These permissions are required for the application’s functionality.
- **Updates:** Ensure you always use the latest version of the application. Refer to the repository or download link for updates.

### Feedback and Support
- For feedback, bug reports, or additional assistance, please contact us via [Issues](https://github.com/TeaWhoYou/SeekFit/issues).
- Please report any broken links or errors to the development team.

### Disclaimer
By installing this APK, you acknowledge that the app is not hosted on an official app store and accept any associated risks. We recommend downloading the APK only from the provided official link to ensure safety.

# Functional Requirements
Here are the core functionalities of this project:

- Users can take pictures directly within the application using the device's camera.
- Users can upload photos from their device’s gallery.
- Users can upload photos of individual clothing pieces.
- Users can upload photos of complete outfits.
- A gallery view displays all the user's uploaded clothing pieces.
- A gallery view displays all the user's uploaded outfits.
- Users can view detailed information about a clothing piece by selecting it in the gallery view.
- Users can view detailed information about an outfit by selecting it in the gallery view.
- Users can add predefined tags (e.g., weather, style) to outfits.
- Users can manage login through an external authentication service.
- Real-time weather data for the user's current location is retrieved from a weather API and displayed in the calendar.
- When scheduling outfits, users are provided with a list of outfits suitable for the forecasted weather based on the outfits' predefined weather tags.
- Logged-in users can add other users to their friends list.
- Push notifications are sent to logged-in users when they receive friend requests.

All functional requirements (essential and additional) can be read [here](https://github.com/TeaWhoYou/SeekFit/wiki/Functional-Requirements).

# Technologies
|**Category**|**Used Technology**|
|-----------------------|----------------------|
|**Mobile Development Framework**|[React Native](https://reactnative.dev/docs/getting-started) [4], [Expo](https://docs.expo.dev/guides/overview/) [5]|
|**Mobile Development IDE**|[Android Studio](https://developer.android.com/develop) [3]|
|**Database**|[PostgreSQL](https://www.postgresql.org/) [15] |
|**Image Storage**|local file system|
|**User Authentication**|[OAuth](https://developers.google.com/identity/protocols/oauth2) [7]|
|**Push Notifications**|[Firebase Cloud Messaging](https://firebase.google.com/docs/cloud-messaging) [12]|
|**Weather API**|[OpenWeatherMap API](https://developer.accuweather.com/accuweather-forecast-api/apis) [13]|
|**Camera & Media Access**|[React Native Camera](https://react-native-camera.github.io/react-native-camera/docs/rncamera) [16] |
|**Scheduling & Calendar Interface**|[React Native Calendar](https://www.npmjs.com/package/react-native-calendars) [17]|
|**Deployment**|[Kubernetes](https://kubernetes.io/docs/home/) [8] and [DigitalOcean](https://www.digitalocean.com/) [18]|

# Installation
Detailed instructions on installation, configuration, and administration of the project are available on the Wiki [here](https://github.com/TeaWhoYou/SeekFit/wiki/9.-Installation,-Configuration,-and-Administration).

# Team members
- Tia Rapo
- Anna Zalesińska
- Mateusz Juszczak
- Cristian Rotar
- Bartul Kajmak
- Kyrylo Rotan
