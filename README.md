# APS Mobile Application Front-End

## Introduction
This repository contains the front-end code for the APS mobile application. The app is designed to track the installation process of Anderson Power Services' generators, providing transparency for both clients and the business.

## Dependencies
1. **Visual Studio Code**: Recommended for collaboration and development.  
   Download here: [Visual Studio Code](https://code.visualstudio.com/Download)
2. **Java 17-20**: Required for compatibility with back-end services.  
   Download here: [Java JDK 17-20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
3. **Node.js**: Required to run the React Native front-end application.  
   Download here: [Node.js](https://nodejs.org/)
4. **React Native CLI**: Install globally via Node.js for React Native development.  
   Command: `npm install -g react-native-cli`
5. **Android Studio/Xcode**: Required for Android/iOS emulation.  
   - [Android Studio](https://developer.android.com/studio)  
   - [Xcode](https://developer.apple.com/xcode/) (for macOS)

## Getting Started

### Prerequisites
1. Install **Java 17-20** on your local machine.  
   Download here: [Java JDK 17-20](https://www.oracle.com/java/technologies/javase/jdk20-archive-downloads.html)
2. Install **Node.js**.  
   Download here: [Node.js](https://nodejs.org/)
3. Install dependencies: Run `npm install` after cloning the repository.

### Setting Up the Database Connection
1. Ensure the back-end server is configured and running.  
2. Obtain the API endpoint for database communication from the back-end team.  
3. Update the `.env` file in the project root directory with the correct API URL:
   ```plaintext
   API_BASE_URL=<your-backend-api-endpoint>

### Setting up Android Studio 
1. Download Android Studio [Android Studio Download](https://developer.android.com/studio).
2. While on Android Studio installation wizard, make sure the boxes next to all of the following items are checked:

   - Android SDK
   - Android SDK Platform
   - Android Virtual Device
  
3. Open android studio and click "More Actions". 
4. Select "SDK Manager".
5. Select the "SDK Platforms" tab
6. Look for and expand the Android 15 (VanillaIceCream).
7. Make sure the following is checked

   - Android SDK Platform 35
   - Intel x86 Atom_64 System Image or Google APIs Intel x86 Atom System Image or (for Apple M1 Silicon) Google APIs ARM 64 v8a System Image
  
8. Select the "SDK Tools" tab.
9. Check the "Show Package Details" box.
10. Look for and expand the "Android SDK Build-Tools".
11. Make sure that 35.0.0 is selected.
12. Now click "Apply". 

### Installation
1. Clone the repository `git clone https://github.com/IbrahimaDiallo32/Anderson-Power-Services-Mobile-App.git`.
2. Navigate to the project directory: `cd Anderson-Power-Services-Mobile-App`.
3. Open the project in Visual Studio Code.
4. Ensure Java 17-20 is selected as the project JDK for Visual Studio Code.
5. Install the project dependencies: `npm install`.
6. Start the development server: `npx react-native start` or `npm start`.
7. Run the app on a simulator or connected device: [Android] `npx react-native run-android` or [iOS] `npx react-native run-ios`.

### Tips and tools
1. Youtube Video to use as a reference to set up [React Native Environment Setup in Windows (10,11) 2024](https://youtu.be/4onhZMbF2NI?si=Bhz92ZT-X1lBmsKZ).
2. If you are having issues, Try `npx react-native doctor`
3. Make sure you have all the correct paths.
4. If you still have issues, we recommend troubleshooting using Chat GPT and Stack Overflow.

# Directions for setting-up and running the backend environment

## Server, Docker, and WSL2

This project was built and tested to run on Windows Server, as instructed by our client's needs. IIS and whitelisting of IP's and ports need to be configured in order to allow the Database and Spring Boot application to listen for queries and, more importantly, REST API calls comming from the mobile application users.  

It is highly advised to use a server that has AT LEAST 8 gigs of RAM. 4 and lower will only cause the Docker engine to crash during startup. It is intended for Docker continers to be used to host and run the Spring Boot applicaiton, PostgreSQL Database, and pgAdmin4 client, listening to their respective ports.  

WSL 2 (Windows Subsystem for Linux) should be installed on the Windows Server in order to be used as the default distro for Docker to run on. (Reference: Image below)  

![image](https://github.com/user-attachments/assets/e0f6ee2a-8d52-4142-806c-474ecfeefe34)  

## PostgreSQL and pgAdmin 4

Host PostgreSQL and pgAdmin 4 as you'd like, either via Docker containers or using the actual program. This project utilized Postgres 17. It is necessary that you have a user created on the database that has access to modifying and updating tables, which will be controlled by Spring Boot, be sure to gather information of the server IP the database is sitting on and the port (5432 being the default port being used by PostgreSQL).

## Spring Boot Appliation

The following are steps for configuring and running your Spring Boot application.  

### Requirements:

* Java 21
* JDK 21
* Maven (Compiler)
* Intelij IDEA 2024 Ultimate Edition

### Set-up:

Under the Rescources folder, add a file `secrets.properties`. This is what stores the database url, user, pass, and SHA-256 used for hashing passwords generated by users.  
![image](https://github.com/user-attachments/assets/fff2dac8-bdc4-47de-ab66-0b62f398f2a3)  
The format of the file should be:  
```
spring.datasource.url=jdbc:postgresql://<ip>:<port>/<database-name>
spring.datasource.username=<db-user>
spring.datasource.password=<db-user-pass>
my.app.env1=<SHA-256 key of your own choice>
```
This file is then imported into `application.properties`.  
![image](https://github.com/user-attachments/assets/77fc0f6b-e8b3-4d78-b507-25d911974246)  

You should be all set now to compile the project with maven.

### Generate image with JAR file

After you have compiled and packaged the .JAR file, it should be present in the `target` folder. You should then be able to generate a docker image with the generated executable file.  

The following lines should be seen in the Dockerfile:  
```
FROM ubuntu:latest

RUN apt-get update
RUN apt-get -y install default-jre

COPY ./target/*.jar ./app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]
```

In CMD or terminal, change directory over to the repository location of the backend folder (where you openned with intelij) and build the image.  

```
docker build -t <image> .
```

You are now able to send the image over to a private image repository of your choice in order to pull it onto your server machine, where you can then run the image as a container.









# Getting Started

This is a new [**React Native**](https://reactnative.dev) project, bootstrapped using [`@react-native-community/cli`](https://github.com/react-native-community/cli).  

>**Note**: Make sure you have completed the [React Native - Environment Setup](https://reactnative.dev/docs/environment-setup) instructions till "Creating a new application" step, before proceeding.

## Step 1: Start the Metro Server

First, you will need to start **Metro**, the JavaScript _bundler_ that ships _with_ React Native.

To start Metro, run the following command from the _root_ of your React Native project:

```bash
# using npm
npm start

# OR using Yarn
yarn start
```

## Step 2: Start your Application

Let Metro Bundler run in its _own_ terminal. Open a _new_ terminal from the _root_ of your React Native project. Run the following command to start your _Android_ or _iOS_ app:

### For Android

```bash
# using npm
npm run android

# OR using Yarn
yarn android
```

### For iOS

```bash
# using npm
npm run ios

# OR using Yarn
yarn ios
```

If everything is set up _correctly_, you should see your new app running in your _Android Emulator_ or _iOS Simulator_ shortly provided you have set up your emulator/simulator correctly.

This is one way to run your app — you can also run it directly from within Android Studio and Xcode respectively.

## Step 3: Modifying your App

Now that you have successfully run the app, let's modify it.

1. Open `App.tsx` in your text editor of choice and edit some lines.
2. For **Android**: Press the <kbd>R</kbd> key twice or select **"Reload"** from the **Developer Menu** (<kbd>Ctrl</kbd> + <kbd>M</kbd> (on Window and Linux) or <kbd>Cmd ⌘</kbd> + <kbd>M</kbd> (on macOS)) to see your changes!

   For **iOS**: Hit <kbd>Cmd ⌘</kbd> + <kbd>R</kbd> in your iOS Simulator to reload the app and see your changes!

## Congratulations! :tada:

You've successfully run and modified your React Native App. :partying_face:

### Now what?

- If you want to add this new React Native code to an existing application, check out the [Integration guide](https://reactnative.dev/docs/integration-with-existing-apps).
- If you're curious to learn more about React Native, check out the [Introduction to React Native](https://reactnative.dev/docs/getting-started).

# Troubleshooting

If you can't get this to work, see the [Troubleshooting](https://reactnative.dev/docs/troubleshooting) page.

# Learn More

To learn more about React Native, take a look at the following resources:

- [React Native Website](https://reactnative.dev) - learn more about React Native.
- [Getting Started](https://reactnative.dev/docs/environment-setup) - an **overview** of React Native and how setup your environment.
- [Learn the Basics](https://reactnative.dev/docs/getting-started) - a **guided tour** of the React Native **basics**.
- [Blog](https://reactnative.dev/blog) - read the latest official React Native **Blog** posts.
- [`@facebook/react-native`](https://github.com/facebook/react-native) - the Open Source; GitHub **repository** for React Native.
